import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, size;
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static char map[][];

    public static void dfs(int x, int y){
        size++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '0'){
                continue;
            }
            map[nx][ny] = '0';
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int cnt = 0, max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == '1'){
                    size = 0;
                    map[i][j] = '0';
                    dfs(i, j);
                    max = Math.max(max, size);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
}