class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] distance = new int[10][];
        int left = 10, right = 10;
        init(distance);
        
        for(int num : numbers){
            switch(num){
                case 1: case 4: case 7:
                    left = num;
                    answer.append('L');
                    break;
                case 3: case 6: case 9:
                    right = num;
                    answer.append('R');
                    break;
                default:
                    if(distance[num][left] < distance[num][right] || (distance[num][left] == distance[num][right] && "left".equals(hand))){
                        left = num;
                        answer.append('L');
                    }
                    else{
                        right = num;
                        answer.append('R');
                    }
            }
        }
        
        return answer.toString();
    }
    
    public void init(int[][] distance){
        distance[2] = new int[]{3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4};
        distance[5] = new int[]{2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3};
        distance[8] = new int[]{1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2};
        distance[0] = new int[]{0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1};
    }
}