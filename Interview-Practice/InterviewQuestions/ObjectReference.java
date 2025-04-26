package InterviewQuestions;

public class ObjectReference {
	
	public static void main(String[] args) {
		
		Integer x = 10;
		
		System.out.println(System.identityHashCode(x));
		System.out.println(x);
		
		x = new Integer(15);
		System.out.println(System.identityHashCode(x));
		System.out.println(x);
		
		
	}
}
