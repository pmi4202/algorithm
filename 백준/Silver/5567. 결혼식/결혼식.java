import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        int result = 0;
        ArrayList<Integer>[] adjlist = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            adjlist[i] = new ArrayList<>();
        }

        for(int i=0; i<L; i++){
            String[] inputs = br.readLine().split(" ");
            int n1 = Integer.parseInt(inputs[0]);
            int n2 = Integer.parseInt(inputs[1]);
            adjlist[n1].add(n2);
            adjlist[n2].add(n1);
        }

        for(int now : adjlist[1]){
            visited[now] = true;
            for(int next : adjlist[now]){
                visited[next] = true;
            }
        }

        for(int i=2; i<=N; i++){
            if(visited[i]){
                result++;
            }
        }
        System.out.println(result);
    }
}
