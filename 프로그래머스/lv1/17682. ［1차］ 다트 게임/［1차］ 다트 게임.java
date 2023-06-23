class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int prev = 0, now = 0;
        for(int i=0, size = dartResult.length(); i<size; i++){
            char op = dartResult.charAt(i);
            //숫자라면,
            if('0' <= op && op <= '9'){
                answer += prev;
                prev = now;
                
                now = op - '0';
                if(dartResult.charAt(i+1) == '0'){
                    now*=10;
                    i++;
                }
            }
            else{
                switch(op){
                    case 'T':
                        now = (int)Math.pow(now, 3);
                        break;
                    case 'D':
                        now*=now;
                        break;
                    case '*':
                        prev*=2;
                        now*=2;
                        break;
                    case '#':
                        now*=-1;
                }
            }
        }
        answer += prev + now;
        
        return answer;
    }
}