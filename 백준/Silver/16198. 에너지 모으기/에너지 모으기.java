import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(arr, N, 0);
        System.out.println(result);

    }

    public static void solve(int[] arr, int size, int energy){
        if(size == 2){
            result = Math.max(result, energy);
            return;
        }

        for(int i=1; i<size-1; i++){
            int[] newArr =  new int[size - 1];
            int idx = 0;
            for(int j=0; j<i; j++){
                newArr[idx++] = arr[j];
            }

            for(int j=i+1; j<size; j++){
                newArr[idx++] = arr[j];
            }
            solve(newArr, size - 1, energy + (arr[i-1] * arr[i+1]));
        }

    }
}