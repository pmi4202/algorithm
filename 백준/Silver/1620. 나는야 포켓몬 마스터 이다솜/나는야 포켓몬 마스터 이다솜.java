import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[N + 1];
        for(int i=1; i<=N; i++){
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        while(M-- > 0){
            String input = br.readLine();
            if(input.charAt(0) <= '9'){//숫자
                sb.append(arr[Integer.parseInt(input)]);
            }
            else{
                sb.append(map.get(input));
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}