import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int row, col, num;

        public Node(int row, int col, int num){
            this.row = row;
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

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            pq.add(new Node(N, i, map[N][i]));
        }
        for(int i=1; i<N; i++){
            Node now = pq.poll();
            pq.add(new Node(now.row - 1, now.col, map[now.row - 1][now.col]));
        }
        System.out.println(pq.poll().num);

    }
}