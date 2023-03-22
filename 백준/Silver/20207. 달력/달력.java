import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] arr = new int[366];

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for(int i=S; i<=E; i++){
                arr[i]++;
            }
        }

        int idx = 1;
        while(idx <= 365){
            while(idx<=365 && arr[idx]==0) idx++;
            int cnt = 0, max = 0;
            while(idx<=365 && arr[idx]!=0){
                cnt++;
                max = Math.max(max, arr[idx]);
                idx++;
            }
            result+=cnt*max;
        }
        System.out.println(result);

    }
}