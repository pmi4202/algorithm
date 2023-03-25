import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1], dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=X; i++){
            dp[X] += arr[i];
        }

        int max = dp[X], cnt = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=X+1; i<=N; i++){
            dp[i] = arr[i] + dp[i-1] - arr[i-X];
            if(max < dp[i]){
                max = dp[i];
                cnt = 1;
            }
            else if(max == dp[i]){
                cnt++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        }
        else{
            sb.append(max).append("\n").append(cnt);
            System.out.println(sb);
        }

    }
}