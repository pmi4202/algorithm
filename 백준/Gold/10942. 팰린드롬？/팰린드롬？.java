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
        dp = new int[N+1][N+1];//non, false, true
        arr =  new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(isP(S, E)-1).append("\n");
        }
        System.out.println(sb);
    }

    public static int isP(int S, int E){
        if(S >= E){
            return 2;
        }

        if(dp[S][E] == 0){
            if(arr[S] == arr[E]){
                dp[S][E] = isP(S+1, E-1);
            }
            else{
                dp[S][E] = 1;
            }
        }

        return dp[S][E];
    }
}