import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] selected;
    static StringBuilder result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        result = new StringBuilder();
        N = input.charAt(0)-'0';
        M = input.charAt(2)-'0';
        selected = new int[M];
        permutation(0, 0);
        System.out.println(result);
    }

    public static void permutation(int cnt, int visited){
        if(cnt == M){
            for(int n : selected){
                result.append(n).append(" ");
            }
            result.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            if((visited & (1<<i)) > 0) continue;
            selected[cnt] = i;
            permutation(cnt + 1, visited | (1<<i));
        }
    }
}