package leetcode.queue.q102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}

public class Q102_BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(levelOrder(root));
	}
	
	private static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(list);
		}
		return result;
    }
}
