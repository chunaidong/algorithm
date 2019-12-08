package leecode;

/**
 * 
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _206_反转列表 {

	/**
	 * 递归版本稍微复杂一些，其关键在于反向工作。假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？
	 * 
	 * 假设列表为：
	 * n1 -> ... ->n(k-1) -> nk -> n(k+1) -> ... - >Ø 
	 * 若从节点 n_{k+1}n k+1 ​ 到 n_{m}n m ​ 已经被反转，而我们正处于 n_{k}n k ​ 。
	 * 
	 * n1 -> ... ->n(k-1) -> nk -> n(k+1) <- ... <- Ø​
	 * 
	 * 我们希望 n(k+1) ​ 的下一个节点指向 nk​。
	 * 
	 * 所以，n(k).next.next =nk 。
	 * 
	 * 要小心的是 n_{1}n 1 ​ 的下一个必须指向 Ø 。如果你忽略了这一点，你的链表中可能会产生循环。如果使用大小为 2
	 * 的链表测试代码，则可能会捕获此错误
	 * 
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		 //递归
		  if (null == head || head.next == null) { return head; }

		  ListNode newHead = reverseList(head.next);
		System.out.println("[newHead]:" + newHead);
		System.out.println("[head]" + head);
		  head.next.next = head;
		  head.next =  null;

		  return newHead;

	/*	ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;*/

	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(new int[]{1,2,3,4,5,6});
		System.out.println(listNode);
		System.out.println(reverseList(listNode));

	}

}
