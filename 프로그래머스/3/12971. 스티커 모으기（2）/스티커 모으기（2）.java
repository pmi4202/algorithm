class Solution {
    public int solution(int sticker[]) {
        int size = sticker.length;
        
        if(size <= 2){
            int answer = 0;
            for(int i=0; i<size; i++){
                answer = Math.max(answer, sticker[i]);
            }
            return answer;
        }
        
        int[][] dp = new int[2][size+1];    
        
        //1. use first
        dp[0][1] = sticker[0];
        for(int i=2; i<size; i++) dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+ sticker[i-1]) ;
        
        //2. not use first
        for(int i=2; i<=size; i++) dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + sticker[i-1]) ;
        
        return Math.max(dp[0][size-1], dp[1][size]);
    }
    
}
