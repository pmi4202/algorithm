import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.parseInt(br.readLine()));

        int max = stack.peek();
        for(int i=1; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            max = Math.max(max, now);
            //같은 수면 continue
            if(now < stack.peek()){
                stack.pop();
                stack.add(now);
            }
            else if(now > stack.peek()){
                result += now - stack.pop();
                stack.add(now);
            }
        }

        while(!stack.isEmpty()){
            result += max - stack.pop();
        }

        System.out.println(result);
    }
}