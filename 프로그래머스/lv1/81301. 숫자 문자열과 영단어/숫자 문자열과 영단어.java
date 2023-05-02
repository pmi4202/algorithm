class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0, len = s.length();
        
        while(idx < len){
            char c = s.charAt(idx);
            if('0' <= c && c <= '9'){
                sb.append(c);
            }
            else{
                switch(c){
                    case 'z':
                        idx+=3;
                        sb.append('0');
                        break;
                    case 'o':
                        idx+=2;
                        sb.append('1');
                        break;
                    case 't':
                        if(s.charAt(idx+1)=='w'){
                            idx+=2;
                            sb.append('2');
                        }
                        else{
                            idx+=4;
                            sb.append('3');
                        }
                        break;
                    case 'f':
                        if(s.charAt(idx+1)=='o'){
                            idx+=3;
                            sb.append('4');
                        }
                        else{
                            idx+=3;
                            sb.append('5');
                        }
                        break;
                    case 's':
                        if(s.charAt(idx+1)=='i'){
                            idx+=2;
                            sb.append('6');
                        }
                        else{
                            idx+=4;
                            sb.append('7');
                        }
                        break;
                    case 'e':
                        idx+=4;
                        sb.append('8');
                        break;
                    case 'n':
                        idx+=3;
                        sb.append('9');
                        break;
                }
            }
            idx++;
        }
        return Integer.parseInt(sb.toString());
    }
}