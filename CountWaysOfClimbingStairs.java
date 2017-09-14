import java.util.Scanner;

public class CountWaysOfClimbingStairs {
	
	
	/**
	 * Recursive way
	 * at any point of time the stairs are single step way from n-1, n-2 or n-3
	 * O(3^n)
	 * @param n
	 * @return
	 */
	public static int countWays(int n) {
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		return countWays(n-1) + countWays(n-2) +countWays(n-3);
	}
	
	/**
	 * Remember to pass abc as all elements =-1
	 * n=37 will cause integer overflow
	 * @param n
	 * @param abc
	 * @return
	 */
	public static int countWaysDP(int n, int[] abc) {
		if(n<0)
			return 0;
		if(n==0) {
			return 1;
		}
		if(abc[n]>0)
			return abc[n];
		abc[n] = countWaysDP(n-1,abc) + countWaysDP(n-2,abc) + countWaysDP(n-3,abc);
		return abc[n];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		System.out.println(countWays(input));
		int[] abc = new int[input+1];
		System.out.println(countWaysDP(input,abc));
	}

}
