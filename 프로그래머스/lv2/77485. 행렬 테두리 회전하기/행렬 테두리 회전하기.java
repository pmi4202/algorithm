class Point{
    int x, y;
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
            int[] query = queries[i];
            Point s = new Point();
            Point e = new Point();
            
            if(query[0] < query[2]){
                s.x = query[0];
                e.x = query[2];
            }
            else{
                s.x = query[2];
                e.x = query[0];
            }
            
            if(query[1] < query[3]){
                s.y = query[1];
                e.y = query[3];
            }
            else{
                s.y = query[3];
                e.y = query[1];
            }
            answer[i] = turn(map, s, e);
            // for(int a=1; a<=rows; a++){
            //     for(int b=1; b<=columns; b++){
            //         System.out.print(map[a][b]+" ");
            //     }
            //     System.out.println();
            // }
            
        }
        
        return answer;
    }
    
    public int turn(int[][] map, Point s, Point e){
        int temp = map[s.x][s.y];
        int min = temp;
        
        for(int i=s.x; i<e.x; i++){
            map[i][s.y] = map[i+1][s.y];
            min = Math.min(min, map[i][s.y]);
        }
        for(int j=s.y; j<e.y; j++){
            map[e.x][j] = map[e.x][j+1];
            min = Math.min(min, map[e.x][j]);
        }
        for(int i=e.x; i>s.x; i--){
            map[i][e.y] = map[i-1][e.y];
            min = Math.min(min, map[i][e.y]);
        }
        for(int j=e.y; j>s.y; j--){
            map[s.x][j] = map[s.x][j-1];
            min = Math.min(min, map[s.x][j]);
        }
        map[s.x][s.y+1] = temp;
    
        
        return min;
        
    }
}