import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] pos = new int[N];
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);

        //simulation
        int done = 0;//이미 붙인 위치
        for(int i=0; i<N; i++){
            if(pos[i] <= done){
                continue;
            }
            count++;
            done = pos[i] + L - 1;
        }

        System.out.println(count);
    }
}