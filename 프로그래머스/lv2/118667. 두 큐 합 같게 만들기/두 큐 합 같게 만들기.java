class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int idx = 0;
        int[] queue = new int[queue1.length + queue2.length];
        long sum = 0;
        for(int n : queue1) {
            sum += n;
            queue[idx++] = n;
        }
        for(int n : queue2) {
            sum += n;
            queue[idx++] = n;
        }
        
        //전체 수의 합이 홀수이면, 두 큐의 합이 같을 수 없다.
        if(sum%2!=0){
            return -1;
        }
        //전체 수의 합이 짝수일 때,
        return getResult(sum/2, queue1, queue2, queue);
    }
    
    public int getResult(long half, int[] q1, int[] q2, int[] queue){
        int start = 0, end = 0, result = Integer.MAX_VALUE;
        long sum = queue[0];
        int q1Size = q1.length, q2Size = q2.length, size = q1Size + q2Size;
        
        while(start<=end){
            if(sum == half){
                int temp = 0;
                if(end == q1Size-1){
                    temp = start;
                }
                else if(end > q1Size-1){
                    if(end == size-1){
                        temp = (start > q1Size-1) ? start - q1Size : q2Size + start;
                    }
                    else{
                        temp = end - q1Size + start + 1;
                    }
                }
                else{
                   temp = end + 1 + q2Size + start; 
                }
                result = Math.min(result, temp);   
            }
            
            if(sum < half){
                if(end == size-1) break;
                sum += queue[++end];
            }
            else{
                sum -= queue[start++];
            }
        }
        
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
/*
1. queue1 + queue2 순서대로 생각하자 
[!, !, -, -] [-, !, !, !] => 무조건 반반 나누기 때문에, 전체를 고려할 필요가 없다.
따라서, 두 queue의 순서가 바뀌는 건 무시 
2. 전체 수의 합을 구한 후, 절반이 되는 곳을 sliding window로 찾는다.
3. front포인터부터 end포인터까지 queue1에 담는다고 생각하고 계산한다.
(단, front포인터가 queue2안 && end포인터가 queue2의 끝자락이면 queue2에서만 poll해도 된다.)
*/