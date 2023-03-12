import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, result;
    static int[] kits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kits = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            kits[i] = Integer.parseInt(st.nextToken()) - K;
        }

        permutation(0, 500, 0);
        System.out.println(result);
    }

    public static void permutation(int day, int weight, int visited){
        if(day == N){
            result++;
            return;
        }

        for(int i=0; i<N; i++){
            if((visited & (1<<i)) > 0) continue;
            if(weight + kits[i] < 500) continue;
            permutation(day+1, weight + kits[i], visited | (1<<i));
        }
    }
}