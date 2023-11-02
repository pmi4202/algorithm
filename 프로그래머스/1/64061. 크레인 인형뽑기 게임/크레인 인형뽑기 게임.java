import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        // 인접 리스트
        int len = board.length;
        ArrayList<Integer>[] list = new ArrayList[len + 1];
        for(int i = 1; i <= len; i++) list[i] = new ArrayList<>();   
                
        for(int i = len - 1; i >= 0; i--) {
            for(int j = len - 1; j >= 0; j--) {
                if(board[i][j] == 0) continue;
                list[j + 1].add(board[i][j]);
            }
        }
        
        for(int move : moves) {
            if(list[move].size() == 0) continue;
            int size = list[move].size() - 1;
            int sel = list[move].get(size);
            if(!stack.isEmpty() && stack.peek() == sel) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(sel);
            }
            list[move].remove(size);
        }
            
        
        return answer;
    }
    
}