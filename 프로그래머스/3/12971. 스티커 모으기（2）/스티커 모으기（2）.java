class Solution {
    public int solution(int sticker[]) {
        int size = sticker.length;
        
        if(size <= 3){
            int answer = 0;
            for(int i=0; i<size; i++) answer = Math.max(answer, sticker[i]);
            return answer;
        } else{
            return Math.max(getMax(0, size-1, sticker), getMax(1, size, sticker));
        } 
    }
    
    private int getMax(int from, int to, int[] sticker){
        int size = sticker.length;
        int[] dp = new int[size+1];
        
        dp[1] = sticker[from]; 
        
        for(int i=from+1, idx=2; i<to; i++, idx++){
            dp[idx] = Math.max(dp[idx-1], dp[idx-2] + sticker[i]);
        }
        return dp[size-1];
    }
    
}
