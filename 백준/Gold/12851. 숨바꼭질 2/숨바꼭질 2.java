import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[200_000];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        int step = 0, cnt = 0;
        outloop : while(!q.isEmpty()){
            for(int i=0, size = q.size(); i<size; i++){
                int now = q.poll();
                visited[now] = true;
                if(now == K){
                    cnt++;
                }
                if(now > 0 && !visited[now - 1]){
                    q.add(now - 1);
                }
                if(now < K) {
                    if(!visited[now + 1]) q.add(now + 1);
                    if(!visited[now * 2]) q.add(now * 2);
                }
            }
            if(cnt > 0) break;
            step++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(step).append("\n").append(cnt);
        System.out.println(sb);
    }
}