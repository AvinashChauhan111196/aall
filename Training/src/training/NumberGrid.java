package training;

public class NumberGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 10;
        int cols = 10;
        int count = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(" " +count);
                count++;
            }
            System.out.println();
        }
	}

}
