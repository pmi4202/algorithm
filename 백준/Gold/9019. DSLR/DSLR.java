import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(bfs(A, B)).append("\n");
        }
        System.out.println(sb);

    }

    public static String bfs(int A, int B){
        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[10_000];
        char[] process = new char[10_000];
        Arrays.fill(parent, -1);
        q.add(A);
        parent[A] = A;

        while(!q.isEmpty()){
            int now = q.poll();

            int next = (now<<1)%10000;
            if(parent[next] == -1){
                parent[next] = now;
                process[next] = 'D';
                q.add(next);
            }
            next = (now+9999)%10000;
            if(parent[next] == -1){
                parent[next] = now;
                process[next] = 'S';
                q.add(next);
            }
            next = now/1000 + now%1000*10;
            if(parent[next] == -1){
                parent[next] = now;
                process[next] = 'L';
                q.add(next);
            }
            next = now/10 + now%10*1000;
            if(parent[next] == -1){
                parent[next] = now;
                process[next] = 'R';
                q.add(next);
            }

            if(parent[B]!=-1){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(A!=B){
            sb.append(process[B]);
            B = parent[B];
        }
        return sb.reverse().toString();
    }
}