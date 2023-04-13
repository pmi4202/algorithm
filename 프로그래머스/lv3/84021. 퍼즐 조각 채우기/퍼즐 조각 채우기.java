/* 8:10
1. LinkedList<Block> puzzles -> table에서 dfs로 Puzzle을 다 분석해서 만들기
    1-1. 모양은 제일 위쪽 & 왼쪽 값을 (0, 0)으로 판단
2. board를 돌면서, dfs로 빈칸을 분석해서 넣을 수 있는 퍼즐 있는지 확인!
    2-2. 칸의 개수가 일치 => 회전 시켜가면서 모양이 일치한 지 판단하기
    2-3. 썼으면 체크
빈칸에 맞으면 무조건 끼워넣기 => 최대 개수
*/
import java.util.*;

class Block{
    int cnt;//칸의 개수
    int[][] shape = new int[6][2];//모양
}

class Solution {
    
    int n, m;
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        n = table.length;
        m = table.length;
        //1.
        List<Block> puzzles = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(table[i][j] == 1){
                    puzzles.add(findOne(table, i, j, 1, 0));
                }
            }
        }
        
        //2.
        boolean[] usedPuzzle = new boolean[puzzles.size()];
        n = game_board.length;
        m = game_board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(game_board[i][j] == 0){
                    //빈 칸 찾기
                    Block block = findOne(game_board, i, j, 0, 1);
                    
                    boolean find = false;
                    for(int k=0; k<puzzles.size(); k++){
                        if(usedPuzzle[k]) continue;
                        Block puzzle = puzzles.get(k);
                        if(canInsert(puzzle, block)){
                            usedPuzzle[k] = true;
                            answer+=puzzle.cnt;
                            break;
                        }
                    }
                    
                }
            }
        }
        return answer;
    }
    
    //block 하나 찾기
    public Block findOne(int[][] map, int x, int y, int flag, int blank){
        Block block = new Block();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = blank;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            block.shape[block.cnt++] = now;
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] == blank){
                    continue;
                }
                map[nx][ny] = blank;
                q.add(new int[]{nx, ny});
            }
        }
        
        //해당 블럭에서 가장 앞에 있는 블럭을 0,0으로 맞추기
        setCenter(block);
        return block;
    }
    
    public boolean canInsert(Block puzzle, Block blank){
        if(puzzle.cnt != blank.cnt){return false;}
        
        int size = puzzle.cnt;
        //회전
        for(int i=0; i<4; i++){
            boolean isMatch = true;
            for(int j=0; j<size; j++){
                int k = 0;
                for(; k<size; k++){
                    if(puzzle.shape[j][0] == blank.shape[k][0]
                       && puzzle.shape[j][1] == blank.shape[k][1]){
                        break;
                    }
                }
                if(k==size){
                    isMatch = false;
                    break;
                }
            }
            //맞는 퍼즐 찾으면 return true, 아니면 회전시켜보기
            if(isMatch){
                return true;
            }
            turn(puzzle);
        }
        return false;
    }
    
    public void turn(Block block){
        for(int i=0; i<block.cnt; i++){
            int temp = -block.shape[i][0];
            block.shape[i][0] = block.shape[i][1];
            block.shape[i][1] = temp;
        }
        setCenter(block);
    }
    
    public void setCenter(Block block){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        //해당 블럭에서 가장 앞에 있는 블럭 찾기
        for(int i=0; i<block.cnt; i++){
            if(block.shape[i][0] < minX){
                minX = block.shape[i][0];
                minY = block.shape[i][1];
            }
            else if(block.shape[i][0] == minX && block.shape[i][1] < minY){
                minY = block.shape[i][1];
            }
        }
        
        for(int i=0; i<block.cnt; i++){
            block.shape[i][0] -= minX;
            block.shape[i][1] -= minY;
        }
    }
    
}