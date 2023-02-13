import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, start, cnt;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++){
            start = i;
            visited[start] = true;
            dfs(i);
            visited[start] = false;
        }
        System.out.print(cnt);
        System.out.print(sb);
    }

    public static void dfs(int now){
        if(arr[now] == start){
            cnt++;
            sb.append("\n").append(start);
            return;
        }

        if(!visited[arr[now]]){
            visited[arr[now]] = true;
            dfs(arr[now]);
            visited[arr[now]] = false;
        }
    }

}