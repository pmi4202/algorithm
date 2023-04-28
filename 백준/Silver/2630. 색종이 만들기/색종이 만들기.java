import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = st.nextToken().charAt(0) - '0';
            }
        }
        if(N==1){
            result[map[0][0]]++;
        }
        else{
            int n = findSqaure(0, 0, N);
            if(n<2){
                result[n]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result[0]).append("\n").append(result[1]);
        System.out.println(sb);
    }

    public static int findSqaure(int x, int y, int size){
        if(size == 1){
            return map[x][y];
        }

        int[] temp = new int[3];
        int half = size/2;
        temp[findSqaure(x, y, half)]++;
        temp[findSqaure(x, y+half, half)]++;
        temp[findSqaure(x+half, y, half)]++;
        temp[findSqaure(x+half, y+half, half)]++;

        if(temp[0] == 4){
            return 0;
        }
        else if(temp[1] == 4){
            return 1;
        }
        else{
            result[0] += temp[0];
            result[1] += temp[1];
            return 2;
        }
    }
}