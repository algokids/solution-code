package leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

// 문제 링크 : https://leetcode.com/problems/kth-largest-element-in-an-array/


public class Q215_KthLargestElementArray {

	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6,7};
		
//		System.out.println(findKthLargest(nums, 4));
//		System.out.println(priorityFindKthLargest(nums, 4));
		System.out.println(arrayFindKthLargest(nums, 4));

	}
	
	
	// 1. Array로 풀기 ==================================================================================================================================
	private static int arrayFindKthLargest(int[] nums, int k) {
		
		Arrays.sort(nums); // 오름차순
		
		System.out.println(Arrays.toString(nums));
		
		return nums[nums.length-k];
	}
	
	
	// 2. PriorityQueue로 풀기 ==================================================================================================================================
	private static int priorityFindKthLargest(int[] nums, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int num:nums) {
			pq.offer(num);
			
			if(pq.size() > k ) {
				pq.poll();
			}
		}
		
		System.out.println(Arrays.toString(nums));
		
		return pq.peek();
	}
	
	
	
	// 3. HeapSort로 풀기 ==================================================================================================================================
	
	// K번째로 큰 함수를 구하는 함수
	private static int findKthLargest(int[] nums, int k) {
        
        int size = nums.length;
        
        int parentIdx = getParent(size - 1);
        
        for(int i = parentIdx; i >= 0; i--) {
        	bottomUpHeapify(nums, i, size);
//        	topDownHeapify(nums, i, size);
        }
        
        for(int i = size - 1; i > 0; i--) {
        	swap(nums, 0, i);
        	bottomUpHeapify(nums, 0, i);
//        	topDownHeapify(nums, 0, i);
        }
        System.out.println(Arrays.toString(nums));
        
        return nums[size - k];
    }
	
	// 부모 노드 인덱스를 얻는 함수
	private static int getParent(int child) {
		return (child - 1) / 2;
	}
	
	// 두 인덱스의 원소를 교환하는 함수
	private static void swap(int[] nums, int largestIdx, int parentIdx) {
		int temp = nums[parentIdx];
		nums[parentIdx] = nums[largestIdx];
		nums[largestIdx] = temp;
	}
	
	// Top-Down 방식의 heapify
	private static void topDownHeapify(int[] nums, int parentIdx, int lastIdx) {
		int largestIdx = parentIdx;
		int leftChildIdx = (parentIdx * 2) + 1;
		int rightChildIdx = (parentIdx * 2) + 2;
		
		// 왼쪽 child 검색
		if(leftChildIdx < lastIdx && nums[largestIdx] < nums[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}
		
		// 오른쪽 child 검색
		if(rightChildIdx < lastIdx && nums[largestIdx] < nums[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}
		
		// largest와 parent swap
		if(largestIdx != parentIdx) {
			swap(nums, largestIdx, parentIdx);
			topDownHeapify(nums, largestIdx, lastIdx);	/* !!!!! 재귀호출 발생 !!!!! */
		}
		
	}
	
	//  Bottom-Up방식의 heapify
	private static void bottomUpHeapify(int[] nums, int parentIdx, int lastIdx) {
		
		while((parentIdx * 2) + 1 < lastIdx) {
			int largestIdx = parentIdx;
			int leftChildIdx = (parentIdx * 2) + 1;
			int rightChildIdx = (parentIdx * 2) + 2;

			// 왼쪽 child 검색
			if(leftChildIdx < lastIdx && nums[largestIdx] < nums[leftChildIdx]) {
				largestIdx = leftChildIdx;
			}
			
			// 오른쪽 child 검색
			if(rightChildIdx < lastIdx && nums[largestIdx] < nums[rightChildIdx]) {
				largestIdx = rightChildIdx;
			}
			
			// largest와 parent swap
			if(largestIdx != parentIdx) {
				swap(nums, largestIdx, parentIdx);
				parentIdx = largestIdx;
			}
			else {
				return;
//				break;
		
			/*
			 * break는 해당 if문만 종료시키지만, 
			 * return은 해당 메소드가 호출된 곳까지 종료시킨다. 
			 * 즉, if문을 포함한 메소드 자체를 종료시킨다.
			 */
			}
			
		}
	}
	
	

}
