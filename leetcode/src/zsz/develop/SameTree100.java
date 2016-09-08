package zsz.develop;
/**
 * 		Same Tree
		Given two binary trees, write a function to check if they are equal or not.
		
		Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
		
		Subscribe to see which companies asked this question
		
		ͬһ����
		����������������дһ����������������Ƿ�����ȵġ�
		������Ԫ������Ϊ����ȵģ���������ڽṹ������ͬ�ģ��ͽڵ������ͬ��ֵ��
 * @author zhangsz
 *
 */
public class SameTree100 {

	/**
	 * �о��������õݹ�����
	 * �ݹ���������ڵ㶼Ϊ�յ�ʱ�򣬷���true �����ڵ����
	 * 		����һ���ڵ���Ϊ�գ�����false �����ڵ㲻���
	 * �����ڵ�ֵ��ȵ�ʱ�򣬼����ݹ��ж����ǵ����ҽڵ��Ƿ�������
	 * �����ֲ���ȵĽ���ֹѭ��
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTreeMyOne(TreeNode p, TreeNode q) {
		if (p == null&&q == null) {
			return true;
		}
		if (p==null && q!=null) {//��һ���жϲ��������ˡ�����һ����ֵ������һ��ûֵ�������Ҳ�Ǵ��
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
	 * ����˼·���ҵ�һ���������������д�ø�����һ��
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
