//给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。 
//
// 二叉搜索树的定义如下： 
//
// 
// 任意节点的左子树中的键值都 小于 此节点的键值。 
// 任意节点的右子树中的键值都 大于 此节点的键值。 
// 任意节点的左子树和右子树都是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//输出：20
//解释：键值为 3 的子树是和最大的二叉搜索树。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [4,3,null,1,2]
//输出：2
//解释：键值为 2 的单节点子树是和最大的二叉搜索树。
// 
//
// 示例 3： 
//
// 
//输入：root = [-4,-2,-5]
//输出：0
//解释：所有节点键值都为负数，和最大的二叉搜索树为空。
// 
//
// 示例 4： 
//
// 
//输入：root = [2,1,3]
//输出：6
// 
//
// 示例 5： 
//
// 
//输入：root = [5,4,8,3,null,6,3]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 每棵树有 1 到 40000 个节点。 
// 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 👍 105 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

/**
 * 二叉搜索子树的最大键值和
 *
 * @author wangsibo
 * @date 2022-08-30 21:40:38
 */
public class MaximumSumBstInBinaryTree_1373 {

    private static Solution getSolution() {
        return new MaximumSumBstInBinaryTree_1373().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode treeNode = Builder.buildTreeNode(1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6);
        TreeNode treeNode1 = Builder.buildTreeNode(4, 3, null, 1, 2);
        TreeNode treeNode2 = Builder.buildTreeNode(-4, -2, -5);
        TreeNode treeNode3 = Builder.buildTreeNode(2, 1, 3);
        TreeNode treeNode4 = Builder.buildTreeNode(5, 4, 8, 3, null, 6, 3);
        int i = solution.maxSumBST(treeNode);
        Console.log(i);
        i = solution.maxSumBST(treeNode1);
        Console.log(i);
        i = solution.maxSumBST(treeNode2);
        Console.log(i);
        i = solution.maxSumBST(treeNode3);
        Console.log(i);
        i = solution.maxSumBST(treeNode4);
        Console.log(i);

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
        private int max = 0;

        public int maxSumBST(TreeNode root) {
            // 判定它是二叉搜索子树
            // 判断最大
            postTraverse(root);
            int res = this.max;
            this.max = Integer.MIN_VALUE;
            return res;
        }

        private int postTraverse(TreeNode treeNode) {
            if (treeNode != null) {
                int left = 0, right = 0;
                if (treeNode.left != null) left = treeNode.left.val;
                if (treeNode.right != null) right = treeNode.right.val;
                int leftSum = postTraverse(treeNode.left);
                int rightSum = postTraverse(treeNode.right);
                if (left < treeNode.val && treeNode.val < right) {
                    int count = treeNode.val + leftSum + rightSum;
                    if (count > max) {
                        max = count;
                    }
                    return max;
                }
                if (treeNode.left == null && treeNode.right == null && treeNode.val > max) max = treeNode.val;
                if (treeNode.val > 0){

                }
                return treeNode.val;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}