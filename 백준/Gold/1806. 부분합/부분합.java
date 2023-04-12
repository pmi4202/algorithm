import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, result = 100_001;
        long sum = 0;
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(l < N){
            sum -= arr[l];
            l++;
            while(r < N && sum < S){
                sum += arr[++r];
            }
            if(sum >= S){
                result = Math.min(result, r-l+1);
            }
        }
        System.out.println((result > N) ? 0 : result);
    }
}