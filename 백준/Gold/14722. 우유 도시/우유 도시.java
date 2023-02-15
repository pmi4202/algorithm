import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[][][] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[N][N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(Math.max(Math.max(result[N-1][N-1][0], result[N-1][N-1][1]), result[N-1][N-1][2]));
    }

    public static void solve(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                //위
                int x = i - 1;
                if(0<=x && x<N){
                    for(int k=0; k<=2; k++){
                        if(k==map[i][j] && result[x][j][(map[i][j] + 2)%3] > 0){
                            result[i][j][k] = Math.max(result[x][j][k], result[x][j][(map[i][j] + 2)%3] + 1);
                        }
                        else{
                            result[i][j][k] = result[x][j][k];
                        }
                    }

                }
                //왼
                int y = j - 1;
                if(0<=y && y<N){
                    for(int k=0; k<=2; k++){
                        if(k==map[i][j] && result[i][y][(map[i][j] + 2)%3] > 0){
                            int temp = Math.max(result[i][y][k], result[i][y][(map[i][j] + 2)%3] + 1);
                            result[i][j][k] = Math.max(result[i][j][k], temp);
                        }
                        else{
                            result[i][j][k] = Math.max(result[i][j][k], result[i][y][k]);
                        }
                    }

                }
                if(map[i][j] == 0 && result[i][j][0] == 0){
                    result[i][j][0] = 1;
                }

            }
        }
    }
}