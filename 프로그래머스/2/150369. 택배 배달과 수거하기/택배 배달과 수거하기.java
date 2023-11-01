import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIdx = n-1, pickIdx = n-1;
        
        while(delIdx != -1 || pickIdx != -1){
            delIdx = getNextPos(deliveries, delIdx);
            pickIdx = getNextPos(pickups, pickIdx);
            
            int temp = Math.max(delIdx, pickIdx) + 1;
            answer += temp*2;
            
            updateStatus(cap, deliveries, delIdx);
            updateStatus(cap, pickups, pickIdx);
        }
        
            
        return answer;
    }
    
    public int getNextPos(int[] arr, int idx){
        while(idx >=0 && arr[idx] == 0) idx--;
        
        return idx;
    }
    
    public int updateStatus(int cap, int[] arr, int idx){
        
        while(idx >= 0 && cap > 0){
            if(arr[idx] == 0){
                idx--;
                continue;
            }
            
            int available = Math.min(cap, arr[idx]);
            cap -= available;
            arr[idx] -= available;
        }
        
        return idx;
    }
    
}