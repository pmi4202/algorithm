import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] map = new boolean[5][5];
        int[][] pos = new int[26][2];

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = true;
                int n = Integer.parseInt(st.nextToken());
                pos[n][0] = i;
                pos[n][1] = j;
            }
        }

        boolean find = false;
        int result = 0;
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int su = Integer.parseInt(st.nextToken());
                map[pos[su][0]][pos[su][1]] = false;
                if(!find && check(map)){
                    find = true;
                    result = i*5 + j + 1;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean check(boolean[][] map){
        int cnt = 0;
        //가로, 세로
        for(int i=0; i<5; i++){
            if(!map[i][0] && !map[i][1] && !map[i][2] && !map[i][3] && !map[i][4]){
                cnt++;
            }
            if(!map[0][i] && !map[1][i] && !map[2][i] && !map[3][i] && !map[4][i]){
                cnt++;
            }

        }
        //대각선 2개
        if(!map[0][0] && !map[1][1] && !map[2][2] && !map[3][3] && !map[4][4]){
            cnt++;
        }
        if(!map[0][4] && !map[1][3] && !map[2][2] && !map[3][1] && !map[4][0]){
            cnt++;
        }

        return cnt >= 3;
    }
}