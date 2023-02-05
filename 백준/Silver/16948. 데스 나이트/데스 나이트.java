import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, ex, ey;
    static int[] dx = {-2, -2, 0, 0, 2, 2}, dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        System.out.println(bfs(sx, sy));
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int result = 0;

        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            for(int i = 0, size = q.size(); i < size; i++) {
                int[] now = q.poll();
                if(now[0] == ex && now[1] == ey){
                    return result;
                }
                for(int j = 0; j < 6; j++){
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]){ continue;}
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
            result++;
        }
        return -1;
    }
}