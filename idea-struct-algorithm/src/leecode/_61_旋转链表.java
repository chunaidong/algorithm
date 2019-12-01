package leecode;

public class _61_旋转链表 {
	
	 public static ListNode rotateRight(ListNode head, int k) {	       
	        ListNode dummpyNode = new ListNode(-1);
	        dummpyNode.next = head;
	        ListNode end = dummpyNode.next;
	        ListNode preEnd = head;
	        for(int i = 0 ; i< k ;i++){
	            while(end.next != null){
	                end = end.next;
	            }
	            while(preEnd != null && preEnd.next != end){
	                preEnd = preEnd.next;
	            }
	            preEnd.next = null;
	            end.next = dummpyNode.next;
	            dummpyNode.next = end;
	            preEnd = dummpyNode.next;
	        }
	        return dummpyNode.next;
	    }
	 
	 public static void main(String[] args) {
		ListNode node = new ListNode(new int[] {1,1,2,3,3,3,4});
		System.out.println(removeSameElement(node));
	 }

	 public static ListNode removeSameElement(ListNode head){
		/* ListNode current = head;
		 while (current != null && current.next != null) {
			 if (current.next.val == current.val) {
				 current.next = current.next.next;
			 } else {
				 current = current.next;
			 }
		 }
		 return head;*/
		if(head == null || head.next == null){
			return head;
		}
		head.next = removeSameElement(head.next);
		return head.val == head.next.val? head.next: head;
	 }
}
