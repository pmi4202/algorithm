import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1002];
        int maxIdx = 0, max = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            arr[idx] = Integer.parseInt(st.nextToken());
            if(max < arr[idx]){
                max = arr[idx];
                maxIdx = idx;
            }
        }

        int result = 0;
        for(int i=1; i<=maxIdx; i++){
            if(arr[i-1] > arr[i]){
                arr[i] = arr[i-1];
            }
            result += arr[i];
        }
        for(int i=1000; i>maxIdx; i--){
            if(arr[i+1] > arr[i]){
                arr[i] = arr[i+1];
            }
            result += arr[i];
        }
        System.out.println(result);

    }
}