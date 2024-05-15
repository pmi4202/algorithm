import java.util.*;

class Plan implements Comparable<Plan> {
    String subject;
    int start, playTime;
    
    public Plan(String subject, int start, int playTime){
        this.subject = subject;
        this.start = start;
        this.playTime = playTime;
    }
    
    @Override
    public int compareTo(Plan o){
        return this.start - o.start;
    }
}

class Solution {
    public List<String> solution(String[][] plans) {
        final int count = plans.length;
        Stack<Plan> inProcessStack = new Stack<>();
        Plan[] planList = new Plan[count];
        
        //init
        for(int i=0; i<count; i++){
            planList[i] = new Plan(plans[i][0], getMins(plans[i][1]), Integer.parseInt(plans[i][2]));
        }
        
        //정렬
        Arrays.sort(planList);
        
        //simulation
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<count-1; i++){
            inProcessStack.push(planList[i]);
            int remainTime = planList[i+1].start - planList[i].start;
            
            while(!inProcessStack.isEmpty() && remainTime > 0){
                remainTime -= inProcessStack.peek().playTime;
                if(remainTime >= 0){
                    answer.add(inProcessStack.pop().subject);
                } else{
                    inProcessStack.peek().playTime = -remainTime;
                }
            }
            
        }
        
        answer.add(planList[count-1].subject);
        
        while(!inProcessStack.isEmpty()) answer.add(inProcessStack.pop().subject);
        
        return answer;
    }
    
    public int getMins(String hour){
        return Integer.parseInt(hour.substring(0, 2))*60 + Integer.parseInt(hour.substring(3, 5));
    }
}