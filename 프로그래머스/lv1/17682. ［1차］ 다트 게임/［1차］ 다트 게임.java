class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int prev = 0, now = 0;
        for(int i=0, size = dartResult.length(); i<size; i++){
            now = dartResult.charAt(i) - '0';
            if(dartResult.charAt(i+1) == '0'){
                now*=10;
                i++;
            }
            
            switch(dartResult.charAt(++i)){
                case 'T':
                    now = (int)Math.pow(now, 3);
                    break;
                case 'D':
                    now*=now;
                    break;
            }
            
            if(i+1<size){
                if(dartResult.charAt(i+1)=='#'){
                    now*=-1;
                    i++;
                }
                else if(dartResult.charAt(i+1)=='*'){
                    prev*=2;
                    now*=2;
                    i++;
                }
            }
            answer += prev;
            prev = now;
        }
        answer += prev;
        
        return answer;
    }
}