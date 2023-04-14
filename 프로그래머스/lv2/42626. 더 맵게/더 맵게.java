import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int len = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean high = false;
        for(int s : scoville){
            if(s < K){
                pq.add(s);
            }
            else{
                high = true;
            }
        }
        
        while(pq.size() > 1){
            int mix = pq.poll() + pq.poll()*2;
            if(mix < K){
                pq.add(mix);
            }
            else{
                high = true;
            }
            answer++;
        }
        
        if(pq.size() == 1){
            if(!high){
                answer = -1;
            }
            else{
                answer++;
            }
        }
        
        return answer;
    }
}