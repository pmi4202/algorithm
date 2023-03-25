import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        if(N<=2){
            System.out.println(0);
            return;
        }
        
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = 0;
        for(int i=0; i<N; i++){
            result += canMake(i);
        }
        System.out.println(result);
    }

    public static int canMake(int idx){
        int l = 0, r = N-1, now = arr[idx];

        while(true){
            if(l==idx) l++;
            else if(r==idx) r--;
            if(l >= r) break;

            int sum = arr[l] + arr[r];
            if(sum == now){
                return 1;
            }
            else if(sum < now){
                l++;
            }
            else{
                r--;
            }
        }
        return 0;
    }
}