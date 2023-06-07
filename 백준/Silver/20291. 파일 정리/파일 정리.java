import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String input;
        while(N-- > 0){
            input = br.readLine().split("[.]")[1];
            map.put(input, map.getOrDefault(input, 0)+1);
        }

        map.keySet().stream().sorted().forEach((key)->{
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        });
        System.out.println(sb);
    }
}