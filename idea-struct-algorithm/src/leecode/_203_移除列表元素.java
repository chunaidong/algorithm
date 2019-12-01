package leecode;

public class _203_移除列表元素 {
	/**
	 * 删除链表中等于给定值 val 的所有节点
	 * @param head
	 * @param val
	 * @return
	 */
//	public ListNode removeElements(ListNode head, int val) {
//		ListNode newHeader = new ListNode(0);
//		newHeader.next = head;
//		ListNode current = newHeader;
//		while (current.next != null) {
//			
//			if(current.next.val ==val) {
//				current.next = current.next.next;
//			}else {
//				current = current.next;
//			}		
//		}		
//		return newHeader.next;
//	}
	
	public ListNode removeElements(ListNode head, int val) {
		if(head == null)
			return null;
		head.next = removeElements(head.next,val);
		return head.val == val ? head.next : head;
	}
	
}
