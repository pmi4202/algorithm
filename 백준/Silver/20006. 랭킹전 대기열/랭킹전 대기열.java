import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pCount = Integer.parseInt(st.nextToken());
        int roomMax = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < pCount; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            boolean isInsert = false;
            for (int j = 0; j < rooms.size(); j++) {
                Room room = rooms.get(j);

                if (room.start <= level && room.end >= level && room.users.size() != roomMax) {
                    room.users.add(new User(level, nickname));
                    isInsert = true;
                    break;
                }
            }

            if (!isInsert) {
                Room room = new Room(level - 10, level + 10);
                room.users.add(new User(level, nickname));
                rooms.add(room);
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            List<User> users = room.users;
            Collections.sort(users);

            if (users.size() != roomMax) {
                System.out.println("Waiting!");
            } else {
                System.out.println("Started!");
            }

            for (int j = 0; j < users.size(); j++) {
                User user = users.get(j);
                System.out.println(user.level + " " + user.nickname);
            }
        }
    }

    static class Room {
        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;

        List<User> users = new ArrayList<>();
    }

    static class User implements Comparable<User> {
        public User(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        int level;
        String nickname;

        public int compareTo(User other) {
            return this.nickname.compareTo(other.nickname);
        }
    }
}