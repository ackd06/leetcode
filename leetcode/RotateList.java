package zsz.develop.two;

/**
 * Rotate List Given a list, rotate the list to the right by k places, where k
 * is non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * 给定一个列表，将列表旋转到右边k个地方，其中k为非负。 例如: 给定1 - > 2 - > 3 - > 4 - > 5 >空和k = 2， 返回4 - >
 * 5 - > 1 - > 2 - > 3 >空。
 * 
 * @author zhangsz
 *
 */
public class RotateList {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 * 
	 * 解题思路还是错了，这个k，很可能大于链表 所以应该应该先取得链表长度l，然后(l-n%l) 取出要移动的位置
	 * 
	 */
	public ListNode rotateRightMyOne(ListNode head, int k) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode newNode = null;
		ListNode copyHead = head;
		ListNode fakeHead = head;
		// 这个链表不知道自己有多长，但我们能判断说Null 结束
		// 先将列表反向
		while (copyHead != null) {
			ListNode next = copyHead.next;
			newNode.next = newNode;
			newNode = copyHead;
			copyHead = next;
		}

		// 现在遇到一个问题，想取出前k个值取出添加到新列表，然后在将原先的列表添加到新链表
		ListNode listNode = null;
		for (int i = 0; i < k; i++) {
			listNode = newNode;

		}

		return head;
	}

	/**
	 * Since n may be a large number compared to the length of list. So we need
	 * to know the length of linked list.After that, move the list after the
	 * (l-n%l )th node to the front to finish the rotation.
	 * 
	 * Ex: {1,2,3} k=2 Move the list after the 1st node to the front
	 * 
	 * Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the
	 * front.
	 * 
	 * So the code has three parts.
	 * 
	 * Get the length
	 * 
	 * Move to the (l-n%l)th node
	 * 
	 * 3)Do the rotation
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode rotateRightOtherOne(ListNode head, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		int i;
		for (i = 0; fast.next != null; i++)// Get the total length
											// ,循环还可以这么用啊，这样最后一个i 就是所谓的链表长度
			fast = fast.next;

		for (int j = i - n % i; j > 0; j--) // Get the i-n%i th node
			slow = slow.next;

		fast.next = dummy.next; // Do the rotation，到这一部
								// fast.next在第一步后整个值应该是为null，dummy.next
								// 是原先head的值
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}

	public ListNode rotateRightOtherTwo(ListNode head, int k) {

		if (head == null)
			return head;

		ListNode copyHead = head;

		int len = 1;
		while (copyHead.next != null) {
			copyHead = copyHead.next;
			len++;
		}

		copyHead.next = head;

		for (int i = len - k % len; i > 1; i--)
			head = head.next;

		copyHead = head.next;
		head.next = null;

		return copyHead;
	}
}
