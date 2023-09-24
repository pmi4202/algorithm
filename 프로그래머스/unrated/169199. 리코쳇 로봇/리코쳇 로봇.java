import java.util.*;

class Solution {
    int r, c;
    int rx, ry, gx, gy;
    int dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
    
    public int solution(String[] board) {
        r = board.length;
        c = board[0].length();
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i].charAt(j) == 'R'){
                    rx = i;
                    ry = j;
                }
                else if(board[i].charAt(j) == 'G'){
                    gx = i;
                    gy = j;
                }
            }
        }
        
        return getMinDistance(board);
    
    }
    
    public int getMinDistance(String[] board){
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rx, ry});
        boolean[][][] visited = new boolean[r][c][4];
        
        for(int i=0; i<4; i++) visited[rx][ry][i] = true;
        
        while(!q.isEmpty()){
            result++;
            
            for(int i=0, size = q.size(); i<size; i++){
                int[] now = q.poll();
                    
                for(int j=0; j<4; j++){
                    int[] next = getNextPos(board, visited, now[0], now[1], j);
                    if(next == null || (now[0] == next[0] && now[1] == next[1])) continue;
                    
                    if(next[0] == gx && next[1] == gy){
                        return result;
                    }
                    
                    q.add(next);
                    
                }
            }
            // if(result == 3) break;
        }
        return -1;
    }
    
    public int[] getNextPos(String[] board, boolean visited[][][], int x, int y, int dir){
        
        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(0<=nx && nx<r && 0<=ny && ny<c && board[nx].charAt(ny) != 'D'){
                if(visited[nx][ny][dir]) return null;
                
                visited[nx][ny][dir] = true;
                
                x = nx;
                y = ny;
            }
            else{
                break;
            }
        }
        return new int[]{x, y};
    }
}
/*
방향별 방문 체크
방문할 곳은 Queue에 넣기 => BFS
*/