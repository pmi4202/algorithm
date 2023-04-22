import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] map;

    static class Block{
        int rainbowCnt = 0;
        ArrayList<int[]> pos = new ArrayList<>();
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //
        int score = 0;
        while(true){
            //init
            Block bigBlock = new Block();
            bigBlock.pos.add(new int[]{0, 0});
            bigBlock.pos.add(new int[]{0, 0});
            bigBlock.rainbowCnt = -1;
            boolean[][] visited = new boolean[N][N];
            //simulation
            //1.
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j] || map[i][j] <= 0){ continue;}
                    Block block = new Block();
                    dfs(i, j, map[i][j], visited, block);
                    int size = block.pos.size();
                    if(size > bigBlock.pos.size()){
                        bigBlock = block;
                    }
                    else if(size == bigBlock.pos.size() && block.rainbowCnt >= bigBlock.rainbowCnt){
                        bigBlock = block;
                    }
                    //rainbowblock은 방문 체크 제거
                    for(int[] pos : block.pos){
                        if(map[pos[0]][pos[1]] == 0) visited[pos[0]][pos[1]] = false;
                    }

                }
            }
            //블럭이 없다면 종료
            if(bigBlock.rainbowCnt == -1){
                break;
            }
            //2. 점수 추가 & 찾은 블럭 제거
            score += Math.pow(bigBlock.pos.size(), 2);
            for(int[] now : bigBlock.pos){
                map[now[0]][now[1]] = -2;
            }

            //3. 중력
            goDown();

            //4. 반시계방향 회전
            turnLeft();

            //5. 중력
            goDown();
        }
        System.out.println(score);
    }

    public static void dfs(int x, int y, int color, boolean[][] visited, Block block){
        visited[x][y] = true;
        block.pos.add(new int[]{x, y});
        if(map[x][y] == 0){
            block.rainbowCnt++;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny] < 0){continue;}
            if(map[nx][ny] == color || map[nx][ny] == 0){
                dfs(nx, ny, color, visited, block);
            }
        }
    }

    public static void goDown(){
        for(int j=0; j<N; j++){
            for(int i=N-2; i>=0; i--){
                if(map[i][j] < 0){ continue;}
                int idx = i+1;
                while(idx<N && map[idx][j] < -1){
                    map[idx][j] = map[idx-1][j];
                    map[idx-1][j] = -2;
                    idx++;
                }
            }
        }
    }

    public static void turnLeft(){
        int[][] next = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                next[i][j] = map[j][(N-1-i)];
            }
        }
        map = next;
    }

}