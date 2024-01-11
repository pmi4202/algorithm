import java.util.*;

class Solution {
    static int DIAMOND = 0;
    static int IRON = 1;
    static int STONE = 2;
    
    class Group implements Comparable<Group> {
        int[] cnt;

        public Group(){
            cnt = new int[3];
        }

        public int getStress(int pick){
            if(pick == DIAMOND){
                return cnt[0] + cnt[1] + cnt[2];
            }
            else if(pick == IRON){
                return cnt[0]*5 + cnt[1] + cnt[2];
            }
            else{
                return cnt[0]*25 + cnt[1]*5 + cnt[2];
            }
        }
        
        @Override
        public int compareTo(Group o){
            if(o.cnt[0] == this.cnt[0]){
                if(o.cnt[1] == this.cnt[1]){
                    return o.cnt[2] - this.cnt[2];
                }
                return o.cnt[1] - this.cnt[1];
            }
            return o.cnt[0] - this.cnt[0];
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        //init
        int pickCnt = 0;
        Map<String, Integer> mineralOrder = new HashMap<>();
        
        for(int pick : picks){
            pickCnt += pick;
        }
        
        mineralOrder.put("diamond", DIAMOND);
        mineralOrder.put("iron", IRON);
        mineralOrder.put("stone", STONE);
        
        //1. 광물 5개씩 그룹짓기
        List<Group> groups = new ArrayList<>();
        
        int idx = 0, size = Math.min(pickCnt * 5, minerals.length);
        while(idx < size){
            Group group = new Group();
            int max = Math.min(idx+5, size);
            while(idx < max){
                int mineralNo = mineralOrder.get(minerals[idx]);
                group.cnt[mineralNo]++;
                idx++;
            }
            groups.add(group);
        }
        
        //2. 정렬
        Collections.sort(groups);
        
        //3. 곡괭이 분배
        int answer = 0;
        int pickNo = 0;
        for(Group group : groups){
            while(picks[pickNo] <= 0){
                if(++pickNo >= 3) break;
            }
            picks[pickNo]--;
            answer += group.getStress(pickNo);
        }
        
        return answer;
    }
}

/*
1. 가중치 & 광물 개수 배열 만들기
- diamond : 25
- iron : 5
- stone : 1

*/