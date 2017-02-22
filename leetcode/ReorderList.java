package zsz.develop.two;

/**
 * 
 * Reorder List Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * Subscribe to see which companies asked this question.
 * 
 * 
 * 
 * 给定一个单链表L：10→L1→…→LN-1→LN， 重新排列它：10→LN→L1 L2→ln-2→→→LN-1… 您必须在不改变节点值的情况下执行此操作。
 * 例如, { }了1、2、3、4，订货到1,4,2,3 } {。 订阅，看看哪些公司问这个问题。
 * 
 * @author zhangsz
 *
 */
public class ReorderList {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } } 这道题目其实就是调换一下最后一个和第二个的顺序，
	 * 关键点找出最后一个点， 截取出第二个之后的数据，且排除最后一项（关键点不会）
	 * 
	 * 题目理解错误。。。。。。。。。。
	 */
	public ListNode reorderListMyOne(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// ListNode dummy = head;
		// ListNode nnext = dummy.next.next;
		// ListNode cnnext = nnext;
		// while (cnnext.next!=null) {
		// cnnext = cnnext.next;
		// }
		// head.next = cnnext;
		// head.next.next = nnext;

		ListNode show = new ListNode(0);
		ListNode fast = head.next;
		while (fast.next != null) {

			fast = fast.next;

		}
		show.next = null;
		head.next = fast;
		head.next.next = show.next;
		return head;

	}

	
	/**
	 * 分析：先用快慢指针找到链表的中点，然后翻转链表后半部分，再和前半部分组合。
	 * @param head
	 */
	public void reorderListOtherOne(ListNode head) {
		if (head == null || head.next == null)
			return;

		// Find the middle of the list
		// 找到中间的点
		ListNode p1 = head;
		ListNode p2 = head;
		while (p2.next != null && p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}

		// Reverse the half after middle 1->2->3->4->5->6 to 1->2->3->6->5->4
		// 翻转中间节点之后的数据排列
		ListNode preMiddle = p1;
		ListNode preCurrent = p1.next;
		while (preCurrent.next != null) {
			ListNode current = preCurrent.next;
			preCurrent.next = current.next;
			current.next = preMiddle.next;
			preMiddle.next = current;
		}

		// Start reorder one by one 1->2->3->6->5->4 to 1->6->2->5->3->4
		p1 = head;
		p2 = preMiddle.next;
		while (p1 != preMiddle) {
			preMiddle.next = p2.next;
			p2.next = p1.next;
			p1.next = p2;
			p1 = p2.next;
			p2 = preMiddle.next;
		}
	}

	
	/**
	 * 另外一个中写法
	 * 分析：先用快慢指针找到链表的中点，然后翻转链表后半部分，再和前半部分组合。
	 * @param head
	 */
	public void reorderListOtherTwo(ListNode head) {
		if (head == null || head.next == null)
			return;

		// step 1. cut the list to two halves
		// prev will be the tail of 1st half
		// slow will be the head of 2nd half
		ListNode prev = null, slow = head, fast = head, l1 = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. reverse the 2nd half
		ListNode l2 = reverse(slow);

		// step 3. merge the two halves
		merge(l1, l2);
	}

	ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head, next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	void merge(ListNode l1, ListNode l2) {
		while (l1 != null) {
			ListNode n1 = l1.next, n2 = l2.next;
			l1.next = l2;

			if (n1 == null)
				break;

			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
	}

}
