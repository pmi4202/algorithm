import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];

        int result = 0;

        for(int i=1; i<=N; i++){
            String input = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = input.charAt(j-1)-'0';
                if(map[i][j] == 0){ continue;}
                if(map[i-1][j] != 0 && map[i-1][j-1] != 0 && map[i][j-1] != 0){
                    int min = Math.min(map[i-1][j], Math.min(map[i-1][j-1], map[i][j-1]));
                    map[i][j] = min + 1;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        System.out.println(result*result);
    }
}