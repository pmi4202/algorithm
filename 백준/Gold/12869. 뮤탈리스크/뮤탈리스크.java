import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int damage[][] = new int[][]{
            {9, 3, 1}, {9, 1, 3},
            {3, 9, 1}, {3, 1, 9},
            {1, 3, 9}, {1, 9, 3}
    };
    static boolean dp[][][];

    public static int attack(int[] scv){
        int result = 0;
        Queue<int[]> q = new LinkedList<>();//a, b, c
        q.add(new int[]{scv[0], scv[1], scv[2]});
        outloop : while(true){
            result ++;
            for(int i=0, size=q.size(); i<size; i++){
                int[] now = q.poll();
                for(int a=0; a<6; a++){
                    int n1 = Math.max(0, now[0]-damage[a][0]);
                    int n2 = Math.max(0, now[1]-damage[a][1]);
                    int n3 = Math.max(0, now[2]-damage[a][2]);
                    if(!dp[n1][n2][n3]){
                        if(n1==0 && n2==0 &&n3==0){
                            break outloop;
                        }
                        dp[n1][n2][n3] = true;
                        q.add(new int[]{n1, n2, n3});
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int scv[] = new int[3];
        dp = new boolean[61][61][61];

        for(int i=0; i<N; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(attack(scv));

    }
}
