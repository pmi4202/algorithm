import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public  static class Road implements Comparable<Road>{
        int start;
        int end;
        int distance;
        public Road(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Road o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int result[] = new int[D+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        Road[] roads = new Road[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            roads[i] = new Road(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(roads);

        int idx = 0;
        for(int i=0; i<D; i++){

            while(idx < N && roads[idx].start == i) {
                if(roads[idx].end > D) {
                    idx++;
                    continue;
                }
                result[roads[idx].end] = Math.min(result[roads[idx].end], result[i] + roads[idx].distance);
                idx++;
            }
            result[i + 1] = Math.min(result[i + 1], result[i] + 1);

        }
        System.out.println(result[D]);
    }

}