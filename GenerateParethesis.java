import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GenerateParethesis {

	public static void main(String[] args) {
		Set<String> s = generateParen(5);
		for(String abc:s) {
			System.out.println(abc);
		}
	}
	
//	public static ArrayList<String> generateParen(int n) {
//		
//		ArrayList<String> result = new ArrayList();
//		for(String abc:s) {
//			result.add(abc);
//		}
//		return result;
//	}
	
	public static Set<String> generateParen(int n) {
		Set<String> set = new HashSet<String>();
		if(n==0) {
			set.add("");
			return set;
		}
		
		Set<String> prev = generateParen(n-1);
		for(String s: prev) {
			for(int i =0;i<s.length();i++) {
				if(s.charAt(i)=='(') {
					String abc = insert(s,i);
					set.add(abc);
				}
			}
			set.add("()"+s);
		}
		return set;
		
	}

	private static String insert(String s, int i) {
		String part1 = s.substring(0,i+1);
		String part2 = s.substring(i+1,s.length());
		String result = part1+"()" +part2;
		return result;
	}

}
