import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][], dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static boolean visited[][];
    static Queue<int[]> next;

    public static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]){
                continue;
            }
            if(map[nx][ny] > 0){
                if(++map[nx][ny] == 3){
                    next.add(new int[]{nx, ny});
                }
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }

    public static int bfs(){
        int time = -1;
        while(next.size() > 0) {
            for (int i = 0, size = next.size(); i < size; i++) {
                int[] now = next.poll();
                visited[now[0]][now[1]] = true;
                dfs(now[0], now[1]);
            }
            time++;
        }

        return time;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        next = new LinkedList<>();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        next.add(new int[]{0, 0});
        System.out.println(bfs());
    }
}