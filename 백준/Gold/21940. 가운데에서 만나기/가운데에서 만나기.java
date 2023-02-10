import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] adjmatrix = new int[N + 1][N + 1];
        final int INF = 2000000;

        for(int i=1; i<=N; i++){
            Arrays.fill(adjmatrix[i], INF);
            adjmatrix[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjmatrix[n1][n2] = cost;
        }

        int C = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int cities[] = new int[C];
        for(int i=0; i<C; i++){
            cities[i] = Integer.parseInt(st.nextToken());
        }

        //floyd warshall
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    adjmatrix[i][j] = Math.min(adjmatrix[i][j], adjmatrix[i][k] + adjmatrix[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int min = INF;
        for(int i=1; i<=N; i++){
            int max = 0;
            for(int city : cities){
                max = Math.max(max, adjmatrix[i][city] + adjmatrix[city][i]);
            }
            if(max == min){
                sb.append(" ").append(i);
            }
            else if(max < min){
                min = max;
                sb = new StringBuilder();
                sb.append(i);
            }
        }
        System.out.println(sb);

    }
}
