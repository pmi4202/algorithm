import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Item implements Comparable<Item> {
        int idx, height;

        public Item(int idx, int height){
            this.idx = idx;
            this.height = height;
        }

        @Override
        public int compareTo(Item item){
            return this.idx - item.idx;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Item[] items = new Item[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(items);

        //
        Stack<Item> s = new Stack<>();
        Item maxItem = new Item(0, 0);
        s.add(maxItem);

        int result = 0;
        for(Item item : items){
            while(!s.isEmpty() && s.peek().height < item.height){
                s.pop();
            }
            s.add(item);

            if(maxItem.height < item.height){
                result += (item.idx - maxItem.idx) * maxItem.height;
                maxItem = item;
            }
        }
        //
        while(s.size() > 1){
            Item now = s.pop();
            result += (now.idx - s.peek().idx) * now.height;
        }
        result += s.peek().height;
        System.out.println(result);
    }
}