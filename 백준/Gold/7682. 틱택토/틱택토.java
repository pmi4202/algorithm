import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static char[] map;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[9];
        set = new HashSet<>();

        for(int i=0; i<9; i++){
            map[i] = '.';
        }

        solve(0, 'X');

        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.charAt(0) == 'e'){
                break;
            }
            if(set.contains(input)){
                sb.append("valid\n");
            }
            else{
                sb.append("invalid\n");
            }
        }
        System.out.println(sb);
    }

    public static void solve(int cnt, char next){
        if(cnt == 9 || check()){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                sb.append(map[i]);
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0; i<9; i++){
            if(map[i] != '.') continue;
            map[i] = next;
            solve(cnt+1, next == 'O' ? 'X' : 'O');
            map[i] = '.';
        }
    }

    public static boolean check(){
        for(int i=0; i<9; i+=3){
            if(map[i] == '.') continue;
            if(map[i] == map[i+1] && map[i] == map[i+2]){
                return true;
            }
        }

        for(int i=0; i<3; i++){
            if(map[i] == '.') continue;
            if(map[i] == map[i+3] && map[i] == map[i+6]){
                return true;
            }
        }

        if(map[4] != '.'){
            if(map[0] == map[4] && map[0] == map[8]){
                return true;
            }

            if(map[2] == map[4] && map[2] == map[6]){
                return true;
            }
        }

        return false;
    }
}