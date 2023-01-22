import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, no, dis, cnt;
    static ArrayList<Integer>[] roads;

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[N+1];
        q.add(1);
        visited[1] = true;

        dis = -1;//1부터 시작
        while(!q.isEmpty()){
            no = N+1;
            dis++;
            cnt = q.size();
            for(int i = 0; i < cnt; i++){
                int now = q.poll();
                no = Math.min(no, now);
                for(int next : roads[now]){
                    if(visited[next]){continue;}
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        roads = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            roads[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            roads[a].add(b);
            roads[b].add(a);
        }

        bfs();
        System.out.println(no + " " + dis + " " + cnt);
    }
}