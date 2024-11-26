package training;

public class SwapTwoWithoutThird {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=25;
		int y=20;
		
		System.out.println("The two number before swap are "+x+" and " +y);
		
		x=x+y;
		y=x-y;
		x=x-y;
		
		System.out.println("The two number after swap are "+x+" and " +y);

	}

}
