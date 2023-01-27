import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, map[][], result;
    
    public static void permutation(int start, int time, int visited){
        if(visited == (1<<N)-1){
            result = Math.min(result, time);
            return;
        }

        for(int i=0; i<N; i++){
            if((visited & (1<<i))!=0){
                continue;
            }
            permutation(i,time + map[start][i], visited | (1<<i));
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //Floyd Warshall
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                if(i==k){continue;}
                for(int j=0; j<N; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        //순열 탐색
        result = 10001;
        permutation(K, 0, (1<<K));
        System.out.println(result);
    }
}