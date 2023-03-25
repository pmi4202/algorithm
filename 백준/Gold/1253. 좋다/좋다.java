import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int result = 0;
        for(int i=0; i<N; i++){
            if(canMake(i)) result++;
        }
        System.out.println(result);
    }

    public static boolean canMake(int idx){
        int l = 0, r = N-1;
        long now = arr[idx];
        while(true){
            if(l==idx) l++;
            if(r==idx) r--;
            if(l >= r) break;
            long temp = arr[l] + arr[r];
            if(temp == now){
                return true;
            }
            else if(temp < now){
                l++;
            }
            else{
                r--;
            }
        }
        return false;
    }
}