import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(result[j]==0){
                    if(cnt++ == arr[i]){
                        result[j] = i;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int su : result){
            sb.append(su).append(" ");
        }
        System.out.println(sb);

    }

}