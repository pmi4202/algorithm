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

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int prev = (map[i][j] + 2)%3;
                //위
                int x = i - 1;
                int y = j - 1;
                for(int k=0; k<=2; k++){
                    result[i][j][k] = Math.max(0<=x ? result[x][j][k] : 0, 0<=y ? result[i][y][k] : 0);
                }
                if(result[i][j][prev]> 0){
                    result[i][j][map[i][j]] = Math.max(result[i][j][map[i][j]], result[i][j][prev] + 1);
                }
                
                if(map[i][j] == 0 && result[i][j][0] == 0){
                    result[i][j][0] = 1;
                }

            }
        }
        System.out.println(Math.max(Math.max(result[N-1][N-1][0], result[N-1][N-1][1]), result[N-1][N-1][2]));
    }

}