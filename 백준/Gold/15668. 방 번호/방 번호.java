import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(-1);

        for(int i = Math.min(N/2, 98765); i>0; i--){
            int j = N-i;
            if(i==j) continue;
            boolean[] used = new boolean[10];

            if(check(i, used) && check(j, used)){
                sb = new StringBuilder();
                sb.append(i).append(" + ").append(j);
                break;
            }
        }
        System.out.println(sb);

    }

    public static boolean check(int su, boolean[] used) {
        while(su > 0){
            int n = su%10;
            if(used[n]) return false;
            used[n] = true;
            su/=10;
        }
        return true;
    }
}