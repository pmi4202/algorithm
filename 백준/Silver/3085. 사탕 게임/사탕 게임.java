import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, result;
    static char[][] map;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                count(i, j);
                solve(i, j);
            }
        }

        System.out.println(result);
    }

    public static void solve(int x, int y){
        int dx[] = {0, 1}, dy[] = {1, 0};
        for(int i=0; i<2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=N){continue;}
            if(map[x][y] != map[nx][ny]){
                swap(x, y, nx, ny);
                count(x, y);
                count(nx, ny);
                swap(x, y, nx, ny);
            }
        }
    }

    public static void swap(int x1, int y1, int x2, int y2){
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    public static void count(int x, int y){
        //가로
        char prev = map[x][0];
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(prev == map[x][i]){
                cnt++;
            }
            else{
                result = Math.max(result, cnt);
                cnt = 1;
                prev = map[x][i];
            }
        }
        result = Math.max(result, cnt);
        cnt = 1;
        prev = map[0][y];
        for(int i=1; i<N; i++){
            if(prev == map[i][y]){
                cnt++;
            }
            else{
                result = Math.max(result, cnt);
                cnt = 1;
                prev = map[i][y];
            }
        }
        result = Math.max(result, cnt);
    }
}