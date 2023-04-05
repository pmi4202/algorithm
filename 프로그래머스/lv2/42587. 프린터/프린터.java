import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] cnt = new int[10];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0, size = priorities.length; i<size; i++){
            cnt[priorities[i]]++;
            q.add(new int[]{i, priorities[i]});
        }
        
        int priority = 9;
        while(priority >= 0){
            if(cnt[priority] > 0){
                int[] now = q.poll();
                if(now[1] == priority){
                    cnt[priority]--;
                    answer++;
                    if(now[0] == location){
                        break;
                    }
                }
                else{
                    q.add(now);
                }
            }
            else{
                priority--;
            }
        }
        
        return answer;
    }
}