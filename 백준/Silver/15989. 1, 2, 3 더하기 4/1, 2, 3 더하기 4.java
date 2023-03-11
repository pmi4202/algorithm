import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj15989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[10_001][3];
        arr[1][0] = 1; arr[1][1] = 0; arr[1][2] = 0;
        arr[2][0] = 1; arr[2][1] = 1; arr[2][2] = 0;
        arr[3][0] = 1; arr[3][1] = 1; arr[3][2] = 1;
        int max = 3;
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            if(max < n){
                for(int i=max+1; i<=n; i++){
                    arr[i][0] = 1;
                    arr[i][1] = arr[i-2][0] + arr[i-2][1];
                    arr[i][2] = arr[i-3][0] + arr[i-3][1] + arr[i-3][2];
                }
                max = n;
            }
            sb.append(arr[n][0] + arr[n][1] + arr[n][2]).append("\n");
        }
        System.out.println(sb);
    }
}
