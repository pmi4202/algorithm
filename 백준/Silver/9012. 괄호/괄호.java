import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            sb.append(checkSet(br.readLine()));
        }
        System.out.println(sb);
    }

    public static String checkSet(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0, size = s.length(); i<size; i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }
            else{
                if(stack.isEmpty() || stack.peek() == ')') return "NO\n";
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES\n" : "NO\n";
    }
}