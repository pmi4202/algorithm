import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long x, y, len;
		double temp;
		int j=0, result;
		
		for(int i=0;i<T;i++) {
			x=sc.nextLong();
			y=sc.nextLong();
			len = y-x;
			
			if(len < 4) { //증가할 일 없음
				System.out.println((int)len);
				continue;
			}
			
			temp = Math.sqrt(len); //전체길이에 루트. 즉, 자신보다 작은 제곱수 중에 가장 큰 수 n 찾기
			int n = (int)temp;
			long k = len-n*n; //(전체 길이) - (유지하는 경우 없을 때 이동 거리)
			
			if(k==0)
				result=(n-1)*2+1;//유지하는 경우가 없을 때
			else if(k<len && k<n) {//중간이 n-1 n n-1, n보다 작은 수 유지 1번
				result=(n-1)*2+2;
			}
			else if(n<=k && k<n*2){//중간이 n-1 n n n-1
				if(k==n)//n을 1번 유지
					result=(n-1)*2+2;
				else {//n을 1번 유지 + n보다 작은 수 유지 1번
					result=(n-1)*2+3;
				}
			}
			else {//중간이 n-1 n n n n-1
				if(k==n*2)//n을 2번 유지
					result=(n-1)*2+3;
				else//n을 2번 유지 + n보다 작은 수 유지 1번
					result=(n-1)*2+4;
			}
			
			System.out.println(result);
		}
	}
}