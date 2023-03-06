import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            int board = 0;
            for(int i=0; i<3; i++){
                String input = br.readLine();
                for(int j=0; j<3; j++){
                    if(input.charAt(j) == '*'){
                        int idx = i*3 + j;
                        board |= (1<<idx);
                    }
                }
            }
            sb.append(bfs(board)).append("\n");

        }
        System.out.println(sb);
    }

    public static int bfs(int start){
        int step = 0;
        int[] dx = {0, -1, 0, 1, 0}, dy = {0, 0, 1, 0, -1};
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[1<<9];
        visited[start] = true;
        q.add(start);

        outloop : while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int now = q.poll();
                if(now == 0){
                    break outloop;
                }

                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        int next = now;
                        for(int k=0; k<5; k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx<0 || nx>=3 || ny<0 || ny>=3){continue;}
                            int pos = nx*3 + ny;
                            if((next & (1<<pos)) > 0){
                                next &= ~(1<<pos);
                            }
                            else{
                                next |= (1<<pos);
                            }
                        }
                        if(!visited[next]){
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }

            }
            step++;
        }

        return step;
    }
}