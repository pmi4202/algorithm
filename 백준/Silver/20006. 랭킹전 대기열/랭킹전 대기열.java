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

    static class Room{
        int space;
        List<Player> players;

        public Room(int m){
            space = m;
            players = new ArrayList<>();
        }

        boolean join(Player p){
            if(players.size() > 0){
                if(space == 0 || Math.abs(players.get(0).level-p.level) > 10){
                    return false;
                }
            }
            players.add(p);
            space--;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Room> rooms = new ArrayList<>();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while(p-- > 0){
            boolean done = false;
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            for(Room room : rooms){
                if(room.join(player)){
                    done = true;
                    break;
                }
            }
            if(!done){
                Room createdRoom = new Room(m);
                createdRoom.join(player);
                rooms.add(createdRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Room room : rooms){
            sb.append((room.space==0) ? "Started!\n" : "Waiting!\n");
            Collections.sort(new ArrayList(room.players));
            room.players.stream().sorted().forEach((Player player)->{
                sb.append(player.level).append(" ")
                        .append(player.nickname).append("\n");
            });
        }
        System.out.println(sb);
    }
}
