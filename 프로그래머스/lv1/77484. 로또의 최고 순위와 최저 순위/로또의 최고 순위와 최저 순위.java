class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 7};
        boolean[] isWinNum = new boolean[46];
        
        for(int n : win_nums){
            isWinNum[n] = true;
        }
        
        for(int n : lottos){
            if(n==0){
                answer[0]--;
            }
            else if(isWinNum[n]){
                answer[1]--;
            }
        }
        answer[0] += answer[1];
        answer[0] = Math.min(answer[0], 6);
        answer[1] = Math.min(answer[1], 6);
        return answer;
    }
}