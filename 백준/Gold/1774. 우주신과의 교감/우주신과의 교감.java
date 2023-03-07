import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static double[][] adjmatrix;

    static class Node implements Comparable<Node> {
        int idx;
        double dis;

        public Node(int idx, double dis){
            this.idx = idx;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node n){
            return Double.compare(this.dis, n.dis);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjmatrix = new double[N][N];
        int[][] pos = new int[N][2];

        for(int i=0; i<N; i++){
            Arrays.fill(adjmatrix[i], Double.MAX_VALUE);
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i] = new int[]{x, y};
            for(int j=0; j<i; j++){
                double d = getDistance(x, y, pos[j][0], pos[j][1]);
                adjmatrix[i][j] = adjmatrix[j][i] = d;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            adjmatrix[n1][n2] = adjmatrix[n2][n1] = 0;
        }

        prim();
    }

    public static void prim(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        double[] distance = new double[N];
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[0] = 0;
        pq.add(new Node(0, 0));

        double result = 0;
        int cnt = 1;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.idx]){
                continue;
            }
            visited[now.idx] = true;
            result += now.dis;
            if(++cnt > N){
                break;
            }

            for(int i=0; i<N; i++){
                if(visited[i]){ continue;}
                if(adjmatrix[now.idx][i] < distance[i]){
                    distance[i] = adjmatrix[now.idx][i];
                    pq.add(new Node(i, distance[i]));
                }
            }
        }

        System.out.printf("%.2f", result);
    }

    public static double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}