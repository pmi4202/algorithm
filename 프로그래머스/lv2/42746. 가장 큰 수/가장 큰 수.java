import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        int size = numbers.length;
        List<String> list = new ArrayList(size);
        for(int n : numbers){
            list.add(String.valueOf(n));
        }
        
        Collections.sort(list, (o1, o2)->{
            return (o2+o1).compareTo(o1+o2);
        });
        
        if(list.get(0).charAt(0) == '0'){
            return "0";
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(String s : list){
                sb.append(s);
            }
            return sb.toString();
        }
    }
}