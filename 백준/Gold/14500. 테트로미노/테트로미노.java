import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dx = {
            {0, 0, 0}, {1, 2, 3},
            {0, 1, 1},
            {1, 2, 2}, {1, 2, 2}, {0, 1, 2}, {0, 1, 2}, {0, 0, 1}, {0, 0, 1}, {1, 1, 1}, {1, 1, 1},
            {0, 1, 1}, {0, 1, 1}, {1, 1, 2}, {1, 1, 2},
            {1, 1, 1}, {0, 0, 1}, {1, 1, 2}, {1, 1, 2}
    };
    static int[][] dy = {
            {1, 2, 3}, {0, 0, 0},
            {1, 1, 0},
            {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {1, 1, 1}, {1, 2, 0}, {1, 2, 2}, {0, 1, 2}, {0, -1, -2},
            {1, 0, -1}, {1, 1, 2}, {0, 1, 1}, {0, -1, -1},
            {-1, 0, 1}, {1, 2, 1}, {0, 1, 0}, {0, -1, 0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+6][M+6];
        int result = 0;

        //init
        for(int i=3; i<N+3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=3; j<M+3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //
        for(int i=3; i<N+3; i++){
            for(int j=3; j<M+3; j++){
                for(int k=0; k<19; k++){
                    int sum = map[i][j];
                    for(int a=0; a<3; a++){
                        int nx = i + dx[k][a];
                        int ny = j + dy[k][a];
                        sum += map[nx][ny];
                    }
                    result = Math.max(result, sum);
                }
            }
        }
        System.out.println(result);
    }

}