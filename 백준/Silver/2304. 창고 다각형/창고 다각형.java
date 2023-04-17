import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
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

        int result = 0, temp = 0;
        for(int i=1; i<=maxIdx; i++){
            if(temp < arr[i]){
                temp = arr[i];
            }
            result += temp;
        }
        temp = 0;
        for(int i=1000; i>maxIdx; i--){
            if(temp < arr[i]){
                temp = arr[i];
            }
            result += temp;
        }
        System.out.println(result);

    }
}