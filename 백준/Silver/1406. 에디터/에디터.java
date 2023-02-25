import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> result = new LinkedList<>();
        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());
        int cursor = input.length();

        for(int i=0; i<cursor; i++){
            result.add(input.charAt(i));
        }

        ListIterator<Character> iter = result.listIterator();
        while(iter.hasNext()){//커서를 맨 뒤로 이동
            iter.next();
        }

        while(M-- > 0){
            String command = br.readLine();
            switch (command.charAt(0)){
                case 'L':
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                    break;
                case 'D':
                    if(iter.hasNext()){
                        iter.next();
                    }
                    break;
                case 'B':
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(command.charAt(2));
                    break;
            }
            
        }

        StringBuilder sb = new StringBuilder();
        for(char c : result){
            sb.append(c);
        }
        System.out.println(sb);

    }


}