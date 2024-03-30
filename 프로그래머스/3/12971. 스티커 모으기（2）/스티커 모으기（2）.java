class Solution {
    public int solution(int sticker[]) {
        int size = sticker.length;
        int answer = 0;
        
        if(size <= 3){
            for(int i=0; i<size; i++){
                answer = Math.max(answer, sticker[i]);
            }
            return answer;
        }
        
        int[][] dp = new int[2][size+1];    
        
        //1. use first
        dp[0][1] = sticker[0];
        dp[0][3] = sticker[0] + sticker[2];
        for(int i=4; i<=size; i++) dp[0][i] = Math.max(dp[0][i-3], dp[0][i-2]) + sticker[i-1];
        answer = Math.max(dp[0][size-1], dp[0][size-2]);
        
        //2. not use first
        dp[1][2] = sticker[1];
        dp[1][3] = sticker[2];
        for(int i=4; i<=size; i++) dp[1][i] = Math.max(dp[1][i-3], dp[1][i-2]) + sticker[i-1];
        answer = Math.max(answer, Math.max(dp[1][size-1], dp[1][size]));
        
        return answer;
    }
    
}
