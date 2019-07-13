import java.util.Scanner;
public class B {

	private static long leastValue(String s,int base) {
		long val = 0;
		for(int i=0;i<s.length();i++) {
			int j = charToint(s.charAt(i));	
			val = (long)(val + j*Math.pow(base+1, s.length()-i-1));
		}
		return val;
	}
	private static int charToint(char c) {
		if(c>=65 && c<=90) {
			return c-55;
		}
		else return c-48;
	}
	private static int baseFind(String s) {
		int base = 0;
		for(int i = 0;i<s.length();i++) {
			char c = s.charAt(i);
			int val = charToint(c);
			if(val>base)
				base = val;
		}
		return base;
	}
	private static String decToRoman(long n ) {
		String ans = "";		 
		int dec[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000}; 
		String rom[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		int i = 12;
		while(n>0) {
			long div = n/dec[i];
			n = n%dec[i];
			while(div!=0) {
				ans = ans+rom[i];
				div--;
			}
			i--;			
		}
		return ans;
	}
	public static void romanIterate(long num) {
		long value = 0;
		while(value<=399) {
			String ans = decToRoman(num);
			int base = baseFind(ans);
			value = leastValue(ans, base);
			num = value;
		}
		System.out.println(value);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long num = s.nextLong();
		romanIterate(num);	
	}
}

//Example 1
//Input
//1
//Output
//45338950
//Explanation
//The procedure goes as follows in this case:
//1: Accept N = 1.
//2: Since 1 lies in [1,3999], covert it to Roman R = I.
//3: The least value of I (in bases 19 and above) is 18 in base 10. Hence N = 18.
//4, 2': Repeating step 2, since 18 lies in [1,3999], convert it to R = XVIII.
//3': The least value of XVIII (in base 34) is 33*34^4+31*34^3+18*34^2+18*34+18 or N = 45338950.
//4', 2'': Repeating step 2, since 45338950 lies outside [1,3999], output 45338950 and stop.
//Here's how the conversions go: Input = 1 => I => 18 => XVIII => 45338950 = Output.

