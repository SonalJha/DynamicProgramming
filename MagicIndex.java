
public class MagicIndex {
	
	/**
	 * Array is sorted
	 * All elements are distinct
	 * @param A
	 * @param start
	 * @param end
	 * @return
	 */

	
	public static int findMagicIndex(int[] A, int start, int end) {
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		if(A[mid]==mid)
			return mid;
		else if( A[mid]>mid) {
			// search on the left side
			return findMagicIndex(A,start,mid-1);
		}
		
			return findMagicIndex(A,mid+1,end);
	
	}
	
	public static int findMagicIndex(int[] A){
		return findMagicIndex(A,0,A.length-1);
	}
	
	public static void main(String[] args) {
		int[] A = {-40,-20,-1,1,2,3,5,7,9,12,13};
		System.out.println(findMagicIndex(A));
		
	}

}
