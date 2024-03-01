import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(getResultInA(arrayA, arrayB), getResultInA(arrayB, arrayA));
    }
    
    private int getResultInA(int[] a, int[] b){
        int result = 0;
        
        //1. 각 배열의 첫 번째 인자의 인수들을 후보로 추출
        int root = (int)Math.sqrt(a[0]);
        
        List<Integer> candidates = new ArrayList<>();
        for(int i=2; i<=root; i++){
            if(a[0] % i == 0){
                candidates.add(i);
                candidates.add(a[0]/i);
            }
        }
        candidates.add(a[0]);
        
        //2. 큰 숫자부터 검사할 수 있도록 정렬
        Collections.sort(candidates, Comparator.reverseOrder());
        
        
        //3. a의 값을 다 나눌 수 있지만, b의 값은 어떤 것도 못 나누는 값 체크
        for(int num : candidates){
            //3-1.
            boolean all = canDivideAll(num, a);
            if(!all) continue;
            //3-2.
            boolean any = cantDivideAny(num, b);
            if(!any) continue;
            
            result = num;
            break;
        }
        
        return result;
    }
    
    
    private boolean canDivideAll(int num, int[] arr){
        for(int a : arr){
            if(a % num != 0) return false;
        }
        return true;
    }
    
    private boolean cantDivideAny(int num, int[] arr){
        for(int a : arr){
            if(a % num == 0) return false;
        }
        return true;
    }
}
