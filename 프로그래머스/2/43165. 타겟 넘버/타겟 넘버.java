class Solution {
    public int solution(int[] numbers, int target) {
        return makeTarget(numbers.length-1, 0, numbers, target);
    }
    
    public int makeTarget(int idx, int sum, int[] numbers, int target){
        if(idx < 0){
            return sum == target ? 1 : 0;
        }
        
        return makeTarget(idx-1, sum + numbers[idx], numbers, target) + makeTarget(idx-1, sum - numbers[idx], numbers, target);
        
    }
}