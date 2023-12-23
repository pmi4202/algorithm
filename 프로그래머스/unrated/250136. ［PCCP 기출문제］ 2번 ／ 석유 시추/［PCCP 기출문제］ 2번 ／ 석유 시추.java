class Solution {
    
    int n, m;
    int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        
        //1. 석유 사이즈
        int no = 2;
        int[] sizes = new int[n*m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1){
                    land[i][j] = no;
                    sizes[no] = dfs(land, i, j, no) + 1;
                    no++;
                }
            }
        }
        
        //2. max가 되는 열 구하기
        int answer = 0;
        for(int i=0; i<m; i++){
            int sum = 0;
            boolean[] visited = new boolean[no];
            
            for(int j=0; j<n; j++){
                if(visited[land[j][i]]) continue;
                
                visited[land[j][i]] = true;
                sum += sizes[land[j][i]];
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public int dfs(int[][] land, int x, int y, int no){
        int result = 0;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m || land[nx][ny] != 1){
                continue;
            }
            land[nx][ny] = no;
            result += dfs(land, nx, ny, no) + 1;
        }
        
        return result;
    }
}