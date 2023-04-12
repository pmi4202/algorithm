import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//국가 수
            int M = Integer.parseInt(st.nextToken());//비행기 수
            for(int i=0; i<M; i++){
                br.readLine();
            }
            //
            sb.append(N-1).append("\n");
        }
        System.out.println(sb);
    }
}