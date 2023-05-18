import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Person{
        int grade = 1;
        int x, y;

        public Person(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            for(int j=0; j<i; j++){
                if(people[i].x > people[j].x && people[i].y > people[j].y){
                    people[j].grade++;
                }
                else if(people[i].x < people[j].x && people[i].y < people[j].y){
                    people[i].grade++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(people[i].grade).append(" ");
        System.out.println(sb);
    }
}