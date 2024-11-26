package training;

public class OddEvenNumbers {

	public static void printEvenNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void printOddNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	int start = 1;
	        int end = 100;

	        System.out.println("Even Numbers:");
	        printEvenNumbers(start, end);

	        System.out.println("\nOdd Numbers:");
	        printOddNumbers(start, end);
	}
	
	

}
