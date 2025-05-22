package InterviewQuestions;

public class InterfacesWithSameSignatureMethods implements a,b{
	
	public static void main(String[] args) {
		
	}

	@Override
	public void m1(String str) {
		
		a.super.m1(str);
	}
}

interface a {
	public default void m1(String str) {};
}

interface b {
	public default void m1(String str) {};
}
