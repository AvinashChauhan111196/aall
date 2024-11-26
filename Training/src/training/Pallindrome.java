package training;

public class Pallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num =121,reverseNum=0,remainder;
		int originalNum = num;
		
		while(num>0)
		{
			remainder=num%10;
			reverseNum=(reverseNum*10)+remainder;
			num=num/10;
			
		}
		
		if(originalNum==reverseNum)
		{
			System.out.println("The number is pallindrome");
		}
		else
			System.out.println("The number is not pallindrome");
		
		

	}

}
