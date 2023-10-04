class Solution {
    public long solution(int[] weights) {
        long[] sum = new long[1001];
        
        //1. setting
        for(int weight : weights) sum[weight]++;
        
        //2. count
        long answer = 0;
        
        for(int i=100; i<=1000; i++){
            if(sum[i] == 0) continue;
            
            answer += sum[i]*(sum[i]-1)/2;
            
            if(i%2 == 0){
                answer += sum[i] * sum[i/2];
            }
            if(i%3 == 0){
                answer += sum[i] * sum[i/3*2];
            }
            if(i%4 == 0){
                answer += sum[i] * sum[i/4*3];
            }
        }
        return answer;
    }
}