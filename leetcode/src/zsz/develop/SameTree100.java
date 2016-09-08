package zsz.develop;
/**
 * 		Same Tree
		Given two binary trees, write a function to check if they are equal or not.
		
		Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
		
		Subscribe to see which companies asked this question
		
		同一棵树
		给定两个二叉树，写一个函数来检查它们是否是相等的。
		两个二元树被认为是相等的，如果它们在结构上是相同的，和节点具有相同的值。
 * @author zhangsz
 *
 */
public class SameTree100 {

	/**
	 * 感觉树都是用递归求解的
	 * 递归基：两个节点都为空得时候，返回true 两个节点相等
	 * 		其中一个节点是为空，返回false 两个节点不相等
	 * 两个节点值相等的时候，继续递归判断他们的左右节点是否各个相等
	 * 若出现不相等的将终止循环
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTreeMyOne(TreeNode p, TreeNode q) {
		if (p == null&&q == null) {
			return true;
		}
		if (p==null && q!=null) {//这一步判断差点就忘记了。其中一个有值，另外一个没值得情况。也是错的
			return false;
		}
		if (p!=null && q==null) {
			return false;
		}
		if (p.val == q.val) {
			if (isSameTreeMyOne(p.left, q.left)&&isSameTreeMyOne(p.right, q.right)) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
		
	}
	
	/**
	 * 总体思路和我的一样，不过这个代码写得更优雅一点
	 * @param p
	 * @param q
	 * @return
	 */
	  public boolean isSameTreeOtherTwo(TreeNode p, TreeNode q) {
			if (p == null && q == null)
				return true;
			else if (p != null && q == null || p == null && q != null || p.val != q.val) {
				return false;
			}
			return isSameTreeOtherTwo(p.left, q.left) && 
					isSameTreeOtherTwo(p.right, q.right);        
	    }


		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int x) {
				val = x;
			}
		}
}
