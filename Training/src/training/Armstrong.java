package training;


public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=370,number,rem,total=0;
		
		number = num;
		while(number!=0)
		{
			rem=number%10;
			total=total+rem*rem*rem;
			number = number/10;
			
		}
		
		if(total==num)
		{
			System.out.println("The number is armstrong " +num);
		}
		else
		{
			System.out.println("The number is not armstrong " +num);
		}
	}

}
