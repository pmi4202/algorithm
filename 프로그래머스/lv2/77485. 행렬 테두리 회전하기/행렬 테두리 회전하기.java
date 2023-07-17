class Point{
    int x, y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        
        int temp = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = temp++;
            }
        }
        
        for(int i=0, size = queries.length; i<size; i++){
            answer[i] = turn(map, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        
        return answer;
    }
    
    public int turn(int[][] map, int sx, int sy, int ex, int ey){
        int temp = map[sx][sy];
        int min = temp;
        
        for(int i=sx; i<ex; i++){
            map[i][sy] = map[i+1][sy];
            min = Math.min(min, map[i][sy]);
        }
        for(int j=sy; j<ey; j++){
            map[ex][j] = map[ex][j+1];
            min = Math.min(min, map[ex][j]);
        }
        for(int i=ex; i>sx; i--){
            map[i][ey] = map[i-1][ey];
            min = Math.min(min, map[i][ey]);
        }
        for(int j=ey; j>sy; j--){
            map[sx][j] = map[sx][j-1];
            min = Math.min(min, map[sx][j]);
        }
        map[sx][sy+1] = temp;
    
        
        return min;
        
    }
}