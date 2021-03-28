package leetcode.array;

import java.util.Arrays;
import java.util.Stack;

// 문제 링크 : https://leetcode.com/problems/trapping-rain-water/

public class Q42_TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));

	}
	 private static int trap(int[] height) {
	     int result = 0;
	     int last = height.length;
	     
	     
	     // 왼쪽 벽의 높이 구하기
	     int[] left = new int[last];
	     int max = 0;
	     left[0] = 0;
	     
	     for(int i = 1; i < last; i++) {
	    	 
	    	 if(height[i-1] > max) {
	    		 max = height[i-1];
	    	 } 
	    	 
	    	 left[i] = max; 
	    	
	     }
	     
	    
	     // 오른쪽 벽의 높이 구하기
	     int[] right = new int[last];
	     
	     right[last-1] = 0;
	     max = 0;
	     
	     for(int i = last-2; i >= 0; i--) {
	    	 
	    	 if(height[i+1] > max) {
	    		 max = height[i+1];
	    	 }
	    	 
	    	 right[i] = max;
	     }
	     
	     
	     // 양 옆의 최소 높이 구하기
	     int[] minHeight = new int[last];
	     
	     for(int i = 0; i < last; i++) {
	    	 minHeight[i] = Math.min(left[i], right[i]);
	     }
	     
	     // 본인 자체 높이 빼기
	     for(int i = 0; i < last; i++) {
	    	 
	    	 int water = minHeight[i] - height[i];
	    	 
	    	 if(water > 0) {
	    		 result += water;
	    	 }
	    	 
	     }
	     
	     
	     return result;
		 
	 }
	

}
