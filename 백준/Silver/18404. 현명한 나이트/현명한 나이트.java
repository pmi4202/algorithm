import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] result, dx = {-2, -2, -1, -1, 1, 1, 2, 2}, dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M + 1];//주어진 말 순서대로 결과를 저장
        map = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i;
        }

        //
        bfs(x, y);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=M; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y){
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        int time = 0, cnt = 0;
        while(!q.isEmpty()){
            time++;
            for(int i=0, size = q.size(); i<size; i++){
                int[] now = q.poll();
                for(int j=0; j<8; j++){
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx<=0 || nx>N || ny<=0 || ny>N || visited[nx][ny]){
                        continue;
                    }
                    if(map[nx][ny] > 0){
                        result[map[nx][ny]] = time;
                        if(++cnt == M){
                            return;
                        }
                    }
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

        }
    }
}