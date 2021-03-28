package leetcode.array;

// 문제 링크 : https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.List;

public class Q54_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		
		int colStart = 0;
		int colEnd = matrix[0].length - 1;
		
		while(rowStart <= rowEnd && colStart <= colEnd) {
			// right
			for(int i = colStart; i <= colEnd;i++ ) {
				result.add(matrix[rowStart][i]);
			}
			rowStart++;
			
			// down
			for(int i = rowStart; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			// left
			if(rowStart <= rowEnd) {
				for(int i = colEnd; i >= colStart; i--) {
					result.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}
			
			// up
			if(colStart <= colEnd) {
				for(int i = rowEnd; i >= rowStart; i--) {
					result.add(matrix[i][colStart]);
				}
				colStart++;
			}
		}
		return result;
        
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,	2,	3},
						  {4,	5,	6},
						  {7,	8,	9},
						  {10,	11,	12}};
		
		
		Q54_SpiralMatrix a = new Q54_SpiralMatrix();
		List<Integer> result = a.spiralOrder(matrix);
		
		System.out.println(result);
	}

}
