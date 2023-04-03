import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//접시 수
        int D = Integer.parseInt(st.nextToken());//가짓수
        int K = Integer.parseInt(st.nextToken());//연속해서 먹는 수
        int C = Integer.parseInt(st.nextToken());//쿠폰 번호
        int[] plates = new int[N];
        int[] record = new int[3001];//해당 번호의 음식 먹은 횟수 기록

        for(int i=0; i<N; i++){
            plates[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 1;
        record[C] = 1;
        for(int i=0; i<K; i++){
            if(record[plates[i]]++ == 0){
                cnt++;
            }
        }

        int result = cnt;
        if(N!=K){
            for(int i=0; i<N-1; i++){
                if(--record[plates[i]] == 0) cnt--;
                if(record[plates[(i+K)%N]]++ == 0) cnt++;
                result = Math.max(result, cnt);
            }
        }

        System.out.println(result);
    }
}