import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] result;
    static List<Integer>[] adjlist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        adjlist = new ArrayList[N + 1];

        for(int i=1; i<=N; i++){
            adjlist[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adjlist[n1].add(n2);
        }

        bfs(X);
        if(result.length == 0){
            System.out.println(-1);
        }
        else{
            Arrays.sort(result);
            StringBuilder sb = new StringBuilder();
            for(int n : result){
                sb.append(n).append("\n");
            }
            System.out.println(sb);
        }

    }

    public static void bfs(int start){
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        int len = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int now = q.poll();
                for(int next : adjlist[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            if(++len == K){
                break;
            }
        }

        int total = q.size();
        result = new int[total];
        for(int i=0; i<total; i++){
            result[i] = q.poll();
        }
        return;
    }
}