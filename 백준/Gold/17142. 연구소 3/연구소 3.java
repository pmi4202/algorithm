import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, blank, min;
    static int[][] map;
    static List<Node> virus;

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
                min = 0;
            }
            else{
                selectVirus(0, 0, new Node[M]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virus = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    blank++;
                }
                else if(map[i][j] == 2){
                    virus.add(new Node(i, j));
                }
            }
        }
    }

    public static void selectVirus(int cnt, int idx, Node[] selectedVirus){
        if(cnt >= M){
            getMinTime(selectedVirus);
            return;
        }

        for(int i=idx; i<virus.size(); i++){
            selectedVirus[cnt] = virus.get(i);
            selectVirus(cnt + 1, i + 1, selectedVirus);
        }
    }

    public static void getMinTime(Node[] viruses){
        //1이 아닌 모든 곳에 퍼트리기 가능
        //2만 남았으면 cnt할 필요 없음
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        //1. virus 위치 넣기
        for(Node virus : viruses){
            visited[virus.x][virus.y] = true;
            q.add(virus);
        }

        //2. 퍼트리기
        int result = 0, infected = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node now = q.poll();
                if(map[now.x][now.y] == 0){
                    infected++;
                }
                for(int i=0; i<4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if(map[nx][ny] != 1){
                        q.add(new Node(nx, ny));
                    }
                }
            }
            //다 감염시켰으면 종료
            if(infected == blank){
                min = Math.min(min, result);
                return;
            }
            result++;
        }
        
    }

}