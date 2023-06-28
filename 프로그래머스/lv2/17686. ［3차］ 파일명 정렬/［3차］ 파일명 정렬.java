import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("([a-z\\s.-]+)([0-9]+)");
        
        Arrays.sort(files, (o1, o2)->{
            Matcher m1 = pattern.matcher(o1.toLowerCase());
            Matcher m2 = pattern.matcher(o2.toLowerCase());
            
            m1.find();
            m2.find();
            
            if(!m1.group(1).equals(m2.group(1))){
                return m1.group(1).compareTo(m2.group(1));
            }
            else{
                return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
            }
            
        });
        
        return files;
    }
      
}

