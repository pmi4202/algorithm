import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), top = -1;
        int[] arr = new int[N];
        int[] stack = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int now = 1;
        for(int su : arr){
            while(now <= su){
                stack[++top] = now++;
                sb.append("+\n");
            }
            if(su != stack[top]){
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
            top--;
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}