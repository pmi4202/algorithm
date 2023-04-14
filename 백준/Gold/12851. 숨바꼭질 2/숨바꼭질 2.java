import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] step = new int[200_000];
        int[] cnt = new int[200_000];
        Queue<int[]> q = new LinkedList<>();
        Arrays.fill(step, Integer.MAX_VALUE);
        q.add(new int[]{N, 0});//숫자, step

        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] < 0 || step[now[0]] < now[1]){
                continue;
            }

            step[now[0]] = now[1];
            cnt[now[0]]++;
            if(step[K] == Integer.MAX_VALUE){
                q.add(new int[]{now[0] - 1, now[1] + 1});
                if(now[0] < K) {
                    q.add(new int[]{now[0] + 1, now[1] + 1});
                    q.add(new int[]{now[0] * 2, now[1] + 1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(step[K]).append("\n").append(cnt[K]);
        System.out.println(sb);
    }
}