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
            start = (dir == 1) ? (start + 7)%8 : (start + 1)%8;
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
            simulation(wheels, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for(int i=0; i<4; i++){
            result |= (wheels[i].getTop()<<i);
        }
        System.out.println(result);
    }

    public static void simulation(Wheel[] wheels, int no, int dir){
        int prev = wheels[no].getLeft();
        int d = dir;

        for(int i=no-1; i>=0; i--){
            if(prev == wheels[i].getRight()){
                break;
            }
            d *= -1;
            prev = wheels[i].getLeft();
            wheels[i].turn(d);
        }

        prev = wheels[no].getRight();
        d = dir;
        for(int i=no+1; i<4; i++){
            if(prev == wheels[i].getLeft()){
                break;
            }
            d = d * -1;
            prev = wheels[i].getRight();
            wheels[i].turn(d);
        }

        wheels[no].turn(dir);

    }
}