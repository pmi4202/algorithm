
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
        
        String[] subs = expression.split("\\"+ops[idx]);
        int size = subs.length;
        
        if(size == 1){
            return splitExpression(expression, ops, idx+1);
        }
        else{
            long[] arr = new long[size];
            for(int i=0; i<size; i++){
                arr[i] = splitExpression(subs[i], ops, idx+1);
            }
            
            return calculate(arr, ops[idx].charAt(0));
            
        }
        
    }
    
    public long calculate(long[] arr, char op){
        long result = 0;
        
        switch(op){
            case '+':
                for(long n : arr) result += n;
                break;
            case '-':
                result += arr[0]*2;
                for(long n : arr) result -= n;
                break;
            case '*':
                result = 1;
                for(long n : arr) result *= n;
                break;
        }
        
        return result;
    }
    
    
}
