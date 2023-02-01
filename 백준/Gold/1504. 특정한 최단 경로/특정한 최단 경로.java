import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1-> u -> v -> N
// 1-> v -> u -> N
public class Main {

    static int N, E;
    static final int INF = 3_000_000;
    static int[][] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            distance[n1][n2] = distance[n2][n1] = d;
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int mid = dijkstra(u, v);

        int result = Math.min(getPathValue(u, v, mid), getPathValue(v, u, mid));
        if(result >= INF){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
    }

    public static int getPathValue(int n1, int n2, int mid){
        int result = INF;
        int e1 = dijkstra(1, n1), e2 = dijkstra(n2, N);
        if(e1 < INF && e2 < INF){
            result = e1 + mid + e2;
        }
        return result;
    }

    public static int dijkstra(int s, int e){
        int[] d = Arrays.copyOf(distance[s], N + 1);
        boolean[] visited = new boolean[N+1];
        visited[s] = true;

        while(true){
            int min = INF, no = 0;
            for(int i=1; i<=N; i++){
                if(visited[i]){continue;}
                if(d[i] < min){
                    min = d[i];
                    no = i;
                }
            }

            visited[no] = true;
            if(min == INF || no == e)
                break;

            for(int i=1; i<=N; i++){
                d[i] = Math.min(d[i], d[no] + distance[no][i]);
            }
        }

        return d[e];
    }
}