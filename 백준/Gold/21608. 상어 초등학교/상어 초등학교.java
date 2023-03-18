import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, total;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        total = N*N;
        boolean[][] likes = new boolean[total+1][total+1];
        map = new int[N][N];

        for(int i=0; i<total; i++){
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());

            for(int j=0; j<4; j++){
                likes[no][Integer.parseInt(st.nextToken())] = true;
            }
            selectSeat(no, likes[no]);
        }

        //만족도 총합
        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int temp = 1;
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    if(likes[map[i][j]][map[nx][ny]]){
                        temp*=10;
                    }
                }
                result += temp/10;
            }
        }
        System.out.println(result);
    }

    public static void selectSeat(int no, boolean[] likes){
        int x = 0, y = 0, likeMax = -1, blankMax = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (map[i][j] > 0){
                    continue;
                }

                int likeCnt = 0, blankCnt = 0;
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx<0 || nx>=N || ny<0 || ny>=N){
                        continue;
                    }
                    if(map[nx][ny] == 0){
                        blankCnt++;
                    }
                    else if(likes[map[nx][ny]]){
                        likeCnt++;
                    }
                }

                if(likeMax < likeCnt){
                    likeMax = likeCnt;
                    blankMax = blankCnt;
                    x = i;
                    y = j;
                }
                else if(likeMax == likeCnt && blankMax < blankCnt){
                    blankMax = blankCnt;
                    x = i;
                    y = j;
                }
            }
        }
        map[x][y] = no;
    }
}