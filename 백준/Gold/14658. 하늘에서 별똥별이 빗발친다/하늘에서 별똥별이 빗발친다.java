import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static class Star{
        int x, y;

        public Star(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Star[] stars = new Star[K];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            stars[i] = new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int max = 0;
        for(Star s1 : stars){
            for(Star s2 : stars){
                int x = s1.x;
                int y = s2.y;
                int nx = x + L;
                int ny = y + L;
                int cnt = 0;
                for(Star s : stars){
                    if(x<=s.x && s.x<=nx && y<=s.y && s.y<=ny){
                        cnt++;
                    }
                }
                if(max < cnt){
                    max = cnt;
                }
            }
        }
        System.out.println(K-max);
    }
}