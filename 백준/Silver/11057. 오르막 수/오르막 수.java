import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;
        int[] count = new int[10];
        Arrays.fill(count, 1);

        while(N-- > 0){
            for(int i=1; i<=9; i++){
                count[i] = (count[i] + count[i-1])%10007;
            }
        }

        int result = 0;
        for(int i=0; i<10; i++){
            result = (result + count[i])%10007;
        }
        System.out.println(result);

    }
}