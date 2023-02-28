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
                if(i < N-1){
                    swap(i, j, i+1, j);
                    count(i, j);
                    count(i+1, j);
                    swap(i, j, i+1, j);
                }
                if(j < N-1){
                    swap(i, j, i, j+1);
                    count(i, j);
                    count(i, j+1);
                    swap(i, j, i, j+1);
                }
            }
        }

        System.out.println(result);
    }

    public static void swap(int x1, int y1, int x2, int y2){
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    public static void count(int x, int y){
        int r1 = 1, r2 = 1;
        
        for(int i=y+1; i<N; i++){
            if(map[x][y] != map[x][i]){
                break;
            }
            r1++;
        }
        for(int i=y-1; i>=0; i--){
            if(map[x][y] != map[x][i]){
                break;
            }
            r1++;
        }

        for(int i=x+1; i<N; i++){
            if(map[x][y] != map[i][y]){
                break;
            }
            r2++;
        }
        for(int i=x-1; i>=0; i--){
            if(map[x][y] != map[i][y]){
                break;
            }
            r2++;
        }

        result = Math.max(result, Math.max(r1, r2));
    }
}