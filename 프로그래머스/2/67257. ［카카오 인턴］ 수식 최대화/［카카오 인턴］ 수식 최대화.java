import java.util.*;

class Solution {

    public long solution(String expression) {
        String[][] opSet = {
            {"+", "-", "*"},
            {"-", "+", "*"},
            {"+", "*", "-"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
        };

        long answer = 0;

        for(String[] ops : opSet){
            long temp = splitExpression(expression, ops, 0);
            if(temp < 0) temp *= -1;

            answer = Math.max(answer, temp);
        }
        return answer;
    }

    public long splitExpression(String expression, String[] ops, int idx){
        if(idx >= 3){
            return Integer.parseInt(expression);
        }

        StringTokenizer st = new StringTokenizer(expression, ops[idx]);
        
        long result = splitExpression(st.nextToken(), ops, idx+1);
        
        char op = ops[idx].charAt(0);
        if(op == '+'){
            while(st.hasMoreTokens()) result += splitExpression(st.nextToken(), ops, idx+1);
        } else if(op == '-'){
            while(st.hasMoreTokens()) result -= splitExpression(st.nextToken(), ops, idx+1); 
        } else{
            while(st.hasMoreTokens()) result *= splitExpression(st.nextToken(), ops, idx+1); 
        }
        
        return result;

    }

}