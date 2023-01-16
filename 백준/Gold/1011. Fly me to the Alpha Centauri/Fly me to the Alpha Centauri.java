import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long x, y, len;
		double temp;
		int j=0, result;
		
		for(int i=0;i<n;i++) {
			x=sc.nextLong();
			y=sc.nextLong();
			len = y-x;
			
			if(len==1||len==2||len==3) {
				System.out.println((int)len);
				continue;
			}
			if(len==5) {
				System.out.println("4");
				continue;
			}
			
			temp=Math.sqrt(len);
			int temp2 = (int)temp;
			long k = len-temp2*temp2;
			
			if(k==0)
				result=(temp2-1)*2+1;
			else if(k<len && k<temp2) {//중간이 n-1 n n-1
				result=(temp2-1)*2+2;
			}
			else if(temp2<=k && k<temp2*2){//중간이 n-1 n n n-1
				if(k==temp2)
					result=(temp2-1)*2+2;
				else {
					result=(temp2-1)*2+3;
				}
			}
			else {//중간이 n-1 n n n n-1
				if(k==temp2*2)
					result=(temp2-1)*2+3;
				else
					result=(temp2-1)*2+4;
			}
			
			System.out.println(result);
		}
	}
}