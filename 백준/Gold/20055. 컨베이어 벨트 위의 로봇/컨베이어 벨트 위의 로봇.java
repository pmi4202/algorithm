import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, belt[]; //--K==0이면 종료
    static boolean robots[];
    
    public static int simulation(){
        int step = 0;

        while(K > 0){
            step ++;

            //1
            int temp = belt[2*N-1];
            for(int i=2*N-1; i>0; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = temp;

            //2
            robots[N-1] = robots[N-2] = false;
            for(int i=N-1; i>1 ; i--){
                if(!robots[i-2] || robots[i] || belt[i] <= 0){ 
                    if(robots[i-2]){
                        robots[i-1] = true;
                        robots[i-2] = false;
                    }
                    continue;
                }
                robots[i] = true;
                robots[i-2] = false;
                if(--belt[i] == 0){
                    K--;
                }
            }

            //3
            if(!robots[0] && belt[0] > 0){
                robots[0] = true;
                if(--belt[0] == 0){
                    K--;
                }
            }
        }

        return step;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robots = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(simulation());
    }
}
