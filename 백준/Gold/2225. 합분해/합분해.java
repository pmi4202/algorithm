import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int[] dp = new int[N+1];
        Arrays.fill(dp, 1);

        while(K-- > 0){
            for(int i=N-1; i>=0; i--){
                dp[i] = (dp[i] + dp[i+1])%1_000_000_000;
            }
        }
        System.out.println(dp[0]);
    }
}