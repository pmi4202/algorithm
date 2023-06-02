import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Ball implements Comparable<Ball> {
        int idx, color, size;

        public Ball(int idx, int color, int size){
            this.idx = idx;
            this.color = color;
            this.size = size;
        }

        @Override
        public int compareTo(Ball b){
            if(this.size == b.size){
                return this.color - b.color;
            }
            return this.size - b.size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[200_001], result = new int[N];
        Ball[] balls = new Ball[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(balls);

        int i=0, temp = 0;
        int total = 0;
        Ball prev = new Ball(-1, -1, -1);
        while(i<N){
            if(balls[i].size != prev.size){
                total += temp;
                temp = 0;
            }
            prev = balls[i];
            int res = total - sum[prev.color];
            while(i<N && prev.size == balls[i].size && prev.color == balls[i].color){
                result[balls[i].idx] = res;
                sum[prev.color] += prev.size;
                temp += prev.size;
                i++;
            }
        }

        //result
        StringBuilder sb = new StringBuilder();
        for(int a=0; a<N; a++){
            sb.append(result[a]).append("\n");
        }
        System.out.println(sb);
    }
}
