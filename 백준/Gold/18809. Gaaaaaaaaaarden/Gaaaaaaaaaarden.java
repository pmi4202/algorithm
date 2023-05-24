import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, R, G, max;
    static int[][] map;
    static List<Pos> soils;//뿌릴 수 있는 땅
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //init
        soils = new ArrayList<>();
        map = new int[N+2][M+2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = st.nextToken().charAt(0) - '0';
                if(map[i][j] == 2) soils.add(new Pos(i, j));
            }
        }

        //combination & simluation
        combination(0, soils.size(), 0, 0, new int[R], new int[G]);

        System.out.println(max);
    }

    public static void combination(int idx, int size, int r, int g, int[] reds, int[] greens){
        if(r == R && g == G){
            max = Math.max(max, simulation(reds, greens));
            return;
        }
        if(idx >= size){
            return;
        }

        //빨간배양액
        if(r < R){
            reds[r] = idx;
            combination(idx+1, size, r+1, g, reds, greens);
        }
        //초록배양액
        if(g < G){
            greens[g] = idx;
            combination(idx+1, size, r, g+1, reds, greens);
        }
        //아무것도 안놔둠
        combination(idx + 1, size, r, g, reds, greens);
    }

    public static int simulation(int[] reds, int[] greens){
        int flower = 0;
        Queue<Pos> redq = new LinkedList<>();
        Queue<Pos> greenq = new LinkedList<>();
        int[][] visited = new int[N+2][M+2];//방문X:0, 방문O:depth
        int depth = 2;
        for(int red : reds){
            Pos p = soils.get(red);
            visited[p.x][p.y] = depth;
            redq.add(p);
        }
        for(int green : greens){
            Pos p = soils.get(green);
            visited[p.x][p.y] = 1;
            greenq.add(p);
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
                    visited[nx][ny] = 1;
                    greenq.add(new Pos(nx, ny));
                }
            }
        }

        return flower;
    }
}