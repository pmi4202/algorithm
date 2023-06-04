import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Player implements Comparable<Player> {
        int lv;
        String name;

        public Player(int lv, String name){
            this.lv = lv;
            this.name = name;
        }

        @Override
        public int compareTo(Player p){
            return this.name.compareTo(p.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Player>> rooms = new ArrayList<>();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean done;
        while(p-- > 0){
            done = false;
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            for(List<Player> room : rooms){
                if(room.size() < m && Math.abs(room.get(0).lv-player.lv) <= 10){
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
            if(room.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            Collections.sort(room);
            for(Player player : room){
                sb.append(player.lv).append(" ")
                        .append(player.name).append("\n");
            }
        }
        System.out.println(sb);
    }
}