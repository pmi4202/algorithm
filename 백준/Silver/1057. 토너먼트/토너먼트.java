import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        if(n1 > n2){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        int result = 1;
        while((n1%2)!=1 || n1+1!=n2){
            n1 = (n1+1)/2;
            n2 = (n2+1)/2;
            result++;
        }
        System.out.println(result);
    }
}