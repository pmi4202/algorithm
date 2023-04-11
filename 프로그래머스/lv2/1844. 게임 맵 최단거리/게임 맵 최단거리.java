import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        return bfs(n, m, maps);
    }
    
    public int bfs(int n, int m, int[][] maps){
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        maps[0][0] = 2;//지금까지 몇 칸을 갔는지 확인용
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == n && now[1] == m){
                return maps[n][m] - 1;
            }
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>n || ny<0 || ny>m || maps[nx][ny] != 1) continue;
                maps[nx][ny] = maps[now[0]][now[1]] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return -1;
    }
}