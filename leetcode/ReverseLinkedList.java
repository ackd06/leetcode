package zsz.develop.two;

/**
 * 反向单链表。
 * @author zhangsz
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode listNode = new ListNode(5);
		listNode.next = new ListNode(6);
		listNode.next.next = new ListNode(7);
		reverseListMyOne(listNode);
	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 * 又没有做对。。。。。
	 */
	public static ListNode reverseListMyOne(ListNode head) {

		if (head.next != null) {
			reverseListMyOne(head.next);
		}
		ListNode listNode = new ListNode(head.val);
		return head == null?head:reverseListMyOne(head.next);
	}

	
	/**
	 * 循环法
	 * 不断地对换位置来做判断
	 * @param head
	 * @return
	 */
	public ListNode reverseListOtherOne(ListNode head) {
	    /* iterative solution */
	    ListNode newHead = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;
	    }
	    return newHead;
	}

	
	/**
	 * 递归法
	 * @param head
	 * @return
	 */
	public ListNode reverseListOtherTwo(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	
	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
	
	/**
	 * 也是采用递归，这里更清楚一点
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
}
