import java.util.ArrayList;

public class PermutationsString {

	public static void main(String[] args) {
		ArrayList<String> abc = getPerms("abc");
		for(int i=0;i<abc.size();i++){
			System.out.println(abc.get(i));
		}

	}
	
	public static ArrayList<String> getPerms(String str) {
		if(str==null)
			return null;
		ArrayList<String> result = new ArrayList<String>();
		
		if(str.length()==0)
		{
			result.add("");
			return result;
		}
		
		char first = str.charAt(0);
		String remaining = str.substring(1);
		ArrayList<String> words = getPerms(remaining);
		for(int i =0;i<words.size();i++) {
			// pay attention here the loop is = the lemgth of the word
			for(int j=0;j<=words.get(i).length();j++) {
				String s = getString(words.get(i),first,j);
				result.add(s);
			}
		}
		
		return result;
	}

	private static String getString(String words, char c, int j) {
		String part1 = words.substring(0,j);
		String part2 = words.substring(j);
		String str = part1+c+part2;
		return str;
	}

}
