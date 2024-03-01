import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        return Math.max(getResultInA(arrayA, arrayB), getResultInA(arrayB, arrayA));
    }
    
    private int getResultInA(int[] a, int[] b){
        int result = 0;
        
        //1.
        int root = (int)Math.sqrt(a[0]);
        
        List<Integer> candidates = new ArrayList<>();
        for(int i=2; i<=root; i++){
            if(a[0] % i == 0){
                candidates.add(i);
                candidates.add(a[0]/i);
            }
        }
        candidates.add(a[0]);
        
        Collections.sort(candidates, Comparator.reverseOrder());
        
        
        //2. 
        for(int num : candidates){
            //2-1.
            boolean all = canDivideAll(num, a);
            if(!all) continue;
            //2-2.
            boolean any = cantDivideAny(num, b);
            if(!any) continue;
            
            result = num;
            break;
        }
        
        return result;
    }
    
    
    private boolean canDivideAll(int num, int[] arr){
        for(int a : arr){
            if(a % num != 0){
                return false;
            }
        }
        return true;
    }
    
    private boolean cantDivideAny(int num, int[] arr){
        for(int a : arr){
            if(a % num == 0){
                return false;
            }
        }
        return true;
    }
}

//철수의 인자들과 영희의 인자들과 겹치지 않는 수
/*
2, 7, 14 | 5, 7 35 | 7 17 119
//

2, 9, 18 | 2, 3, 5, 6, 10, 15, 30 | 

*/