import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            if(i+day <= N){
                dp[i+day] = Math.max(dp[i+day], dp[i] + price);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);

        }
        System.out.println(dp[N]);
    }
}