import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    static int N, K, belt[], s, m, e, beltLen; //--K==0이면 종료
    static boolean isExist[];//각 칸에 로봇이 존재하는지 여부
    
    public static int simulation(){
        int step = 0;
        Queue<Integer> robots = new LinkedList<>();//로봇의 위치를 저장

        outloop : while(true){
            step++;

            //1. 벨트 이동
            s = (s+beltLen-1)%beltLen;
            e = (e+beltLen-1)%beltLen;
            m = (s + N - 1)%beltLen;//내리는 위치
            isExist[m] = false;
            
            //2. 로봇 이동
            for(int size = robots.size(); size>0; size--){
                int pos = robots.poll();
                if(pos == m){//내렸음
                    continue;
                }
                //이동이 불가능한 경우 = 기존 위치 유지
                int nextPos = (pos+1)%beltLen;
                if(isExist[nextPos] || belt[nextPos] <= 0){
                    robots.add(pos);
                    continue;
                }
                //이동이 가능한 경우
                isExist[pos] = false;
                if(--belt[nextPos] == 0){
                    K--;
                }
                if(nextPos != m){
                    isExist[nextPos] = true;
                    robots.add(nextPos);
                }

            }
            //3. 로봇 올리기
            if(!isExist[s] && belt[s] > 0){
                isExist[s] = true;
                robots.add(s);
                if(--belt[s] == 0){
                    K--;
                }
            }

            //4.
            if(K <= 0){
                break;
            }
        }

        return step;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        beltLen = 2*N;
        belt = new int[beltLen];
        isExist = new boolean[beltLen];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<beltLen; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        s = 0;
        e = beltLen-1;
        System.out.println(simulation());
    }
}
