package zsz.develop.two;

/**
 * 142. Linked List Cycle II
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * Subscribe to see which companies asked this question.
 * 
 * 给定一个LINKED LIST，返回的节点在循环开始。如果有不周，返回null。 注：没有修改的免疫策略。 随访： 你可以练习，它没有使用额外的空间？
 * 看到这两个订阅公司问这个问题。
 * 
 * 如何找到环中第一个节点（即Linked List Cycle II）？
 * @author zhangsz
 *
 */
public class LinkedListCycleII {

	/**
	 * Definition for singly-linked list. class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; next = null; } }
	 * 
	 */
	public ListNode detectCycleMyOne(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;
		ListNode show = head;
		while(fast.next !=null && fast.next.next != null){
			show = show.next;
			fast = fast.next.next;
			if (show == fast) {
				return show;//这里返回的show并不一定是第一个交点，交点可能有很多个
			}
		}

		return null;
	}
	
	/**
	 * 记住相交的点并不止一个，第一次他们相交的时候，可能不是第一个相交的点。
	 * 所以从头开始走
	 * @param head
	 * @return
	 */
	   public ListNode detectCycleOtherOne(ListNode head) {
           ListNode slow = head;
           ListNode fast = head;
   
           while (fast!=null && fast.next!=null){
               fast = fast.next.next;
               slow = slow.next;
               
               if (fast == slow){//让他从头再循环一次，找到第一个相交的节点
                   ListNode slow2 = head; 
                   while (slow2 != slow){
                       slow = slow.next;
                       slow2 = slow2.next;
                   }
                   return slow;
               }
           }
           return null;
       }

}
