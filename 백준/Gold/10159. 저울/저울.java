import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean arr[][] = new boolean[N + 1][N + 1];

        for(int i=1; i<=N; i++){
            arr[i][i] = true;
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(arr[i][k] && arr[k][j]){
                        arr[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int cnt = N + 1;
            for(int j=1; j<=N; j++){
                if(arr[i][j]) cnt--;
                if(arr[j][i]) cnt--;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}