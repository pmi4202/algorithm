import java.util.*;

class Solution {
    
    static int[] answer;
    static ArrayList<Integer>[] limit;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        init(users);
        simulation(emoticons, emoticons.length-1, new int[5]);
        
        return answer;
    }
    
    public void simulation(int[] emoticons, int idx, int[] pricePerDiscount){
        if(idx < 0){
            int[] result = new int[2];
            int temp = 0;
            
            for(int i=4; i>0; i--){
                temp+=pricePerDiscount[i];
                
                for(int l : limit[i]){
                    if(l <= temp) result[0]++;
                    else result[1] += temp;
                }
                
            }
            
            if(answer[0] < result[0]){
                answer[0] = result[0];
                answer[1] = result[1];
            }
            else if(answer[0] == result[0]){
                answer[1] = Math.max(answer[1], result[1]);
            }
            
            // System.out.println(Arrays.toString(pricePerDiscount));
            return;
        }
        
        for(int i=1; i<=4; i++){
            int price = emoticons[idx]/10*(10-i);
            pricePerDiscount[i] += price;
            simulation(emoticons, idx-1, pricePerDiscount);
            pricePerDiscount[i] -= price;
        }
    }
    
    public void init(int[][] users){
        answer = new int[2];
        limit = new ArrayList[5];
        for(int i=1; i<=4; i++) limit[i] = new ArrayList<>();
        
        for(int[] user : users){
            limit[(user[0]-1)/10+1].add(user[1]);
            // System.out.println(user[0] + ", " + user[1]);
            // System.out.println(limit[2].get(0));
        }
    }
    
}