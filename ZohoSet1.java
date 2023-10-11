import java.util.*;
public class ZohoSet1 {

	public static void main(String[] args) {
		PatternX("PROGRAM");
		sumOfWeigths(new int[] {10,36,54,89,12});
		subStringFind("WELcomEToZohOCOrPorATioN","tion");
		fatherChild(new String[][] {{"luke", "shaw"},{"wayne", "rooney"},{"rooney", "ronaldo"},{"shaw", "rooney"}});
	}

	public static void fatherChild(String[][] strings) {
		List<String> father = new ArrayList<String>();
		Scanner sc  = new Scanner(System.in);
		String name = sc.next();
		for(int i=0; i<strings.length; i++) {
			if(name.equalsIgnoreCase(strings[i][1])) {
				father.add(strings[i][0]);
			}
		}
		int count = 0;
		for(String user : father) {
			for(int i=0; i<strings.length; i++) {
				if(user.equalsIgnoreCase(strings[i][1])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void subStringFind(String string,String find) {
		char[][] input = new char[5][5];
		int k =0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(k<string.length()) {
					input[i][j] = string.charAt(k++);
				}else {
					input[i][j] = ' ';
					k++;
				}
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<=5-find.length(); j++) {
				if(Character.toUpperCase(find.charAt(0)) == Character.toUpperCase(input[i][j])) {
					String s = "";
					for(int y=j; y<find.length()+j; y++) {
						s = s + input[i][y];
					}
					if(s.equalsIgnoreCase(find)) {
						System.out.println("<"+i+","+j+">" + " " + "<"+i+","+(j+find.length()-1)+">");
					}
				}
			}
			for(int x=0; x<=5-find.length(); x++) {
				if(Character.toUpperCase(find.charAt(0)) == Character.toUpperCase(input[x][i])) {
					String d = "";
					for(int y=x; y<find.length()+x; y++) {
						d = d + input[y][i];
					}
					if(d.equalsIgnoreCase(find)) {
						System.out.println("<"+x+","+i+">"+" "+"<"+(x+find.length()-1)+","+i+">");
					}
				}
			}
		}
	}

	public static void sumOfWeigths(int[] is) {
		int[] ip = new int[10];
		for(int i=0; i<is.length; i++) {
			int sum = 0;
			for(int j=1; j<is[i]/2; j++) {
				if(j*j == is[i]) {
					sum = 5 + sum;
					break;
				}
			}
			if(is[i]%4 == 0 && is[i]%6 == 0) {
				sum = sum + 4;
			}
			if(is[i]%2 == 0) {
				sum = sum + 3;
			}
			ip[i] = sum;
		}
		for(int k=0; k<is.length; k++) {
			System.out.println(is[k]+","+ip[k]);
		}
	}

	public static void PatternX(String string) {
		for(int i=0; i<string.length(); i++) {
			int k = string.length()-i-1;
			for(int j=0; j<string.length(); j++) {
				if(i==j || j==k) {
					System.out.print(string.charAt(j));
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
