package leetcode.linkedlist;

// 문제링크 : https://leetcode.com/problems/add-two-numbers/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
    	this.val = val; 
    	this.next = next; 
    }
}

public class Q2_AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);
		
		ListNode result = addTwoNumbers(l1, l2);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode p1 =l1, p2 =l2 , p3=result;
        int sum = 0;
        
        while(p1 != null || p2 != null) {
        	
        	if(p1 != null) {
        		sum += p1.val;
        		p1 = p1.next;
        	}
        	
        	if(p2 != null) {
        		sum += p2.val;
        		p2 = p2.next;
        	}
        	
        	p3.next = new ListNode(sum % 10);
        	p3 = p3.next;
        	
        	sum /= 10;        	
        }
        if(sum == 1) p3.next = new ListNode(1);
        
        return result.next;
        
    }
	

}
