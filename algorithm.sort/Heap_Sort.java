import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap_Sort {
	 
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
		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		
		System.out.println("정렬 전");
		System.out.println(Arrays.toString(arr));
		
		heap(arr,arr.length);
		System.out.println("heapify 한번 수행후");
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println("heapify 연속 수행");
		for(int i = arr.length-1 ; i > 0 ; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heap(arr,i);
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println("정렬 후");
		System.out.println(Arrays.toString(arr));
	}
}
