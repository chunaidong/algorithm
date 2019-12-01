package leecode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。  *
 *     示例： *
 *     输入：1->2->4, 1->3->4
 *     输出：1->1->2->3->4->4
 *     https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class _21_合并两个有序链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1,2,4});
        ListNode l2 = new ListNode(new int[]{1,3,4});
        System.out.println(mergeTwoLists(l1,l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       /* ListNode head=new ListNode(0);
        ListNode node=head;
        ListNode curr=null;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr=new ListNode(l1.val);
                l1=l1.next;
            }else{
                curr=new ListNode(l2.val);
                l2=l2.next;
            }
            node.next=curr;
            node=node.next;
        }
        while(l1!=null){
            node.next=new ListNode(l1.val);
            l1=l1.next;
            node=node.next;
        }
        while(l2!=null){
            node.next=new ListNode(l2.val);
            l2=l2.next;
            node=node.next;
        }
        return head.next;*/
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
