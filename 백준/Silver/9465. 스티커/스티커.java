import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            int[][] map = new int[2][n+2];
            for(int i=1; i<=n; i++){
                map[0][i] += Integer.parseInt(st1.nextToken());
                map[1][i] += Integer.parseInt(st2.nextToken());
                map[0][i+1] = Math.max(map[1][i-1], map[1][i]);
                map[1][i+1] = Math.max(map[0][i-1], map[0][i]);
            }

            sb.append(Math.max(map[0][n+1], map[1][n+1])).append("\n");
        }
        System.out.println(sb);
    }
}