package training;

public class ThirdLargeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {1,2,33,4,5,6};
		int temp,size;
		size = arr.length;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}}
		System.out.println("The third largest array is "+arr[size-3]);
	}

}
