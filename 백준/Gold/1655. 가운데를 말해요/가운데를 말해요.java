import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int mid = Integer.parseInt(br.readLine());
        maxHeap.add(-mid);
        sb.append(mid).append("\n");
        for(int i=2; i<=N; i++){
            int num = Integer.parseInt(br.readLine());
            if(mid < num){
                minHeap.offer(num);
                if(minHeap.size() > maxHeap.size()){
                    maxHeap.offer(-minHeap.poll());
                }
            }
            else{
                maxHeap.offer(-num);
                if(maxHeap.size() > minHeap.size()+1){
                    minHeap.offer(-maxHeap.poll());
                }
            }

            mid = -maxHeap.peek();
            sb.append(mid).append("\n");
        }
        System.out.println(sb);
    }
}