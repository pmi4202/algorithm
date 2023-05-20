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

        for(int k=N/2; k>0; k--){
            combination(0, 0, k);
        }
        System.out.println(result);
    }

    public static void combination(int idx, int cnt, int K){
        if(cnt == K){
            int[] score = new int[2];
            for(int i=0; i<N; i++){
                int t = team[i];
                for(int j=i+1; j<N; j++){
                    if(t == team[j]){
                        score[t] += map[i][j] + map[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(score[0] - score[1]));
            return;
        }
        for(int i=idx; i<N; i++){
            team[i] = 1;
            combination(i+1, cnt+1, K);
            team[i] = 0;
        }
    }
}