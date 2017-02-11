package zsz.develop.two;

/**
 * Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed. 给定一个链表，交换每两个相邻节点并返回其头部。 例如,
 * 由于1 - > 2 - > 3 - > 4，您应该返回列表为2 - > 1 - > 4 > 3。
 * 你的算法只能使用常数空间。您不能修改列表中的值，只能更改节点本身。
 * 
 * @author zhangsz
 *
 */
public class SwapNodesInPairs {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 * 没有思路
	 */
	public ListNode swapPairsMyOne(ListNode head) {

		ListNode dummy = head;
		
		return null;
	}

	
	
	/**
	 * 还是不能很好的理解递归啊
	 * @param head
	 * @return
	 */
	public ListNode swapPairsOtherOne(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;// 取出下一个，第三步就将将导致的数据添加到这个节点中
        head.next = swapPairsOtherOne(head.next.next);//将第三个位置的 节点 递归倒叙， 头节点的下一节点 
        n.next = head;
        return n;
    }
	
	
	/**
	 * 循环法
	 * @param head
	 * @return
	 */
	public ListNode swapPairsOtherTwo(ListNode head) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode current = dummy;
	    while (current.next != null && current.next.next != null) {
	    	// 构造出first，second 用于更加方便的取出第一、第二个元素
	        ListNode first = current.next;
	        ListNode second = current.next.next;
	        first.next = second.next;//这一步相当于删除了第二个元素
	        current.next = second;//把第二个元素放入第一个位置
	        current.next.next = first;// 在拼接上删除了第二个节点的first
	        current = current.next.next;// 每次跳过两个节点
	    }
	    return dummy.next;
	}
}
