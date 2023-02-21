import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        boolean[] visited = new boolean[100_001];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        pq.add(new int[]{N, 0});

         while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] == K){
                System.out.println(now[1]);
                break;
            }
             
            visited[now[0]] = true;

            if(now[0] - 1 >= 0 && !visited[now[0] - 1]){
                pq.add(new int[]{now[0] - 1, now[1] + 1});
            }
            if(now[0] + 1 <= 100000 && !visited[now[0] + 1]){
                pq.add(new int[]{now[0] + 1, now[1] + 1});
            }
            if(now[0] * 2 <= 100000 && !visited[now[0]*2]){
                pq.add(new int[]{now[0]*2, now[1]});
            }

        }
    }
}