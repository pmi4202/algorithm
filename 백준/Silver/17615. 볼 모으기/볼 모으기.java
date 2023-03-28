import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Rcnt = 0, Bcnt = 0, result;

        String s = br.readLine();
        char[] arr = new char[N];
        for(int i=0; i<N; i++){
            arr[i] = s.charAt(i);
            if(arr[i] == 'R') Rcnt++;
            else Bcnt++;
        }
        result = Math.min(Rcnt, Bcnt);

        if(result==0){
            System.out.println(0);
            return;
        }
        char temp = arr[0];
        int idx = 0;
        while(idx<N && arr[idx] == temp) idx++;

        result = Math.min(result, (temp=='R') ? Rcnt-idx : Bcnt-idx);

        temp = arr[N-1];
        idx = N-1;
        while(idx>=0 && arr[idx] == temp) idx--;
        result = Math.min(result, (temp=='R') ? Rcnt-(N-1-idx) : Bcnt-(N-1-idx));

        System.out.println(result);

    }
}