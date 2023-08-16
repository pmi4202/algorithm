class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        int[] result = new int[26];
        for(int i=0, size=survey.length; i<size; i++){
            if(choices[i] < 4){
                result[survey[i].charAt(0)-65] += 4-choices[i];
            }
            else{
                result[survey[i].charAt(1)-65] += choices[i]-4;
            }
        }
        
        if(result['R'-65] >= result['T'-65]) sb.append('R');
        else sb.append('T');
        
        if(result['C'-65] >= result['F'-65]) sb.append('C');
        else sb.append('F');
        
        if(result['J'-65] >= result['M'-65]) sb.append('J');
        else sb.append('M');
        
        if(result[0] >= result['N'-'A']) sb.append('A');
        else sb.append('N');
        
        return sb.toString();
    }
}
/*
1. 문자를 index로 숫자 배열 => 각 문자마다의 점수 count
2. 각 지표마다 두 문자가 가진 숫자 중 큰 걸로 출력
*/