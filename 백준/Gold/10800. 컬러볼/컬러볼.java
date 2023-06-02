import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Ball {
        int idx, color;

        public Ball(int idx, int color){
            this.idx = idx;
            this.color = color;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int total = 0;
        int[] color = new int[200_001];//색깔별 합
        int[] result = new int[N];
        ArrayList<Ball>[] balls = new ArrayList[2001];

        for(int i=1; i<=2000; i++) balls[i] = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls[s].add(new Ball(i, c));
        }

        for(int i=1; i<=2000; i++){
            for(Ball ball : balls[i]) result[ball.idx] = total - color[ball.color];
            total += balls[i].size() * i;
            for(Ball ball : balls[i]) color[ball.color] += i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(result[i]).append("\n");
        System.out.println(sb);
    }
}