import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] now1 = br.readLine().toCharArray();
        char[] now2 = Arrays.copyOf(now1, N);
        char[] goal = br.readLine().toCharArray();

        //1번 스위치 안 눌렀을 때 vs 눌렀을 때
        now2[0] = (now2[0] == '0') ? '1' : '0';
        now2[1] = (now2[1] == '0') ? '1' : '0';
        int result = Math.min(switching(now1, goal, 0), switching(now2, goal, 1));

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static int switching(char[] now, char[] goal, int res){
        for(int i=1; i<N-1; i++){
            if(now[i-1] != goal[i-1]){
                res++;
                for(int j=-1; j<=1; j++){
                    now[i+j] = (now[i+j] == '0') ? '1' : '0';
                }
            }
        }

        if(now[N-2] != goal[N-2]){
            res++;
            now[N-2] = (now[N-2] == '0') ? '1' : '0';
            now[N-1] = (now[N-1] == '0') ? '1' : '0';
        }

        if(now[N-1] == goal[N-1]){
            return res;
        }
        else{
            return Integer.MAX_VALUE;
        }
    }
}