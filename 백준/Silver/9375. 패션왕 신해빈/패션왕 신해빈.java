import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            int[] count = new int[30];
            int idx = 0;
            while(n-- > 0){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                if(!map.containsKey(kind)){
                    map.put(kind, idx);
                    idx++;
                }
                count[map.get(kind)]++;
            }

            int result = 1;
            for(int i=0; i<idx; i++){
                result *= (count[i] + 1);
            }
            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}