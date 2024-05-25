class Solution {
    
    public int solution(int storey) {
        return getResult(storey, 1, 0);
    }
    
    public int getResult(int storey, int idx, int cnt){
        if(storey < 0) return Integer.MAX_VALUE;
        if(storey == 0) return cnt;
        
        //+
        int n = storey%(idx*10);
        int plusResult = getResult(storey+(idx*10)-n, idx*10, cnt+(10-n/idx));
        //-
        int minusResult = getResult(storey-n, idx*10, cnt+n/idx);
        return Math.min(plusResult, minusResult);
    }
}