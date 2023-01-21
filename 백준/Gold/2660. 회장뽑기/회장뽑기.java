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

        int score[] = new int[N+1];
        int min = INF;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(matrix[i][j]>=INF){continue;}
                score[i] = Math.max(score[i], matrix[i][j]);
            }
            min = Math.min(min, score[i]);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(score[i] == min){
                cnt++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(min + " " + cnt);
        System.out.println(sb);

    }
}