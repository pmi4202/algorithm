import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min, max;
    static int[] arr, operation;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operation = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }

        calculator(1, arr[0]);

        System.out.println(max +"\n" +min);
    }

    public static void calculator(int idx, int num){
        if(idx >= N){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        if(operation[0] > 0){
            operation[0]--;
            calculator(idx+1, num + arr[idx]);
            operation[0]++;
        }
        if(operation[1] > 0){
            operation[1]--;
            calculator(idx+1, num - arr[idx]);
            operation[1]++;
        }
        if(operation[2] > 0){
            operation[2]--;
            calculator(idx+1, num * arr[idx]);
            operation[2]++;
        }
        if(operation[3] > 0){
            operation[3]--;
            calculator(idx+1, num / arr[idx]);
            operation[3]++;
        }
    }

}