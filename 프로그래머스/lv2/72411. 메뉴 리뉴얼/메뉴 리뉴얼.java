import java.util.*;

class Solution {
    
    Map<String, Integer> map;    
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        //각 문자열 오름차순 정렬
        for(int i=0; i<orders.length; i++){
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }
        
        //조합
        int max = 0;
        for(int k : course){
            map = new HashMap<>();
            max = 0;
            for(String order : orders){
                combination(order, k, 0, 0, new StringBuilder());
            }
            
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                max = Math.max(max, entry.getValue());
            }
            
            if(max < 2) continue;
            
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue() == max){
                    answer.add(entry.getKey());
                }
            } 
            
        }
        Collections.sort(answer);
        
        return answer;
    }
    
    public void combination(String s, int k, int idx, int cnt, StringBuilder sb){
        if(cnt == k){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            sb.append(s.charAt(i));
            combination(s, k, i+1, cnt+1, sb);
            sb.delete(cnt, cnt+1);
        }
    }
}