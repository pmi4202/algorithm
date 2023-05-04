import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] cost = {
            {1, 2, 2, 2, 2},
            {0, 1, 3, 4, 3},
            {0, 3, 1, 3, 4},
            {0, 4, 3, 1, 3},
            {0, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][][] result = new int[100001][5][5];
        final int MAX = Integer.MAX_VALUE;

        for(int i=0; i<=100000; i++){
            for(int j=0; j<5; j++){
                Arrays.fill(result[i][j], MAX);
            }
        }

        int idx = 0;
        result[0][0][0] = 0;
        while(true){
            int dir = Integer.parseInt(st.nextToken());
            if(dir == 0){
                break;
            }

            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    int now = result[idx][i][j];
                    if(now < MAX){
                        result[idx+1][dir][j] = Math.min(now + cost[i][dir], result[idx+1][dir][j]);
                        result[idx+1][i][dir] = Math.min(now + cost[j][dir], result[idx+1][i][dir]);
                    }
                }
            }
            idx++;
        }

        int answer = MAX;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                answer = (answer > result[idx][i][j]) ? result[idx][i][j] : answer;
            }
        }
        System.out.println(answer);
    }
}