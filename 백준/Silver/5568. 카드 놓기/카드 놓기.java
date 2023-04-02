import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int N, K;
    static int[] arr;
    static HashSet<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        set = new HashSet<>();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        permutation(0, 0, 0);
        System.out.println(set.size());
    }

    public static void permutation(int cnt, int num, int visited){
        if(cnt >= K){
            set.add(num);
            return;
        }
        for(int i=0; i<N; i++){
            if((visited & (1<<i)) > 0) continue;
            int temp = (arr[i]/10 > 0) ? 100 : 10;
            permutation(cnt+1, num*temp + arr[i], visited | (1<<i));
        }

    }
}