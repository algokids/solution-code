package leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

// ���� ��ũ : https://leetcode.com/problems/kth-largest-element-in-an-array/


public class Q215_KthLargestElementArray {

	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6,7};
		
//		System.out.println(findKthLargest(nums, 4));
//		System.out.println(priorityFindKthLargest(nums, 4));
		System.out.println(arrayFindKthLargest(nums, 4));

	}
	
	
	// 1. Array�� Ǯ�� ==================================================================================================================================
	private static int arrayFindKthLargest(int[] nums, int k) {
		
		Arrays.sort(nums); // ��������
		
		System.out.println(Arrays.toString(nums));
		
		return nums[nums.length-k];
	}
	
	
	// 2. PriorityQueue�� Ǯ�� ==================================================================================================================================
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
	
	
	
	// 3. HeapSort�� Ǯ�� ==================================================================================================================================
	
	// K��°�� ū �Լ��� ���ϴ� �Լ�
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
	
	// �θ� ��� �ε����� ��� �Լ�
	private static int getParent(int child) {
		return (child - 1) / 2;
	}
	
	// �� �ε����� ���Ҹ� ��ȯ�ϴ� �Լ�
	private static void swap(int[] nums, int largestIdx, int parentIdx) {
		int temp = nums[parentIdx];
		nums[parentIdx] = nums[largestIdx];
		nums[largestIdx] = temp;
	}
	
	// Top-Down ����� heapify
	private static void topDownHeapify(int[] nums, int parentIdx, int lastIdx) {
		int largestIdx = parentIdx;
		int leftChildIdx = (parentIdx * 2) + 1;
		int rightChildIdx = (parentIdx * 2) + 2;
		
		// ���� child �˻�
		if(leftChildIdx < lastIdx && nums[largestIdx] < nums[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}
		
		// ������ child �˻�
		if(rightChildIdx < lastIdx && nums[largestIdx] < nums[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}
		
		// largest�� parent swap
		if(largestIdx != parentIdx) {
			swap(nums, largestIdx, parentIdx);
			topDownHeapify(nums, largestIdx, lastIdx);	/* !!!!! ���ȣ�� �߻� !!!!! */
		}
		
	}
	
	//  Bottom-Up����� heapify
	private static void bottomUpHeapify(int[] nums, int parentIdx, int lastIdx) {
		
		while((parentIdx * 2) + 1 < lastIdx) {
			int largestIdx = parentIdx;
			int leftChildIdx = (parentIdx * 2) + 1;
			int rightChildIdx = (parentIdx * 2) + 2;

			// ���� child �˻�
			if(leftChildIdx < lastIdx && nums[largestIdx] < nums[leftChildIdx]) {
				largestIdx = leftChildIdx;
			}
			
			// ������ child �˻�
			if(rightChildIdx < lastIdx && nums[largestIdx] < nums[rightChildIdx]) {
				largestIdx = rightChildIdx;
			}
			
			// largest�� parent swap
			if(largestIdx != parentIdx) {
				swap(nums, largestIdx, parentIdx);
				parentIdx = largestIdx;
			}
			else {
				return;
//				break;
		
			/*
			 * break�� �ش� if���� �����Ű����, 
			 * return�� �ش� �޼ҵ尡 ȣ��� ������ �����Ų��. 
			 * ��, if���� ������ �޼ҵ� ��ü�� �����Ų��.
			 */
			}
			
		}
	}
	
	

}
