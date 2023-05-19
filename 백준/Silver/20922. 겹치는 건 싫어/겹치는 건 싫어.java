import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int start = 0;
        int[] count = new int[100_001];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(count[arr[i]] >= K){
                count[arr[start++]]--;
            }
            count[arr[i]]++;
            result = Math.max(result, i-start+1);
        }
        System.out.println(result);
    }
}