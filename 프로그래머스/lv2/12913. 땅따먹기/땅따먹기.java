class Number{
    int idx;
    int value;
    
    public Number(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int row = land.length;

        //init
        Number[] highest = new Number[2];
        for(int i=0; i<2; i++){
            highest[i] = new Number(0, 0);
        }
        
        //simulation
        for(int i=0; i<row; i++){
            //더하기
            for(int j=0; j<4; j++){
                land[i][j] += (j == highest[0].idx) ? highest[1].value : highest[0].value;
            }
            
            //최대값 구하기
            for(int j=0; j<4; j++){
                if(highest[0].value <= land[i][j]){
                    highest[1].idx = highest[0].idx;
                    highest[1].value = highest[0].value;
                    highest[0].idx = j;
                    highest[0].value = land[i][j];
                }
                else if(highest[1].value < land[i][j]){
                    highest[1].idx = j;
                    highest[1].value = land[i][j];
                }
            }
        }
        

        return highest[0].value;
    }
    
}