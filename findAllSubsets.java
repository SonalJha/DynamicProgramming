import java.util.ArrayList;

public class findAllSubsets {

	public static void main(String[] args) {
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.add(1);
		abc.add(2);
		abc.add(3);
		abc.add(4);
		ArrayList<ArrayList<Integer>> result = findAllSubset(abc);
		
		for(int i =0;i<result.size();i++) {
			for(int j=0;j<result.get(i).size();j++) {
				System.out.print(result.get(i).get(j)+ " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Works correctly for duplicates as well
	 * Very simple
	 * 1-1
	 * 1,2 - 1,2,(1,2)
	 * 1,2,3 - add 3 to each in 1,2 and add 3 separately
	 * left is abc, right is result
	 * loop over abc, store in temp
	 * loop over right, create copy of right[i] and add temp to it
	 * add temp separately also
	 * add the copies to result
	 * @param abc
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> findAllSubset(ArrayList<Integer> abc) {
		if(abc==null || abc.size()<=0)
			return null;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i =0;i<abc.size();i++) {
			int temp = abc.get(i);
			// as result array is changing the size should be extracted out
			 int s = result.size();
			 // whatever is there is result, create a copy for each with temp in it
			for(int j=0;j<s;j++) {
				ArrayList<Integer> current = result.get(j);
				ArrayList<Integer> m = create_copy(current);
				m.add(temp);
				result.add(m);
			}
			
			// add temp as single set
			ArrayList<Integer> p = new ArrayList<Integer>();
			p.add(temp);
			result.add(p);
		}	
		result.add(new ArrayList<Integer>());
		//Collections.sort
		return result;
	}
	
	public static ArrayList<Integer> create_copy(ArrayList<Integer> abc) {
		ArrayList<Integer> xyz = new ArrayList<Integer>();
		for(int i =0;i<abc.size();i++) {
			xyz.add(abc.get(i));
		}
		return xyz;
	}

}
