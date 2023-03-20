import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
첫 번째 원소를 눌렀을 때, 누르지 않았을 때 중 최소 값을 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] now1 = br.readLine().toCharArray();
        char[] now2 = Arrays.copyOf(now1, N);
        char[] goal = br.readLine().toCharArray();
        int result = Integer.MAX_VALUE;

        //1번 스위치 안 눌렀을 때
        int t1 = 0;
        for(int i=1; i<N-1; i++){
            if(now1[i-1] != goal[i-1]){
                t1++;
                for(int j=-1; j<=1; j++){
                    now1[i+j] = (now1[i+j] == '0') ? '1' : '0';
                }
            }
        }

        if(now1[N-2] != goal[N-2]){
            t1++;
            now1[N-2] = (now1[N-2] == '0') ? '1' : '0';
            now1[N-1] = (now1[N-1] == '0') ? '1' : '0';
        }
        if(now1[N-1] == goal[N-1]){
            result = t1;
        }

        //1번 스위치 눌렀을 때
        t1 = 1;
        now2[0] = (now2[0] == '0') ? '1' : '0';
        now2[1] = (now2[1] == '0') ? '1' : '0';
        for(int i=1; i<N-1; i++){
            if(now2[i-1] != goal[i-1]){
                t1++;
                for(int j=-1; j<=1; j++){
                    now2[i+j] = (now2[i+j] == '0') ? '1' : '0';
                }
            }
        }

        if(now2[N-2] != goal[N-2]){
            t1++;
            now2[N-2] = (now2[N-2] == '0') ? '1' : '0';
            now2[N-1] = (now2[N-1] == '0') ? '1' : '0';
        }
        if(now2[N-1] == goal[N-1]){
            result = Math.min(result, t1);
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}