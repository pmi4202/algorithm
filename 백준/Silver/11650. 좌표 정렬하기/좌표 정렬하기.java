import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o){
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        Arrays.stream(nodes).sorted().forEach((node)->{
                sb.append(node.x).append(" ").append(node.y).append("\n");
            }
        );
        System.out.println(sb);
    }
}