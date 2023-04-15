import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //가로, 세로
        for(int i=1; i<N; i++){
            map[i][0] += map[i-1][0];
        }
        for(int i=1; i<M; i++){
            map[0][i] += map[0][i-1];
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                map[i][j] += Math.max(Math.max(map[i-1][j], map[i-1][j-1]), map[i][j-1]);
            }
        }
        System.out.println(map[N-1][M-1]);
    }
}