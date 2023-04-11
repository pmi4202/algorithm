import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=9; i++){
            dfs(N/2, i, 0 | (1<<i));
        }

        if(result == 0){
            System.out.println("-1");
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(result).append(" + ").append(N-result);
            System.out.println(sb);
        }
    }

    public static void dfs(int half, int su, int used){
        if(su > half || result > 0){
            return;
        }

        int n2 = N - su;
        int visited = used;
        while(n2 > 0){
            int temp = n2%10;
            if((visited & (1<<temp)) > 0){
                break;
            }
            visited |= (1<<temp);
            n2/=10;
        }
        if(n2==0){
            result = su;
            return;
        }

        for(int i=0; i<=9; i++){
            if((used & (1<<i)) > 0) continue;
            dfs(half, su*10 + i, used | (1<<i));
        }
    }

}