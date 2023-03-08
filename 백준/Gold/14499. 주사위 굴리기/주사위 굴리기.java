import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Dice{
        int t, b, u, d, l, r;

        public void turn(int t, int b, int u, int d, int l, int r){
            this.t = t;
            this.b = b;
            this.u = u;
            this.d = d;
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0};
        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = st.nextToken().charAt(0) - '0';
            }
        }

        Dice dice = new Dice();
        st = new StringTokenizer(br.readLine());
        while(K-- > 0){
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx<0 || nx>=N || ny<0 || ny>=M){ continue;}

            //주사위 굴리기
            switch(dir){
                case 1:
                    dice.turn(dice.l, dice.r, dice.u, dice.d, dice.b, dice.t);
                    break;
                case 2:
                    dice.turn(dice.r, dice.l, dice.u, dice.d, dice.t, dice.b);
                    break;
                case 3:
                    dice.turn(dice.d, dice.u, dice.t, dice.b, dice.l, dice. r);
                    break;
                case 4:
                    dice.turn(dice.u, dice.d, dice.b, dice.t, dice.l, dice.r);
                    break;
            }

            if(map[nx][ny] == 0){
                map[nx][ny] = dice.b;
            }
            else{
                dice.b = map[nx][ny];
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;

            sb.append(dice.t).append("\n");
        }
        System.out.println(sb);

    }
}