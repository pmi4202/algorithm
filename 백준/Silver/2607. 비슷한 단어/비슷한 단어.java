import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] cnt = new int[30];

        //init
        String input = br.readLine();
        for(int i = input.length()-1; i>=0; i--){
            cnt[input.charAt(i)-'A']++;
        }

        //solve
        while(N-- > 1){
            String word = br.readLine();
            int diff = 0, lenGap = Math.abs(word.length() - input.length());

            if(lenGap >= 2){
                continue;
            }

            int[] wcnt = new int[30];
            for(int i=word.length()-1; i>=0; i--){
                int now = word.charAt(i)-'A';
                if(++wcnt[now] > cnt[now]){
                    diff++;
                }
            }
            if(word.length() < input.length()){
                diff++;
            }

            if(diff <= 1){
                result++;
            }
        }
        System.out.println(result);

    }
}