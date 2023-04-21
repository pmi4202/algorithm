import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(Integer.parseInt(br.readLine()));
        sb.append(minHeap.peek()).append("\n");
        for(int i=2; i<=N; i++){
            int num = Integer.parseInt(br.readLine());
            if(minHeap.peek() <= num){
                minHeap.offer(num);
                if(minHeap.size() > maxHeap.size()){
                    maxHeap.offer(minHeap.poll());
                }
            }
            else{
                maxHeap.offer(num);
                if(maxHeap.size() > minHeap.size()+1){
                    minHeap.offer(maxHeap.poll());
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}