package zsz.develop.two;

/**
 * Remove Duplicates from Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * 给定一个已排序的链表，删除所有具有重复编号的节点，只留下与原始列表不同的数字。 例如, 给定1 - > 2 - > 3 - > 3 - > 4 - > 4
 * - > 5，返回1 - > 2。 给定1 - > 1 - > 1 - > 2 - > 3，返回2 - > 3。
 * 
 * @author zhangsz
 *
 */
public class RemoveDuplicatesFromSortedListII {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	/**
	 * 参考之前的解法，这个应该也是有两种解法 一个递归，一种迭代 递归 递归的递归基是什么？ 递归的循环终止条件是什么？
	 * 又错了，慢慢刷
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesMyone(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nextHead = deleteDuplicatesMyone(head.next);
		return null;
//		return head.val == head.next.val? head;
	}

	
	/**
	 * 尝试第二种方法失败
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesMyTwo(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		while (head!=null) {
			if (head.next == null) {
				break;
			}
			
			if (head.val == head.next.val) {
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
		
		return head;
	}

	
	/**
	 * 这个解法有点意思，他相当于把昨天做了两遍
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesOtherOne(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);// 这一步是让他们多加一个，重构一个
        FakeHead.next=head;
        ListNode pre=FakeHead;
        //给个head的复制，防止函数运行完之后head就指向链表末尾了
        ListNode cur=head;// 这一步也用到了昨天的方法
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
	
	
	/**
	 * 递归法
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesOtherTwo(ListNode head) {
	    if (head == null) return null;
	    
	    if (head.next != null && head.val == head.next.val) {
	        while (head.next != null && head.val == head.next.val) {
	            head = head.next;
	        }
	        return deleteDuplicatesOtherTwo(head.next);
	    } else {
	        head.next = deleteDuplicatesOtherTwo(head.next);
	    }
	    return head;
	}
}
