import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        int[] result = new int[N + 1];
        int len = 0;

        for(int i=0; i<N; i++){
            line[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++){
            if(result[len] < line[i]){
                result[++len] = line[i];
            }
            else{
                int l = 0, r = len;
                while(l<r){
                    int mid = (l+r)/2;
                    if(result[mid] < line[i]){
                        l = mid + 1;
                    }
                    else{
                        r = mid;
                    }
                }
                result[l] = line[i];
            }
        }
        System.out.println(N-len);
    }

}