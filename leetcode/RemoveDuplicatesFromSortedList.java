package zsz.develop.two;

/**
 * 83. Remove Duplicates from Sorted List
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * 给定排序的链表，删除所有重复，这样每个元素只出现一次。 例如, 给定1 - > 1 - > 2，返回1 - > 2。 给定1 - > 1 - > 2 -
 * > 3 - > 3，返回1 - > 2 - > 3。
 * 
 * 
 * @author zhangsz
 *
 */
public class RemoveDuplicatesFromSortedList {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public ListNode deleteDuplicatesMyOne(ListNode head) {
		if (head == null) {
			return head;
		}
		// ListNode newNode = null;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {// 值是否与下一个节点相同
				if (head.next.next != null) {// 是否存在下下节点
					head.next = head.next.next;
				} else {
					head.next = null;
				}

			} else {// 还有个不相同的情况就应该跳过
					// 这个地方还是绕不过弯来，我应该怎么做才能将这些节点放进新的列表里面呢
				// if (newNode == null) {
				// newNode.val = head.val;
				// }else {
				// newNode.next =
				// }
				head = head.next;
			}
		}
		return head;
	}

	/**
	 * 递归解法
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesOtherOne(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicatesOtherOne(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	
	
	/**
	 * 迭代解法
	奥秘在这： head的复制，防止函数运行完之后head就指向链表末尾了
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;// 十分精妙的一步，不是太能体会其中的奥秘
         
         while(list != null) {
        	 if (list.next == null) {
        		 break;
        	 }
        	 if (list.val == list.next.val) {
        		 list.next = list.next.next;
        	 } else {
        		 list = list.next;
        	 }
         }
         
         return head;
    }
	
//	public ListNode deleteDuplicates(ListNode head) {
//		if (head==null||head.next == null) {
//			return head;
//		}
//		head.next = deleteDuplicates(head.next);
//		return head.val == head.next.val?head.next:head;
//	
//	}
}
