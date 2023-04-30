import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        while(K-- > 0){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                result -= stack.pop();
            }
            else{
                result += n;
                stack.push(n);
            }
        }
        System.out.println(result);
    }
}