import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            char[] input = br.readLine().toCharArray();
            if(input[0] == 'e'){
                break;
            }

            //1. 개수 확인
            int xCnt = 0, oCnt = 0;
            for(int i=0; i<9; i++){
                if(input[i] == 'X'){
                    xCnt++;
                }
                else if(input[i] == 'O'){
                    oCnt++;
                }
            }

            boolean xSame = isSame(input, 'X'), oSame = isSame(input, 'O');
            //2. 일치 여부
            if(xCnt + oCnt == 9){
                sb.append((xCnt - oCnt == 1 && !oSame) ? "valid\n" : "invalid\n");
            }
            else{
                if(xCnt - oCnt == 1){//x가 이겨야함
                    sb.append((xSame && !oSame) ? "valid\n" : "invalid\n");
                }
                else if(xCnt == oCnt){
                    sb.append((oSame && !xSame) ? "valid\n" : "invalid\n");
                }
                else{
                    sb.append("invalid\n");
                }
            }

        }
        System.out.println(sb);
    }

    public static boolean isSame(char[] input, char c){
        for(int i=0; i<9; i+=3){
            if(input[i] == c && input[i+1] == c && input[i+2] == c){
                return true;
            }
        }

        for(int i=0; i<3; i++){
            if(input[i] == c && input[i+3] == c && input[i+6] == c){
                return true;
            }
        }

        if(input[0] == c && input[4] == c && input[8] == c){
            return true;
        }

        if(input[2] == c && input[4] == c && input[6] == c){
            return true;
        }

        return false;
    }
}