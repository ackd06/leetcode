package zsz.develop;

import zsz.develop.Solution.TreeNode;

public class MaximumDepthOfBinaryTree {

	
	/**
	 * ��Ŀ�Ѿ����������ڵ�����ݽṹ
	 * @author zhangsz
	 *
	 */
	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

	
	/**
	 * ��һ�������ṹ���޾��飬ֱ�Ӳο����˵Ĵ���
	 * ��Ҫ˼·���ǵݹ���⡣
	 * �ݹ��Ϊ: �ڵ�Ϊ�ա�Ҳ����˵û���ӽڵ���
	 * 	
	 * �ݹ飺	ÿ�ζ��Ƚ����ҽڵ���ȣ�ȡ���ֵ�������������+1
	 * 
	 * @param root
	 * @return
	 */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
    
    
    /**
     * ��ϸ�汾
     * @param root
     * @return
     */
    public int maxDepthDetail(TreeNode root) {

        if (root == null) return 0;
        int rootDepth = this.maxDepth(root.left);
        int rightDepth = this.maxDepth(root.right);
        int max = Math.max(rootDepth, rightDepth);
        return max + 1;
    }
}
