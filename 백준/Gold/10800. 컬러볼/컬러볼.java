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
        int prevSize = -1;
        while(i<N){
            if(balls[i].size != prevSize){
                total += temp;
                temp = 0;
            }

            prevSize = balls[i].size;
            temp += prevSize;
            result[balls[i].idx] = total - sum[balls[i].color];
            sum[balls[i].color] += prevSize;
            i++;
            while(i<N && balls[i-1].size == balls[i].size && balls[i].color == balls[i-1].color){
                result[balls[i].idx] = result[balls[i-1].idx];
                sum[balls[i].color] += balls[i].size;
                temp += balls[i].size;
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

/*
1. 정렬
2. 총 누적 크기
3. 색깔별 누적 크기

필요한 자료 구조
1. 공의 데이터 : idex, 색깔, 크기 
2. 결과 배열
3. 누적값 담을 int 2개
 */