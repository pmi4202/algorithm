import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        sb.append(getGCD(n1, n2)).append("\n").append(getLCM(n1, n2));
        System.out.println(sb);
    }

    static int getGCD(int n1, int n2){
        while(n1>0 && n2>0){
            if(n1 < n2){
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n1-=n2;
        }
        return (n1 > 0) ? n1 : n2;
    }

    static int getLCM(int n1, int n2){
        int t1 = n1, t2 = n2;
        while(n1 != n2){
            if(n1 < n2){
                n1 += t1;
            }
            else{
                n2 += t2;
            }
        }
        return n1;
    }
}