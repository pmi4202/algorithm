import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, max;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        //init
        map = new int[N+2][M+2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = st.nextToken().charAt(0) - '0';
            }
        }

        //combination & simluation
        combination(0, 0, 0, R, G, new Pos[R], new Pos[G]);

        System.out.println(max);
    }

    public static void combination(int idx, int r, int g, int R, int G, Pos[] reds, Pos[] greens){
        if(r == R && g == G){
            max = Math.max(max, simulation(reds, greens));
            return;
        }
        if(idx >= (N+2)*(M+2)){
            return;
        }

        int x = idx/(M+2);
        int y = idx%(M+2);
        if(map[x][y] == 2){
            //빨간배양액
            if(r < R){
                map[x][y] = 3;
                reds[r] = new Pos(x, y);
                combination(idx+1, r+1, g, R, G, reds, greens);
                map[x][y] = 2;
            }
            //초록배양액
            if (g < G) {
                map[x][y] = 4;
                greens[g] = new Pos(x, y);
                combination(idx+1, r, g+1, R, G, reds, greens);
                map[x][y] = 2;
            }
        }
        //아무것도 안놔둠
        combination(idx + 1, r, g, R, G, reds, greens);
    }

    public static int simulation(Pos[] reds, Pos[] greens){
        int flower = 0;
        Queue<Pos> redq = new LinkedList<>();
        Queue<Pos> greenq = new LinkedList<>();
        int[][] visited = new int[N+2][M+2];//방문X:0, 방문O:depth
        int depth = 2;
        for(Pos red : reds){
            visited[red.x][red.y] = depth;
            redq.add(red);
        }
        for(Pos green : greens){
            visited[green.x][green.y] = depth;
            greenq.add(green);
        }

        while(!redq.isEmpty() && !greenq.isEmpty()){
            depth++;
            for(int i=0, size=redq.size(); i<size; i++){
                Pos now = redq.poll();
                if(visited[now.x][now.y] == -1) continue;
                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(visited[nx][ny] != 0 || map[nx][ny] == 0) continue;
                    visited[nx][ny] = depth;
                    redq.add(new Pos(nx, ny));
                }
            }

            for(int i=0, size=greenq.size(); i<size; i++){
                Pos now = greenq.poll();
                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(visited[nx][ny] == depth){
                        visited[nx][ny] = -1;
                        flower++;
                        continue;
                    }
                    if(visited[nx][ny] != 0 || map[nx][ny] == 0) continue;
                    visited[nx][ny] = depth-1;
                    greenq.add(new Pos(nx, ny));
                }
            }
        }

        return flower;
    }
}