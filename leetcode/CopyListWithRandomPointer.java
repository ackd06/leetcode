package zsz.develop.two;

/**
 * Copy List with Random Pointer A linked list is given such that each node
 * contains an additional random pointer which could point to any node in the
 * list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * deep copy 和shallow copy 都是用于对象之间的拷贝，如果对象没有其他对象的引用时， deep copy和shallow
 * copy是一样的，但是如果有，如果只是用swallow copy， 拷贝副本当中的对象引用和原来的对象是指向同一个对象的，即一块内存区域，
 * 因此，原对象和副本只要有一个当中的对象引用改变，另一个也被改变了。 但是有时候我们不想这种情况发生，因此我们需要在拷贝时把引用对象一并拷贝，
 * 也就是说副本和原本是独立的，而这就是deep copy。
 * 
 * @author zhangsz
 *
 */
public class CopyListWithRandomPointer {

	/**
	 * An intuitive solution is to keep a hash table for each node in the list,
	 * via which we just need to iterate the list in 2 rounds respectively to
	 * create nodes and assign the values for their random pointers. As a
	 * result, the space complexity of this solution is O(N), although with a
	 * linear time complexity.
	 * 
	 * As an optimised solution, we could reduce the space complexity into
	 * constant. The idea is to associate the original node with its copy node
	 * in a single linked list. In this way, we don't need extra space to keep
	 * track of the new nodes.
	 * 
	 * The algorithm is composed of the follow three steps which are also 3
	 * iteration rounds.
	 * 
	 * 1.Iterate the original list and duplicate each node. The duplicate of
	 * each node follows its original immediately. 
	 * 
	 * 2. Iterate the new list and
	 * assign the random pointer for each duplicated node. 
	 * 
	 * 3. Restore the
	 * original list and extract the duplicated nodes. The algorithm is
	 * implemented as follows:
	 * 
	 * 一个直观的解决方案是为列表中的每个节点保持一个哈希表，通过它我们只需要遍历列表在2轮分别创建节点和指定值的随机指针。
	 * 其结果是，该解决方案的空间复杂度为O（n），虽然具有线性时间复杂度。
		作为一个优化的解决方案，我们可以减少空间复杂度为常数。我们的想法是将原始节点与它的复制节点关联在一个单链表中。这样，我们不需要额外的空间来跟踪新节点。
		该算法是由以下三个步骤，也有3个迭代轮。
		迭代原始列表和重复的每个节点。重复
		每个节点都遵循它的原始立即。
		迭代新列表和每个分配的指针
		复制节点。
		恢复原始列表并提取重复节点。
		该算法的实现如下：
	 * 
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomListOtherOne(RandomListNode head) {
		RandomListNode iter = head, next;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;

			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;

			iter = next;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		RandomListNode pseudoHead = new RandomListNode(0);
		RandomListNode copy, copyIter = pseudoHead;

		while (iter != null) {
			next = iter.next.next;

			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;

			// restore the original list
			iter.next = next;

			iter = next;
		}

		return pseudoHead.next;
	}
}
