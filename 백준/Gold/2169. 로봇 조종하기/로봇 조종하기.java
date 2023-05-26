import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int MIN = -200_000_000;

    public static class Node{
        int t, l, r;

        public Node(){
            this.t = this.l = this.r = MIN;
        }

        public int getMax(){
            return Math.max(this.t, (this.l < this.r ? this.r : this.l));
        }

        public void next(int now){
            this.t = now + getMax();
            this.l = MIN;
            this.r = MIN;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        Node[] dp = new Node[M];
        //init
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++) dp[i] = new Node();

        dp[0].t = dp[0].l = map[0][0];
        for(int i=1; i<M; i++){
            dp[i].l = map[0][i] + dp[i-1].l;
        }

        //simulation
        for(int i=1; i<N; i++){
            dp[0].next(map[i][0]);
            for(int j=1; j<M; j++){
                dp[j].next(map[i][j]);
                dp[j].l = map[i][j] + Math.max(dp[j-1].t, dp[j-1].l);
            }

            for(int j=M-2; j>=0; j--){
                dp[j].r = map[i][j] + Math.max(dp[j+1].t, dp[j+1].r);
            }
        }
        System.out.println(dp[M-1].getMax());
    }
}