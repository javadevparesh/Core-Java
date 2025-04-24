package InterviewQuestions;

public class FibonacciSeries {

	
	public static void main(String[] args) {
		
		generateFibonacci(50);
	}
	
	public static void generateFibonacci(int till) {
		
		int no1=0, no2=1, next=0;
		
		while(no2 <= till) {
			System.out.println(no1 + " ");
			next=no1+no2;
			no1=no2;
			no2=next;
		}
	}
}
