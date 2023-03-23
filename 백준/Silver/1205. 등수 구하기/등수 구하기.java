import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//비오름차순 : >=
public class Main {

    static int N, score, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if(N==0){
            System.out.println(1);
        }
        else{
            int[] arr =  new int[N+2];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(getGrade(arr));
        }

    }

    public static int getGrade(int[] arr){
        int idx =  1;
        while(idx<=N && arr[idx] > score){
            idx++;
        }
        int grade = idx;
        while(idx<=N && arr[idx] == score){
            idx++;
        }

        return (idx>P) ? -1 : grade;
    }
}