import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] broken;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if(M!=0) {
            st = new StringTokenizer(br.readLine());
            while (M-- > 0) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        if(N==100){
            System.out.println(0);
            return;
        }
        else{
            int min = Math.abs(100 - N);
            for(int i=0; i<min; i++){
                if(i <= N){
                    int l = N-i;
                    if(canPress(l)){
                        min = Math.min(min, i + getLen(l));
                        break;
                    }
                }
                int r = N+i;
                if(canPress(r)){
                    min = Math.min(min, i + getLen(r));
                    break;
                }
            }
            System.out.println(min);
        }

    }

    public static boolean canPress(int number){
        while(number >= 10){
            int btn = number%10;
            if(broken[btn]) return false;
            number /= 10;
        }
        return !broken[number];
    }

    public static int getLen(int number){
        int cnt = 1;
        while(number >= 10){
            number /= 10;
            cnt++;
        }
        return cnt;
    }
}