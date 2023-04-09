import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = 64;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                count(map, 'W', i, j);
                count(map, 'B', i, j);
            }
        }
        System.out.println(result);
    }

    public static void count(char[][] map, char start, int sx, int sy){
        int cnt = 0;
        for(int i=sx+7; i>=sx; i--){
            for(int j=sy+7; j>sy; j-=2){
                if(start != map[i][j]) cnt++;
            }
            for(int j=sy+6; j>=sy; j-=2){
                if(start == map[i][j]) cnt++;
            }
            start = (start == 'W') ? 'B' : 'W';
        }
        result = Math.min(result, cnt);
    }
}