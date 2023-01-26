import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int result;

    public static void check(String s, int left, int right, int dif){
        if(dif >= 2){//다른 문자가 2개 이상이면
            return;
        }
        if(left > right){
            result = Math.min(result, dif);
            return;
        }

        if(s.charAt(left) == s.charAt(right)){
            check(s, left + 1, right - 1, dif);
        }
        else{
            check(s, left + 1, right, dif + 1);
            check(s, left, right - 1, dif + 1);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            result = 2;
            String input = br.readLine();
            check(input, 0, input.length() - 1, 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}