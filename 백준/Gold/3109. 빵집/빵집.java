import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[] dx = {-1, 0, 1};
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for(int i=0; i<R; i++){
            if(map[i][0] == 'x') continue;
            answer += dfs(i, 0);
        }
        System.out.println(answer);
    }

    public static int dfs(int x, int y){
        if(y == C-1){
            return 1;
        }

        map[x][y] = 'x';
        for(int i=0; i<3; i++){
            int nx = x + dx[i];
            int ny = y + 1;
            if(nx<0 || nx>=R || map[nx][ny] == 'x') continue;
            if(dfs(nx, ny) == 1) return 1;
        }
        return 0;
    }
}