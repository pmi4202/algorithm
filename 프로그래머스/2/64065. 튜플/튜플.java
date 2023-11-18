import java.util.*;

class Number implements Comparable<Number> {
    int n, cnt;
    
    public Number(int n, int cnt){
        this.n = n;
        this.cnt = cnt;
    }
    
    @Override
    public int compareTo(Number o){
        return o.cnt - this.cnt;
    }
}

class Solution {
    
    public int[] solution(String s) {
        
        List<Number> result = sort(countNum(s));
        
        return NumberListToArr(result);
        
    }
    
    public Map<Integer, Integer> countNum(String s){
        Map<Integer, Integer> countMap = new HashMap<>();
        int temp = 0;
        
        for(int i=0, size = s.length(); i<size; i++){
            char c = s.charAt(i);
            
            if(c < '0' || '9' < c){
                if(temp > 0){
                    countMap.put(temp, countMap.getOrDefault(temp, 0) + 1);
                    temp = 0;
                }  
            }
            else{
                temp = temp*10 + (c -'0');
            }
            
        }
        
        return countMap;
    }
    
    public List<Number> sort(Map<Integer, Integer> countMap){
        List<Number> arr = new ArrayList<>();
        
        countMap.forEach((key, value) ->{
            arr.add(new Number(key, value));
        });
        
        Collections.sort(arr);
        
        return arr;
    }
    
    public int[] NumberListToArr(List<Number> list){
        int size = list.size();
        int[] result = new int[size];
        
        for(int i=0; i<size; i++){
            result[i] = list.get(i).n;
        }
        
        return result;
    }
    
}
/*
1. map
2. arr
*/