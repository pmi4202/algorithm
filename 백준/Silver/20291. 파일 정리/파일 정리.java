import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String input;
        while(N-- > 0){
            input = br.readLine();
            String extension = input.substring(input.indexOf(".")+1);
            map.put(extension, map.getOrDefault(extension, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(" ")
                    .append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }
}