import java.util.*;

class Record{
    String id;
    String status;
    
    public Record(String id, String status){
        this.id = id;
        this.status = status;
    }
}

class Solution {
    public String[] solution(String[] record) {
        final String ENTER = "님이 들어왔습니다.";
        final String LEAVE = "님이 나갔습니다.";
        Map<String, String> nicknameMap = new HashMap();
        List<Record> records = new ArrayList<>();
        
        //기록
        StringTokenizer st;
        for(String r : record){
            st = new StringTokenizer(r);
            String status = st.nextToken();
            switch(status){
                case "Enter" -> {
                    String id = st.nextToken();
                    String nickname = st.nextToken();
                    nicknameMap.put(id, nickname);
                    
                    records.add(new Record(id, ENTER));
                }
                case "Leave" -> records.add(new Record(st.nextToken(), LEAVE));
                case "Change" -> nicknameMap.put(st.nextToken(), st.nextToken());
            }
            
        }
        
        //결과 출력
        String[] result = new String[records.size()];
        int idx = 0;
        for(Record r : records){
            String nickname = nicknameMap.get(r.id);
            result[idx++] = nickname + r.status;
        }
        
        return result;
        
    }
}



/*
enter id nickname
leave id
change id new_nickname

1: enter
2: leave

*/