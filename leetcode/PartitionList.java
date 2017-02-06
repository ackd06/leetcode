package zsz.develop.two;

/**
 * Partition List
 * 
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * 
 * 		给定一个链表和一个x值，将其划分为小于x的所有节点在大于或等于x的节点之前。
		您应该保存两个分区中每个节点的原始相对顺序。
		例如,
		给定1 - > 4 - > 3 - > 2 - > 5 > 2和x = 3，
		返回1 - > 2 - > 2 - > 4 - > 3 - > 5。
 * @author zhangsz
 *
 */
public class PartitionList {

	public static void main(String[] args) {

	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 * 
	 * 题目返回，返回1 - > 2 - > 2 - > 4 - > 3 - > 5。 这个应该就没有再判断相等了
	 */
	public ListNode partitionMyOne(ListNode head, int x) {

		ListNode lessNode = null;
		ListNode moreNode = null;
		ListNode equalsNode = null;
		while(head!=null){
			if (head.val < x) {
				ListNode node = lessNode;
				lessNode.val = head.val;
				lessNode.next = node;		
			}else if (head.val == x) {
				ListNode node = equalsNode;
				equalsNode.val = head.val;
				equalsNode.next = node;
			}else {
				ListNode node = moreNode;
				moreNode.val = head.val;
				moreNode.next = node;
			}
			head = head.next;
		}
		
		// 拼装三个链表，采用这种方法拼接就出先问他，看其他人的
		while (lessNode.next == null) {
			
			
		}
		
		return null;
	}
	
	
	/**
	 * 其基本思想是保持两个队列，第一个商店的所有节点的值小于X，和第二队列存储的所有其他节点。然后连接这两个队列。记得设置第二队列空下的尾巴，或者你会得到的。
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partitionOtherOne(ListNode head, int x) {
	    ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
	    ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
	    while (head!=null){
	        if (head.val<x) {
	            curr1.next = head;
	            curr1 = head;
	        }else {
	            curr2.next = head;
	            curr2 = head;
	        }
	        head = head.next;
	    }
	    curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
	    curr1.next = dummy2.next;
	    return dummy1.next;
	}

}
