import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] up;//증가량

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        up = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(map[i], 1);
        }

        while(day-- > 0){
            st = new StringTokenizer(br.readLine());
            int[] fixed = new int[3];
            for(int i=0; i<3; i++){
                fixed[i] = Integer.parseInt(st.nextToken());
            }
            //정해진 것
            int idx = 0;
            for(int i=N-1; i>0; i--){
                while(fixed[idx]==0){
                    idx++;
                }
                map[i][0] += idx;
                up[i][0] = idx;
                fixed[idx]--;
            }
            for(int i=0; i<N; i++){
                while(fixed[idx]==0){
                    idx++;
                }
                map[0][i] += idx;
                up[0][i] = idx;
                fixed[idx]--;
            }
            //
            solve();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void solve(){
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                up[i][j] = Math.max(up[i-1][j], up[i-1][j-1]);
                up[i][j] = Math.max(up[i][j], up[i][j-1]);
                map[i][j] += up[i][j];
            }
        }
    }
}