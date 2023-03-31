import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[] dx = {-1, 0, 1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for(int i=0; i<R; i++){
            if(map[i][0] == 'x') continue;
            if(dfs(i, 0)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean dfs(int x, int y){
        if(y == C-1){
            return true;
        }

        visited[x][y] = true;
        for(int i=0; i<3; i++){
            int nx = x + dx[i];
            int ny = y + 1;
            if(nx<0 || nx>=R || map[nx][ny] == 'x' || visited[nx][ny]) continue;
            if(dfs(nx, ny)) return true;
        }
//        visited[x][y] = false;
        return false;
    }
}