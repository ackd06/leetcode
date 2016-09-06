package zsz.develop;

import zsz.develop.Solution.TreeNode;

public class MaximumDepthOfBinaryTree {

	
	/**
	 * 题目已经给出了树节点的数据结构
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
	 * 第一次做树结构毫无经验，直接参考别人的代码
	 * 主要思路就是递归求解。
	 * 递归基为: 节点为空。也就是说没有子节点了
	 * 	
	 * 递归：	每次都比较左右节点深度，取最大值。并加上让深度+1
	 * 
	 * @param root
	 * @return
	 */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
    
    
    /**
     * 详细版本
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
