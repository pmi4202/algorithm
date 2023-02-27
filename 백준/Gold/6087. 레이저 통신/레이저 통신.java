import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    static boolean visited[][][];
    static char map[][];

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
        Queue<int[]> q = new LinkedList<>();
        //좌표x, y, 들어온 방향, 거울 수
        //시작값 넣기
        visited[sx][sy][0] = visited[sx][sy][1] = visited[sx][sy][2] = visited[sx][sy][3] = true;
        q.add(new int[]{sx, sy});

        int result = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0){
                int[] now = q.poll();
                //도착지면 stop
                if(map[now[0]][now[1]] == 'C') {
                    return result;
                }

                for(int i=0; i<4; i++) {
                    int nx = now[0];
                    int ny = now[1];
                    while(true){
                        nx += dx[i];
                        ny += dy[i];
                        if(nx<0 || nx>=h || ny<0 || ny>=w || map[nx][ny] == '*' || visited[nx][ny][i]){
                            break;
                        }
                        visited[nx][ny][i] = true;
                        q.add(new int[]{nx, ny});
                    }

                }

            }
            result++;

        }
        return result;
    }
}