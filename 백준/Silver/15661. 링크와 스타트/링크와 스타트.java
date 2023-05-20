import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static int[] team;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        team = new int[N];
        map = new int[N][N];
        result = 50_000;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0, 0, 0);
        System.out.println(result);
    }

    public static void combination(int idx, int cnt, int start, int link){
        if(idx == N){
            result = Math.min(result, Math.abs(start - link));
            return;
        }

        team[idx] = 1;
        int score = 0;
        for(int j=0; j<idx; j++){
            if(team[j] == 1){
                score += map[idx][j] + map[j][idx];
            }
        }
        combination(idx+1, cnt+1, start+score, link);
        team[idx] = 0;
        score = 0;
        for(int j=0; j<idx; j++){
            if(team[j] == 0){
                score += map[idx][j] + map[j][idx];
            }
        }
        combination(idx+1, cnt, start, link+score);
    }
}