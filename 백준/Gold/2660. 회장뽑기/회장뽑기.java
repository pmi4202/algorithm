import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N+1][N+1];
        final int INF = 100;

        for(int i=1; i<=N; i++){
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            if(p1 == -1){
                break;
            }
            matrix[p1][p2] = matrix[p2][p1] = 1;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(i==k || matrix[i][k] == INF){continue;}
                for(int j=1; j<=N; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        StringBuilder sb = null;
        int cnt = 0, min = INF;
        for(int i=1; i<=N; i++){
            int score = 0;
            for(int j=1; j<=N; j++){
                if(matrix[i][j]>=INF){continue;}
                score = Math.max(score, matrix[i][j]);
            }
            if(score < min){
                min = score;
                sb = new StringBuilder();
                cnt = 1;
                sb.append(i);
            } else if (score == min) {
                cnt++;
                sb.append(" ").append(i);
            }
        }
        System.out.println(min + " " + cnt);
        System.out.println(sb);

    }
}