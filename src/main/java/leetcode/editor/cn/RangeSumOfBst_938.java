//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
//输出：32
// 
//
// 示例 2： 
// 
// 
//输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 2 * 10⁴] 内 
// 1 <= Node.val <= 10⁵ 
// 1 <= low <= high <= 10⁵ 
// 所有 Node.val 互不相同 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 314 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;

/**
 * 二叉搜索树的范围和
 *
 * @author wangsibo
 * @date 2023-02-14 21:49:38
 */
public class RangeSumOfBst_938 {

    private static Solution getSolution() {
        return new RangeSumOfBst_938().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode treeNode = Builder.buildTreeNode(10, 5, 15, 3, 7, null, 18);
        System.out.println("solution.rangeSumBST(treeNode,7,15) = " + solution.rangeSumBST(treeNode, 7, 15));
        TreeNode treeNode1 = Builder.buildTreeNode(10, 5, 15, 3, 7, 13, 18, 1, null, 6);
        System.out.println("solution.rangeSumBST(treeNode1,6,10) = " + solution.rangeSumBST(treeNode1, 6, 10));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int low, high;

        public int rangeSumBST(TreeNode root, int low, int high) {
            this.low = low;
            this.high = high;
            int sum = sum(root);
            return sum;
        }

        private int sum(TreeNode root) {
            if (root == null) return 0;
            if (root.val < low) {
                // 根据二叉搜索树的特性，如果当前节点的值比下边界还要小，那么左子树更小，左子树不用遍历了
                return sum(root.right);
            }
            if (root.val > high) {
                return sum(root.left);
            }
            return root.val + sum(root.left) + sum(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}