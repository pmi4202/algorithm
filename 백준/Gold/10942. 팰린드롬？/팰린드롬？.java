import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];
        arr =  new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 1;
            if(arr[i-1] == arr[i]){
                dp[i-1][i] = 1;
            }
        }

        for(int i=2; i<=N; i++){//간격
            for(int j=i; j<=N; j++){//기준
                if(arr[j-i] == arr[j] && dp[j-i+1][j-1] == 1){
                    dp[j-i][j] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E]).append("\n");
        }
        System.out.println(sb);
    }
}