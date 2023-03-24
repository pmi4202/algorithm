import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Integer> height = new Stack<>();

        height.push(500001);
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while(!height.isEmpty() && height.peek() > y){
                height.pop();
                result++;
            }
            if(y==0) continue;
            if(height.isEmpty() || height.peek()!=y){
                height.push(y);
            }
        }
        result+=height.size();
        System.out.println(result-1);
    }
}