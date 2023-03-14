import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] cnt = new int[26];

        //init
        String input = br.readLine();
        int len = input.length();
        for(int i = 0; i < len; i++){
            cnt[input.charAt(i)-'A']++;
        }

        //solve
        while(N-- > 1){
            String word = br.readLine();
            int max, min;
            if(word.length() < len){
                max = len;
                min = word.length();
            }
            else{
                max = word.length();
                min = len;
            }

            if(max - min >= 2){
                continue;
            }

            int same = 0;
            int[] wcnt = new int[26];
            for(int i=word.length()-1; i>=0; i--){
                int now = word.charAt(i)-'A';
                if(++wcnt[now] <= cnt[now]){
                    same++;
                }
            }

            if(Math.abs(same - max) <= 1){
                result++;
            }
        }
        System.out.println(result);

    }
}