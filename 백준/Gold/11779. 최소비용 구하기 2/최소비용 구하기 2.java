import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Road{
        int n2, cost;

        public Road(int n2, int cost){
            this.n2 = n2;
            this.cost = cost;
        }
    }

    static int[] p;
    static List<Road>[] roads;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());//도시 수
        int m = Integer.parseInt(br.readLine());//버스 수
        p = new int[n+1];
        roads = new ArrayList[n+1];
        //init
        for(int i=1; i<=n; i++) {
            p[i] = i;
            roads[i] = new ArrayList<>();
        }

        //input
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            roads[Integer.parseInt(st.nextToken())].add(
                    new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
            );
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        //dijkstra
        dijkstra(n, s, e);
    }

    public static void dijkstra(int n, int s, int e){
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);//현재까지 경로값, 현재 위치
        distance[s] = 0;
        pq.add(new int[]{0, s});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[1] == e){
                break;
            }

            for(Road road : roads[now[1]]){
                int temp = now[0] + road.cost;
                if(temp < distance[road.n2]){
                    distance[road.n2] = temp;
                    pq.add(new int[]{temp, road.n2});
                    //경로 표시
                    p[road.n2] = now[1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(distance[e]).append("\n");
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        while(s != e){
            cnt++;
            list.add(e);
            e = p[e];
        }

        sb.append(cnt+1).append("\n").append(s);
        for(int i=cnt-1; i>=0; i--){
            sb.append(" ").append(list.get(i));
        }
        System.out.print(sb);
    }
}