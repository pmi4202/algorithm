import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int[] dp = new int[K+1];

        if(K <= N){
            System.out.println(N-K);
        }
        else{
            //N보다 작은 값은 빼기로 가는게 가장 빠름
            for(int i=0; i<N; i++){
                dp[i] = N-i;
            }
            for(int i=N+1; i<=K; i++){
                dp[i] = dp[i-1] + 1;
                if(i%2==0){
                    dp[i] = Math.min(dp[i/2], dp[i-1] + 1);
                }
                else{
                    int min = Math.min(dp[(i-1)/2] + 1, dp[(i+1)/2] + 1);
                    dp[i] = Math.min(dp[i-1] + 1, min);
                }

            }
            System.out.println(dp[K]);
        }

    }
}