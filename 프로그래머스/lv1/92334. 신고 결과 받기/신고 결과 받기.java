import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
        int[] answer = new int[N];
        Map<String, Integer> id = new HashMap<>();
        Map<String, Set<Integer>> reportMap = new HashMap<>();
        for(int i=0; i<N; i++){
            id.put(id_list[i], i);
        }
        
        StringTokenizer st;
        for(String r : report){
            st = new StringTokenizer(r);
            int from = id.get(st.nextToken());
            String to = st.nextToken();
            if(!reportMap.containsKey(to)){
                reportMap.put(to, new HashSet<>());
            }
            reportMap.get(to).add(from);
        }
        
        for(Set<Integer> set : reportMap.values()){
            if(set.size() < k){
                continue;      
            }
            for(int userId : set){
                answer[userId]++;
            }
        }
        return answer;
    }
}