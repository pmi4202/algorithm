import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, blank, result;
    static int[][] map;
    static int[][][] distance;
    static List<Node> viruses;

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        try{
            init();
            if(blank == 0){
                result = 0;
            }
            else{
                for(int i=viruses.size()-1; i>=0; i--){
                    updateDistance(i);
                }
                selectVirus(0, 0, new int[M]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        viruses = new ArrayList<>();
        result = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    blank++;
                }
                else if(map[i][j] == 2){
                    viruses.add(new Node(i, j));
                }
            }
        }
        distance = new int[viruses.size()][N][N];
    }

    public static void updateDistance(int idx){
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            Arrays.fill(distance[idx][i], Integer.MAX_VALUE);
        }
        //1. virus 위치 넣기
        Node virus = viruses.get(idx);
        distance[idx][virus.x][virus.y] = 0;
        q.add(virus);

        //2. 퍼트리기
        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]==1) continue;

                if(distance[idx][nx][ny] == Integer.MAX_VALUE){
                    distance[idx][nx][ny] = distance[idx][now.x][now.y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    public static void selectVirus(int cnt, int idx, int[] selectedVirus){
        if(cnt >= M){
            result = Math.min(result, getMinTime(selectedVirus));
            return;
        }

        for(int i=idx; i<viruses.size(); i++){
            selectedVirus[cnt] = i;
            selectVirus(cnt + 1, i + 1, selectedVirus);
        }
    }

    public static int getMinTime(int[] selectedVirus){
        int maxDistance = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 0) continue;

                int min =  distance[selectedVirus[0]][i][j];
                for(int k=1; k<M; k++){
                    min = Math.min(min, distance[selectedVirus[k]][i][j]);
                }
                maxDistance = Math.max(maxDistance, min);
            }
        }
        return maxDistance;
    }

}