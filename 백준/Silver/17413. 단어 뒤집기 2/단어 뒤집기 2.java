import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int len = input.length;

        StringBuilder result = new StringBuilder();
        int idx = 0;
        while(idx < len){
            if(input[idx] == '<'){
                while(input[idx++] != '>'){}
            }
            else{
                int start = idx;
                while(idx < len && input[idx] != ' ' && input[idx] != '<'){
                    idx++;
                }
                int end = idx-1;
                while(start < end){
                    char temp = input[start];
                    input[start] = input[end];
                    input[end] = temp;
                    start++;
                    end--;
                }
                if(idx < len && input[idx] == ' '){
                    idx++;
                }
            }
        }

        System.out.println(input);
    }
}