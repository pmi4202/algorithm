import java.util.*;

class Date {
    int year, mon, day;
    
    public Date(String date){
        StringTokenizer st = new StringTokenizer(date, ".");
        this.year = Integer.parseInt(st.nextToken());
        this.mon = Integer.parseInt(st.nextToken());
        this.day = Integer.parseInt(st.nextToken());
    }
    
    public void toLast(int period){
        int total = mon + period;
        if(total % 12 == 0){
            this.mon = 12;
            this.year += (total - 12)/12;
        } else{
            this.mon = total % 12;
            this.year += total / 12;
        }
    }
    
    public int compareTo(Date o){
        if(this.year == o.year){
            return (this.mon == o.mon) ? this.day - o.day : this.mon - o.mon;
        } else{
            return this.year - o.year;
        }
    }
    
}

class Solution {
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        //1. 약관에 대한 유효기간
        int[] period = new int[26];
        
        for(String term : terms){
            StringTokenizer st = new StringTokenizer(term);
            period[st.nextToken().charAt(0)-'A'] = Integer.parseInt(st.nextToken());
        }
        
        //2.
        Date todayDate = new Date(today);
        
        for(int i=0, size = privacies.length; i<size; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            Date now = new Date(st.nextToken());
            now.toLast(period[st.nextToken().charAt(0)-'A']);
            
            if(todayDate.compareTo(now) >= 0){
                answer.add(i+1);
            }
        }
        
        
        return answer;
    }
}