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

        for(int i=1; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            //같은 수면 continue
            if(now < stack.peek()){
//                result += stack.peek() - now;
                stack.add(now);
            }
            else if(now > stack.peek()){
                result += now - stack.peek();
//                int prev = now;
                do{
                    int temp = stack.pop();
//                    result += prev - temp;
//                    prev = temp;
                }while(!stack.isEmpty() && now > stack.peek());
                stack.add(now);
            }
        }

        if(stack.size() > 0){
            int prev = stack.pop();
            while(!stack.isEmpty()){
                int next = stack.pop();
                result += next - prev;
                prev = next;
            }
        }

        System.out.println(result);
    }
}