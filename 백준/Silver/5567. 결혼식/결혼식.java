import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        int result = 0;
        boolean[][] adjmatrix = new boolean[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<L; i++){
            String[] inputs = br.readLine().split(" ");
            int n1 = Integer.parseInt(inputs[0]);
            int n2 = Integer.parseInt(inputs[1]);
            adjmatrix[n1][n2] = true;
            adjmatrix[n2][n1] = true;
        }

        visited[1] = true;
        for(int i=2; i<=N; i++){
            if(adjmatrix[1][i]) {
                visited[i] = true;
                for (int j = 2; j <= N; j++) {
                    if (adjmatrix[i][j]) {
                        visited[j] = true;
                    }
                }
            }
        }

        for(int i=2; i<=N; i++){
            if(visited[i]){
                result++;
            }
        }

        System.out.println(result);
    }
}
