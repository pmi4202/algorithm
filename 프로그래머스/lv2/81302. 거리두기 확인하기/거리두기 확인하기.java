class Solution {
    
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            answer[i] = isFine(places[i]);    
        }
        
        return answer;
    }
    
    public int isFine(String[] map){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i].charAt(j)=='P'){
                    if(!check(map, i, j)) return 0;
                }
            }
        }
        return 1;
    }
    
    public boolean check(String[] map, int x, int y){
        for(int i=1; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=5 || ny<0 || ny>=5 || map[nx].charAt(ny) =='X') continue;
            
            if(map[nx].charAt(ny) == 'P') return false;
            else{
                for(int j=-1; j<=1; j++){
                    int mx = nx + dx[(i+j)%4];
                    int my = ny + dy[(i+j)%4];
                    if(mx<0 || mx>=5 || my<0 || my>=5) continue;
                    if(map[mx].charAt(my)=='P') return false;
                }
            }
        }
        return true;
    }
}