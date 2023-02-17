import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = 1;

        while(A < B){
            if(B%2==0){//짝
                B/=2;
            }
            else{//홀
                if(B%10==1){
                    B/=10;
                }
                else{
                    break;
                }
            }
            result++;
        }

        if(A!=B){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }

    }
}