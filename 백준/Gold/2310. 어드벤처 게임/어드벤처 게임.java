import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Miro[] miros;
    static boolean[] visited;
    static String result;

    public static class Miro{
        char content;
        int cost;
        ArrayList<Integer> doors;

        public Miro(char content, int cost){
            this.content = content;
            this.cost = cost;
            this.doors = new ArrayList<>();
        }
    }

    public static void dfs(int money, int now){
        if(now==N){
            result = "Yes";
            return;
        }

        for(int door : miros[now].doors){
            if(visited[door]){continue;}

            int temp = money;
            switch (miros[door].content){
                case 'L':
                    temp = Math.max(temp, miros[door].cost);
                    break;
                case 'T':
                    temp -= miros[door].cost;
                    if(temp < 0){
                        continue;
                    }
                    break;
            }

            visited[door] = true;
            dfs(temp, door);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0){break;}

            miros = new Miro[N+1];
            visited = new boolean[N+1];
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                miros[i] = new Miro(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
                while(true){
                    int su = Integer.parseInt(st.nextToken());
                    if(su==0){break;}
                    miros[i].doors.add(su);
                }
            }
            result = "No";
            visited[1] = true;
            dfs(0, 1);
            sb.append(result).append("\n");
            //
        }
        System.out.println(sb);
    }
}
