package zsz.develop.two;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author zhangsz
 *
 */
public class RemoveNthNodeFromEndOfList {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 * 
	 * 先来一个笨方法，先将列表倒置，找到倒数第 n 个元素，将他删除，再倒置变为正确的
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode newHead = null;
		while (head!= null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		
		for(int i = 0;i<n;i++){
			
		}
		return null;
	}
	
	/**
	 * 想到一个先计算出 链表长度
	 * 再删除 l-n 的那个节点
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEndMytwo(ListNode head, int n) {
		if (head==null) {
			return head;
		}
		ListNode dummy = head;
		ListNode copy = head;
		
		int i;// 这一步就取出了
		for(i = 0;copy!=null;i++){
			copy = copy.next;
		}
		int x = i -n;
		for (int j = 0; j < x; j++) {
			dummy = dummy.next;
		}
		
		dummy.next = dummy.next.next;
		
		
	return head;
	}
	
	
	/**
	 * 这又是一个伟大的方案啊
	 * 
	 * 构建出两个与传入的节点相同的节点。但是这两个节点需要操作会进行移动，
	 * start 防止函数运行完，指针指向函数末尾了
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEndOtherOne(ListNode head, int n) {
		//还是走的快的点(fastNode)与走得慢的点(slowNode)路程差的问题
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;//这个添加进入后，其实同时也执行了   fast.next = head，因为他们都是基于start进行操作的
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    //在前面快速移动，以便慢速和快速之间的间隙变为N。
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    //快速移动到最后，保持差距
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    //跳过所需节点
	    slow.next = slow.next.next;
	    return start.next;
	}

}
