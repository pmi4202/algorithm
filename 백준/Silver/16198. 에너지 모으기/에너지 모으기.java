import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result;
    static Node[] nodes;

    static class Node{
        int prevIdx, val, nextIdx;

        public Node(int prevIdx, int val, int nextIdx){
            this.prevIdx = prevIdx;
            this.val = val;
            this.nextIdx = nextIdx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodes = new Node[N];
        for(int i=0; i<N; i++){
            nodes[i] = new Node(i-1, Integer.parseInt(st.nextToken()), i+1);
        }
        solve(N-2, 0);
        System.out.println(result);

    }

    public static void solve(int size, int energy){
        if(size == 0){
            result = Math.max(result, energy);
            return;
        }

        int idx = nodes[0].nextIdx;//배열 시작 인덱스값
        for(int i=0; i<size; i++){
            nodes[nodes[idx].prevIdx].nextIdx = nodes[idx].nextIdx;
            nodes[nodes[idx].nextIdx].prevIdx = nodes[idx].prevIdx;
            solve(size - 1, energy + nodes[nodes[idx].prevIdx].val * nodes[nodes[idx].nextIdx].val);
            nodes[nodes[idx].prevIdx].nextIdx = idx;
            nodes[nodes[idx].nextIdx].prevIdx = idx;
            idx = nodes[idx].nextIdx;
        }

    }
}