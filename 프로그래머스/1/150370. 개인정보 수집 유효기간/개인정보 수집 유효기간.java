import java.util.*;

class Solution {
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        //1. 약관에 대한 유효기간
        int[] period = new int[26];
        
        for(String term : terms){
            StringTokenizer st = new StringTokenizer(term);
            period[st.nextToken().charAt(0)-'A'] = Integer.parseInt(st.nextToken()) * 28;
        }
        
        //2.
        List<Integer> answer = new ArrayList<>();
        int todayDays = getDayOf(today);
        
        for(int i=0, size = privacies.length; i<size; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            int deadline = getDayOf(st.nextToken()) + period[st.nextToken().charAt(0)-'A'];
            
            if(deadline <= todayDays){
                answer.add(i+1);
            }
        }
        
        
        return answer;
    }
    
    public int getDayOf(String date){
        StringTokenizer st = new StringTokenizer(date, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        return (year*12 + month)*28 + day;
    }
    
}