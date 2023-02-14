import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
3. 화면에 있는 이모티콘 중 하나를 삭제한다.
 */

public class Main {

    static int S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        System.out.println(bfs());
    }

    public static int bfs(){
        boolean[][] visited = new boolean[2000][2000];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});//screen, board
        visited[1][0] = true;

        int result = 0;
        while(!q.isEmpty()){
            for(int i = 0, size = q.size(); i < size; i++) {
                int now[] = q.poll();
                if (now[0] == S) {
                    return result;
                }
                if(now[0] < S){
                    //1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
                    if (!visited[now[0]][now[0]]) {
                        visited[now[0]][now[0]] = true;
                        q.add(new int[]{now[0], now[0]});
                    }
                    //2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
                    if (!visited[now[0] + now[1]][now[1]]) {
                        visited[now[0] + now[1]][now[1]] = true;
                        q.add(new int[]{now[0] + now[1], now[1]});
                    }
                }

                //3. 화면에 있는 이모티콘 중 하나를 삭제한다.
                if (now[0] > 1 && !visited[now[0] - 1][now[1]]) {
                    visited[now[0] - 1][now[1]] = true;
                    q.add(new int[]{now[0] - 1, now[1]});
                }
            }
            result++;
        }
        return result;
    }
}