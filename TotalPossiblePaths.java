import java.util.ArrayList;
import java.util.Scanner;

public class TotalPossiblePaths {
	
	// what are the possible ways of reaching x,y from 0,0 if only right and down are allowed

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		System.out.println(possiblePaths(x,y));
		System.out.println(possiblePathsDP(x,y));
		ArrayList<Points> path = new ArrayList<Points>();
		getPath(x,y,path);
		for(int i=0;i<path.size();i++)
		System.out.println(path.get(i).x+" , "+path.get(i).y);

	}
	
	/**
	 * Recursive solution
	 * @param x
	 * @param y
	 * @return
	 */
	public static int possiblePaths(int x, int y) {
		if(x<0 || y<0)
			return 0;
		if(x==0 && y==0)
			return 1;
		return possiblePaths(x-1,y) + possiblePaths(x,y-1);
	}
	
	/**
	 * DP solution
	 * @param x
	 * @param y
	 * @param map
	 * @return
	 */
	public static int possiblePathsDP(int x, int y, int[][] map) {
		if(x<0 || y<0)
			return 0;
		if(x==0 && y==0)
			return 1;
		if(map[x][y]>0)
			return map[x][y];
		map[x][y] = possiblePathsDP(x-1,y,map) + possiblePathsDP(x,y-1,map);
		return map[x][y];
	}
	
	/**
	 * Method overloading
	 * put size one bigger when constructing map
	 * @param x
	 * @param y
	 * @return
	 */
	public static int possiblePathsDP(int x,int y) {
		int[][] map = new int[x+1][y+1];
		return possiblePathsDP(x,y,map);
	}
	
	public static boolean getPath(int x, int y, ArrayList<Points> path) {
		Points p = new Points(x,y);
		if(x==0&& y==0)
			return true;
		boolean success = false;
		if(x>0 && if_free(x-1,y)) {
			success = getPath(x-1,y,path);
		}
		if(!success && y>0 && if_free(x,y-1)) {
			success = getPath(x,y-1,path);
		}
		if(success) {
			path.add(p);
		}
		return success;
		
	}

	private static boolean if_free(int x, int y) {
		// TODO Auto-generated method stub
		// if(x,y) are not off-limits return true
		return true;
	}

}
