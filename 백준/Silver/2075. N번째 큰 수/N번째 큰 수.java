import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int col, num;

        public Node(int col, int num){
            this.col = col;
            this.num = num;
        }

        @Override
        public int compareTo(Node o){
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        int[] row = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            row[i] = N-1;
            pq.add(new Node(i, map[N][i]));
        }
        for(int i=1; i<N; i++){
            Node now = pq.poll();
            pq.add(new Node(now.col, map[row[now.col]--][now.col]));
        }
        System.out.println(pq.poll().num);

    }
}