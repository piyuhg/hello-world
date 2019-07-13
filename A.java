import java.util.Scanner;
public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();	//number of holes
		long h[] = new long[n];	//diameter of holes
		for(int i = 0;i<n;i++)
			h[i] = s.nextLong(); 
		int m = s.nextInt();	//number of balls
		long b[] = new long[m];	//diameter of balls
		for(int i = 0;i<m;i++)
			b[i] = s.nextLong();
		int full[] = new int[n];	//hole status
		for(int i = 0;i<m;i++) {
			boolean ballNotSet = true;
			for(int j = n-1;j>=0;j--) {
				if(b[i] <= h[j]) {
					if(full[j]<(j+1)) {
						System.out.print(j+1+" ");
						full[j]++;
						ballNotSet = false;
						break;
					}
				}
			}
			if(ballNotSet)
				System.out.print("0 ");
		}
	}
}
/*
 *Constraints
0 < N <= 50

0 < Diameter of holes <= 10^9

0 < M <= 1000

0 < Diameter of balls <=10^9

Input Format
Line 1: total number of holes, N 
Line 2: N space separated integers denoting the diameters of N holes, from bottom to top 
Line 3: total number of balls, M 
Line 4: M space separated integers denoting the diameters of balls in the order of release.

Output
Line 1: Positions of each ball in the order of ball release separated by space

Test Case

Explanation
Example 1

Input

3
21 3 6
11
20 15 5 7 10 4 2 1 3 6 8

Output

1 0 3 0 0 3 3 2 2 0 0

Explanation

3 holes are there labelled H1, H2, and H3 of diameters 21, 3, and 6 respectively. 11 balls are released from the point B in the order provided in the input i.e. { 20, 15, 5, 7 ..., 5}. Ball of diameter 20 will fall into the hole H1 and the hole H1 will become full. Balls 15, 7 and 10 will reach bottom since hole H1 is full and diameters of holes H2 and H3 are less than balls diameter. Balls 5, 4 , and 2 will fall into the hole H3. Ball 1 will fall into the hole H2 since the hole H3 is already full. Ball 3 will fall into hole H2. Balls 6, and 8 will reach at the bottom point E. The position of ball 20 is 1 because it is in hole H1. Positions of ball 15, 7, 10, 3, 6, and 8 are 0 because they reached bottom point E. Positions of 5, 4, and 2 are 3 because they are in hole H3. Position of Ball 1 and Ball 3 is 2. 
 */
