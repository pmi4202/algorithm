import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int dir){
        if(x>N || y>N || map[x][y] == 1) return;
        if(dir==2 && (map[x-1][y] == 1 || map[x][y-1] == 1)) return;
        if(x==N && y==N){
            result++;
            return;
        }

        switch (dir){
            case 0:
                dfs(x, y+1, 0);
                dfs(x+1, y+1, 2);
                break;
            case 1:
                dfs(x+1, y, 1);
                dfs(x+1, y+1, 2);
                break;
            case 2:
                dfs(x, y+1, 0);
                dfs(x+1, y, 1);
                dfs(x+1, y+1, 2);
        }

    }
}