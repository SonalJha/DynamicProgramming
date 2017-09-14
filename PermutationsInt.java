import java.util.ArrayList;

public class PermutationsInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.add(1);
		abc.add(2);
		abc.add(3);
		ArrayList<ArrayList<Integer>> result = getPerms(abc);
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++) {
			System.out.print(result.get(i).get(j) +" ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> getPerms(ArrayList<Integer> input) {
		if(input ==null)
			return null;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(input.size()==0) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			result.add(temp);
			return result;
		}
		
		int start = input.get(0);
		//input.remove(0);
		ArrayList<Integer> remaining = input;
		remaining.remove(0);
		ArrayList<ArrayList<Integer>> num = getPerms(remaining);
		
		for(int i =0;i<num.size();i++) {
			// see the = here
			for(int j=0; j<=num.get(i).size();j++) {
				ArrayList<Integer> abc = get_Number(num.get(i),start,j);
				result.add(abc);
			}
		}
				
		
		return result;
	}

	private static ArrayList<Integer> get_Number(ArrayList<Integer> abc, int start, int j) {
		boolean flag = false;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(abc.size()==0) {
			result.add(start);
			return result;
		}
		// see the = here
		for(int i =0;i<=abc.size();i++) {
			if(i==j && flag==false){
				result.add(start);
				flag = true;
				//i=i-1;
			}
			else {
				if(flag)
				result.add(abc.get(i-1));
				else 
					result.add(abc.get(i));
			}
		}
		return result;
	}

}
