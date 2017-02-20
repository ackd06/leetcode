package zsz.develop.two;

/**
 * Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * 给定链表，确定它是否有一个循环。 跟进: 你能不用额外的空间解决它吗？
 * 
 * @author zhangsz
 *
 */
public class LinkedListCycle {

	/**
	 * Definition for singly-linked list. class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; next = null; } }
	 * 
	 * 通过快慢指针实现判断
	 */
	public boolean hasCycleMyOne(ListNode head) {

		ListNode fast = head;
		ListNode show = head;
		while (show!=null) {
			if (fast == null||fast.next ==null||fast.next ==null) {
				return false;
			}
			show = show.next;
			fast = fast.next.next;
			if (show == fast) {
				return true;
			}
			
		}
		
		
		return false;
	}

	
	/**
	 * 这个写得比较优雅一点,整体思路还是一样的
	 * @param head
	 * @return
	 */
	public boolean hasCycleOtherOne(ListNode head) {
	    if(head==null) return false;
	    ListNode walker = head;
	    ListNode runner = head;
	    while(runner.next!=null && runner.next.next!=null) {
	        walker = walker.next;
	        runner = runner.next.next;
	        if(walker==runner) return true;
	    }
	    return false;
	}
}
