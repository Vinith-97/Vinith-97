import java.util.*;

public class ZohoSet10 {

	public static void main(String[] args) {
		mergeArray(new int[] {1, 2, 3, 6, 9}, new int[] {2, 4, 5, 10});
		wildCard("abcd","ad");
		slidingWindow(new int[] {3,2,7,6,5,1,2,3,4},3);
		countNumber(new int[] {2,1,3,2,2,5,8,9,8});
		wordCount("Jana Gana Mana\r\n"
				+ "Adhinayaka Jay He\r\n"
				+ "Bharata Bhagya Vidhata\r\n"
				+ "Panjab Sindhu Gujarat Maratha\r\n"
				+ "Dravida Utkala Banga\r\n"
				+ "Vindhya Himachal Yamuna Ganga\r\n"
				+ "Uchchala Jaladhi Taranga\r\n"
				+ "Tava Subha Name Jaage\r\n"
				+ "Tave Subha Aashish Mange\r\n"
				+ "Gaahe Tava Jay Gaatha\r\n"
				+ "Jana Gana Mangal Daayak Jay He\r\n"
				+ "Bharat Bhagya Vidhata\r\n"
				+ "Jay he Jay he Jay he\r\n"
				+ "Jay Jay Jay Jay He");
	}

	public static void wordCount(String string) {
		String[] words = string.split("\\s+");
		Set<String> wordcnt = new HashSet<String>();
		for(String i : words)
			wordcnt.add(i);
		
		for(String k : wordcnt) {
			int count = 0;
			for(String m : words) {
				if(k.equalsIgnoreCase(m)) {
					count++;
				}
			}
			System.out.println(k + " : " + count);
		}
	}

	public static void countNumber(int[] is) {
		int[] op = new int[is.length];
		int k=0;
		for(int i=0; i<is.length; i++) {
			int count = 0;
			for(int j=0; j<op.length; j++) {
				if(op[j] == is[i])
					count++;
			}
			if(count == 0)
				op[k++] = is[i];
		}
		for(int x=0; x<op.length; x++) {
			int count =0;
			for(int y=0; y<is.length; y++) {
				if(op[x] == is[y])
					count++;
			}
			System.out.println(op[x] +"-"+ count);
		}
	}

	public static void slidingWindow(int[] is, int k) {
		List<Integer> op = new ArrayList<Integer>();
		for(int i=0; i<=is.length-k; i++) {
			int dummy = 0;
			for(int j=i; j<i+k; j++) {
				if(dummy<is[j]) {
					dummy = is[j];
				}
			}
			op.add(dummy);
		}
		System.out.println(op);
	}

	public static void wildCard(String string, String string2) {
		int i, j=0, flag = 1;
		for(i=0; i<string2.length() && j<string.length() ; j++) {
			System.out.println(string2.charAt(i) + " - " + string.charAt(j));
			if(string2.charAt(i) != '*' && string2.charAt(i)!= string.charAt(j)) {
				flag = 0; break;
			}
			if(i == string2.length()-1 && string2.charAt(i) == '*') {
				flag = 1;
			}
			else if(string2.charAt(i) != '*' || string2.charAt(i+1) == string.charAt(j+1)) {
				i++;
			}
		}
		System.out.println(flag);
	}

	public static void mergeArray(int[] is, int[] is2) {
		int[] ans = new int[is.length+is2.length];
		int k=0;
		int loop = 0;
		if(is.length>is2.length)
			loop = is.length;
		else
			loop = is2.length;
		
		for(int i=0; i<loop; i++) {
			if(i<is.length) {
				int count = 0;
				for(int j=0; j<ans.length; j++) {
					if(ans[j] == is[i])
						count++;
				}
				if(count == 0)
					ans[k++] = is[i];
			}
			if(i<is2.length) {
				int count = 0;
				for(int j=0; j<ans.length; j++) {
					if(ans[j] == is2[i])
						count++;
				}
				if(count == 0)
					ans[k++] = is2[i];
			}	
		}
		System.out.println(Arrays.toString(ans));
	}

}
