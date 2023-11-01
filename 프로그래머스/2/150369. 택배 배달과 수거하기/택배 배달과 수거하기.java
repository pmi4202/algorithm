import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIdx = n-1, pickIdx = n-1;
        
        while(delIdx != -1 || pickIdx != -1){
            while(delIdx >= 0 && deliveries[delIdx] == 0) delIdx--;
            while(pickIdx >= 0 && pickups[pickIdx] == 0) pickIdx--;
            
            int temp = Math.max(delIdx, pickIdx) + 1;
            answer += temp;
            
            updateStatus(cap, deliveries, delIdx);
            updateStatus(cap, pickups, pickIdx);
        }
        
            
        return answer*2;
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