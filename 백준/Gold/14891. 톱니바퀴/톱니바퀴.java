import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Wheel{
        int start;//12시방향 index
        int[] ns;

        public Wheel(){
            start = 0;
            ns = new int[8];
        }

        public void turn(int dir){
            if(dir == 1){//시계 방향
                start = (start + 7)%8;
            }
            else{
                start = (start + 1)%8;
            }
        }

        public int getTop(){
            return ns[start];
        }

        public int getLeft(){
            return ns[(start+6)%8];
        }

        public int getRight(){
            return ns[(start+2)%8];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Wheel[] wheels = new Wheel[4];

        for(int i=0; i<4; i++){
            wheels[i] = new Wheel();
            String input = br.readLine();
            for(int j=0; j<8; j++){
                wheels[i].ns[j] = input.charAt(j) - '0';
            }
        }

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            visited = new boolean[4];
            simulation(wheels, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for(int i=0; i<4; i++){
            if(wheels[i].getTop() == 1){
                result |= (1<<i);
            }
        }
        System.out.println(result);
    }

    static boolean[] visited;
    //no번 톱니바퀴를 dir방향으로 회전
    public static void simulation(Wheel[] wheels, int no, int dir){
        visited[no] = true;
        //왼쪽
        int l = no - 1;
        if(0 <= l && !visited[l] && wheels[no].getLeft() != wheels[l].getRight()){
            simulation(wheels, l, dir*-1);
        }

        //오른쪽
        int r = no + 1;
        if(r < 4 && !visited[r] && wheels[no].getRight() != wheels[r].getLeft()){
            simulation(wheels, r, dir*-1);
        }

        wheels[no].turn(dir);
    }
}
