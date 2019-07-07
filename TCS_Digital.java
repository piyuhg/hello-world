import java.util.Scanner;
public class tcs {
	public static double pn(double x, int n) {
		if(n==0)
			return 1;
		if(n==1)
			return x;
		return ((2*n -1)*x*pn(x,n-1)-(n-1)*pn(x,n-2))/(n);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = 2;
		m = s.nextInt();
		int n[] = new int[m];
		double x[] = new double[m];
		double res[] = new double[m];
		for(int i = 0;i<m && m<20;i++) {
			x[i] = s.nextDouble();
			n[i] = s.nextInt();	
		}
		for(int i = 0;i<m;i++) {
			res[i] = (Math.round(10000*(pn(x[i],n[i]))))/10000.0;
			//System.out.format("%.4f\n",res[i]);
			System.out.println(res[i]);			
		}		
	}
}
