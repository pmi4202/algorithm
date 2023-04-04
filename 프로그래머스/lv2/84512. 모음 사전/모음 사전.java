class Solution {
    
    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        int len = word.length();
        for(int i=0; i<len; i++){
            answer += count("AEIOU".indexOf(word.charAt(i)), i);
            answer++;
        }
        return answer;
    }
    
    public int count(int order, int i){
        int sum = 0, temp = 1;
        for(int a=0; a<=3-i; a++){
            sum += temp;
            temp*=5;
        }
        return order * ((int)Math.pow(5, 4-i) + sum);
    }
    
}
/*
5^(len-1-i) + sum(1*5^(0~(len-2-i)))
*/