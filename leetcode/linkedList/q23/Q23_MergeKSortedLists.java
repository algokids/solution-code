package leetcode.linkedList.q23;

// 문제 링크 : https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.linkedList.ListNode;

public class Q23_MergeKSortedLists {
	

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(5);
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		
		ListNode node3 = new ListNode(2);
		node3.next = new ListNode(6);
		
		ListNode[] lists = new ListNode[3];
		lists[0] = node1;
		lists[1] = node2;
		lists[2] = node3;
		
		Q23_MergeKSortedLists ms = new Q23_MergeKSortedLists();
		ListNode result = ms.mergeKLists(lists);
		
		while(result.next != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
    private ListNode mergeKLists(ListNode[] lists) {
        
    	// 오름차순 우선순위 큐
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comp);
    	
    	// 반환할 결과 ListNode
    	ListNode result = new ListNode(0);
    	ListNode start = result; // result의 시작 노드
    	
    	// PriorityQueue에 담기
    	for(ListNode node : lists) {
    		if(node != null) {
    			queue.offer(node);
    		}
    	}
    	
    	// PriorityQueue에서 꺼내서 result에 담기
    	/*
    	 * 꺼낼때 정렬되어서 나온다.
    	 */
    	while(!queue.isEmpty()) {
    		
    		ListNode node = queue.poll(); 
    		start.next = node;
    		start = start.next;
    		
    		if(node.next != null) {
    			queue.offer(start.next);
    		}
    	}

    	return result.next;
    	
    }
    
    Comparator<ListNode> Comp = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val; // 오름차순
		}
	};
    
}
