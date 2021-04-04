import java.util.Arrays;
import java.util.Scanner;

public class HeapSort_2220 {
	static int count=0;
	public static void heap(int[] data,int number) {
		for(int i=1; i<number;i++) {
			int child = i;
			while(child > 0) {
				int parent = (child-1)/2;
				if(data[child] > data[parent]) {
					//swap
					int temp = data[parent];
					data[parent] = data[child];
					data[child] = temp;
				}
				child = parent;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,5,3,2,4,1};
		//20, 19, 15, 18, 10, 12, 14, 11, 17, 4, 9, 3, 7, 6, 13, 2, 8, 5, 16, 1
		//20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1
		//20, 19, 15, 18, 10, 12, 14, 11, 17, 4, 9, 3, 7, 6, 13, 2, 8, 5, 16, 1
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int arr2[] = new int[number];
		
		arr2[0]=1;
		for(int i=2;i<=number;i++)
		{
			arr2[i-1] = i;
			
			int temp = arr2[i-1];
			arr2[i-1] = arr2[i-2];
			arr2[i-2] = temp;
		
			heap(arr2,i);
			System.out.println(Arrays.toString(arr2));
		}
	}
}
