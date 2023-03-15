import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<len; i++){
            if(s.charAt(i) == '<'){
                result.append(temp.reverse());
                temp = new StringBuilder();

                while(s.charAt(i) != '>'){
                    result.append(s.charAt(i));
                    i++;
                }
                result.append('>');
            }
            else if(s.charAt(i) == ' '){
                result.append(temp.reverse()).append(' ');
                temp = new StringBuilder();
            }
            else{
                temp.append(s.charAt(i));
            }
        }
        result.append(temp.reverse());
        System.out.println(result);
    }
}