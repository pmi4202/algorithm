import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int result[] = new int[D+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            });
        }

        for(int i=0; i<D; i++){
            while(!pq.isEmpty() && pq.peek()[0] == i){
                int[] now = pq.poll();
                if(now[1] > D){continue;}
                result[now[1]] = Math.min(result[now[1]], result[i] + now[2]);
            }
            result[i+1] = Math.min(result[i+1], result[i] + 1);
        }
        System.out.println(result[D]);
    }

}