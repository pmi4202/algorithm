import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    static boolean visited[][][];
    static char map[][];

    static class Point implements Comparable<Point> {
        int x, y, dir, mirror;

        public Point(int x, int y, int dir, int mirror){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Point o){
            return this.mirror - o.mirror;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        visited = new boolean[h][w][4];
        map = new char[h][w];
        String s;
        int sx = 0, sy = 0;

        for(int i=0; i<h; i++) {
            s = br.readLine();
            for(int j=0; j<w; j++) {
                map[i][j] = s.charAt(j);
                //출발지 & 도착지 저장
                if(map[i][j]=='C') {
                    sx = i;
                    sy = j;
                }
            }
        }

        map[sx][sy] = '.';
        System.out.println(bfs(sx, sy));
    }

    public static int bfs(int sx, int sy) {
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        PriorityQueue<Point> pq = new PriorityQueue<>();
        //좌표x, y, 들어온 방향, 거울 수
        //시작값 넣기
        pq.add(new Point(sx, sy, -1, -1));

        while(!pq.isEmpty()) {
            Point now = pq.poll();
            //도착지면 stop
            if(map[now.x][now.y] == 'C') {
                return now.mirror;
            }

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || nx>=h || ny<0 || ny>=w || map[nx][ny] == '*' || visited[nx][ny][i]){
                    continue;
                }
                visited[nx][ny][i] = true;
                int temp = now.mirror;
                if(now.dir!=i){temp++;}
                pq.add(new Point(nx, ny, i, temp));

            }
        }
        return -1;
    }
}