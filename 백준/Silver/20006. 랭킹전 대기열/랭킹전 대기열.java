import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        public Player(int level, String nickname){
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player p){
            return this.nickname.compareTo(p.nickname);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Player>> rooms = new ArrayList<>();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while(p-- > 0){
            boolean done = false;
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            for(List<Player> room : rooms){
                if(room.size() < m && Math.abs(room.get(0).level-player.level) <= 10){
                    room.add(player);
                    done = true;
                    break;
                }
            }
            if(!done){
                List createdRoom = new ArrayList();
                createdRoom.add(player);
                rooms.add(createdRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(List<Player> room : rooms){
            sb.append((room.size()==m) ? "Started!\n" : "Waiting!\n");
            room.stream().sorted().forEach((Player player)->{
                sb.append(player.level).append(" ")
                        .append(player.nickname).append("\n");
            });
        }
        System.out.println(sb);
    }
}