import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int n1 = X, n2 = Y;
        while(n2 > 0){
            n1%=n2;
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        for(int i=(int)Math.sqrt(n1); i>0; i--){
            if(n1%i==0){
                sb.append(i).append(" ")
                        .append(X/i).append(" ")
                        .append(Y/i).append("\n");
                int next = n1/i;
                if(next != i){
                    sb.append(next).append(" ")
                            .append(X/next).append(" ")
                            .append(Y/next).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}