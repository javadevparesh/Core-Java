package InterviewQuestions;

public class ReverseString {
	
	public static String reverseString(String str) {
		
		String reversed="";
		for(int i=0; i<str.length(); i++) {
			reversed = str.charAt(i) + reversed;
		}
		return reversed;
	}
	
	public static void main(String[] args) {
		
		System.out.println(reverseString("This is sample string"));
	}
}
