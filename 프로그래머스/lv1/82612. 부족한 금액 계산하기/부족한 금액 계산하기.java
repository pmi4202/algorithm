class Solution {
    public long solution(long price, int money, int count) {
        long answer = price * (count * (count + 1))/2 - money;       
        return answer > 0 ? answer : 0;
    }
}