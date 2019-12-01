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
	 }


}
