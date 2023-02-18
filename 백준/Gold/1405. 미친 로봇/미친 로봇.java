import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static double result;
    static double[] percent;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[30][30];
        percent = new double[4];
        for(int i=0; i<4; i++){
            percent[i] = Integer.parseInt(st.nextToken())*0.01;
        }
        visited[15][15] = true;
        dfs(15, 15, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int cnt, double p){
//        if(p==0){
//            return;
//        }
        if(cnt == N){
            result += p;
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(visited[nx][ny]){continue;}
            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1, p*percent[i]);
            visited[nx][ny] = false;
        }
    }

}