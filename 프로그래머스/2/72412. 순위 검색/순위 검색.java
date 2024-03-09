import java.util.*;

class Solution {
    
    public int[] solution(String[] info, String[] query) {
        
        //1.
        Map<String, List<Integer>> scoreMap = new HashMap<>();
        
        for(int i=0; i<info.length; i++){
            StringTokenizer st = new StringTokenizer(info[i]);
            recur(0, scoreMap, 
                  new String[]{st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()}, 
                  Integer.parseInt(st.nextToken()));
        }
        
        scoreMap.forEach((k, v) -> Collections.sort(v));
        
        //2.
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++){
            String[] conditions = query[i].split(" ");
            String now = conditions[0] + conditions[2] + conditions[4] + conditions[6];
            int score = Integer.parseInt(conditions[7]);
            
            List<Integer> scores = scoreMap.getOrDefault(now, new ArrayList<>());
            
            //
            int pos = binarySearch(scores, score, 0, scores.size()-1);
            if(pos < 0) answer[i] = 0;
            else answer[i] = scores.size() - pos;
                
        }
        
            
        return answer;
        
    }
    
    public int binarySearch(List<Integer> scores, int num, int l, int r){
        while(l <= r){
            int m = (l+r)/2;
            
            if(num <= scores.get(m)){
                r = m-1;
            } else{
                l = m+1;
            }
        }
        
        return l;
    }
    
    public void recur(int index, Map<String, List<Integer>> scoreMap, String[] infos, int score){
        if(index >= 4){
            String key = infos[0]+infos[1]+infos[2]+infos[3];
            List<Integer> scores = scoreMap.getOrDefault(key, new ArrayList<>());
            scores.add(score);
            scoreMap.put(key, scores);
            return;
        }
        
        recur(index+1, scoreMap, infos, score);
        
        String temp = infos[index];
        infos[index] = "-";
        recur(index+1, scoreMap, infos, score);
        infos[index] = temp;
    }
        
}