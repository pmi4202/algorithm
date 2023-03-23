import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, score, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if(N==0){
            System.out.println(1);
        }
        else{
            int[] arr =  new int[N+2];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(P==N && arr[N]>=score){
                System.out.println(-1);
            }
            else{
                int idx =  1;
                while(idx<=N && arr[idx] > score){
                    idx++;
                }
                System.out.println(idx);
            }
        }

    }

}