import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N+1];
        int size = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(result[size] < arr[i]){
                result[++size] = arr[i];
            }
            else{
                int pos = getPos(result, arr[i], size);
                result[pos] = arr[i];
            }
            
        }

        System.out.println(size);

    }

    public static int getPos(int[] result, int now, int r){
        int l = 0;
        while(l < r){
            int mid = (l + r)/2;
            if(result[mid] < now){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
}