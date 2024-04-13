import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static private class Ball{
        char color;
        int x, y;
        public Ball(char color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }

        public Ball getDeepCopy(){
            return new Ball(this.color, this.x, this.y);
        }

        public void moveTo(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. init
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = line.charAt(j);
            }
        }

        //2.
        Ball redBall = searchPos(n, m, 'R', map);
        Ball blueBall = searchPos(n, m, 'B', map);
        int result = bfs(n, m, redBall, blueBall, map);
        System.out.println(result);
    }

    private static Ball searchPos(int n, int m, char color, char[][] map){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == color){
                    map[i][j] = '.';
                    return new Ball(color, i, j);
                }
            }
        }
        return null;
    }

    private static int bfs(int n, int m, Ball redBall, Ball blueBall, char[][] map){
        boolean[][][][] visited = new boolean[n][m][n][m];
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        Queue<Ball[]> q = new LinkedList<>();
        q.add(new Ball[]{redBall, blueBall});
        visited[redBall.x][redBall.y][blueBall.x][blueBall.y] = true;
        int step = 0;

        while(!q.isEmpty()){

            if(++step > 10) return -1;

            for(int i=0, size=q.size(); i<size; i++){
                Ball[] balls = q.poll();
                redBall = balls[0];
                blueBall = balls[1];

                for(int j=0; j<4; j++){
                    //1. red, blue 공 움직이기
                    Ball nextRed, nextBlue;
                    if((j==0 && redBall.x > blueBall.x)
                            || (j==1 && redBall.y < blueBall.y)
                            || (j==2 && redBall.x < blueBall.x)
                            || (j==3 && redBall.y > blueBall.y)){
                        //blue먼저
                        nextBlue = move(blueBall.getDeepCopy(), dx[j], dy[j], map);
                        if(map[nextBlue.x][nextBlue.y] != 'O'){
                            map[nextBlue.x][nextBlue.y] = 'B';
                        }
                        nextRed = move(redBall.getDeepCopy(), dx[j], dy[j], map);
                        if(map[nextBlue.x][nextBlue.y] == 'B'){
                            map[nextBlue.x][nextBlue.y] = '.';
                        }
                    } else{
                        nextRed = move(redBall.getDeepCopy(), dx[j], dy[j], map);
                        if(map[nextRed.x][nextRed.y] != 'O'){
                            map[nextRed.x][nextRed.y] = 'R';
                        }
                        nextBlue = move(blueBall.getDeepCopy(), dx[j], dy[j], map);
                        if(map[nextRed.x][nextRed.y] == 'R'){
                            map[nextRed.x][nextRed.y] = '.';
                        }
                    }

                    //2. 구멍 만나는지 확인
                    if(nextRed.x != nextBlue.x || nextRed.y != nextBlue.y){
                        if(map[nextRed.x][nextRed.y] == 'O'){
                            return step;
                        } else if(map[nextBlue.x][nextBlue.y] != 'O'){
                            if(!visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]){
                                visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
                                q.add(new Ball[] {nextRed, nextBlue});
                            }
                        }
                    }
                }

            }
        }

        return -1;
    }

    private static Ball move(Ball ball, int dx, int dy, char[][] map){
        while(true) {
            int nx = ball.x + dx;
            int ny = ball.y + dy;
            if (map[nx][ny] == '.') {
                ball.moveTo(nx, ny);
            } else{
                if(map[nx][ny] == 'O') ball.moveTo(nx, ny);
                break;
            }
        }
        return ball;
    }
}