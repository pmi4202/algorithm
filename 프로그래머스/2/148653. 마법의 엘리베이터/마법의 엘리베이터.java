class Solution {
    
    public int solution(int storey) {
        int result = 0;
        while(storey != 0){
            int upper = (storey%100)/10;
            int now = storey%10;
            
            if(now>5 || now==5 && upper>=5){
                storey+=10;
                result+=(10-now);
            } else{
                result+=now;
            }
            
            storey/=10;
        }
        return result;
    }
    
}