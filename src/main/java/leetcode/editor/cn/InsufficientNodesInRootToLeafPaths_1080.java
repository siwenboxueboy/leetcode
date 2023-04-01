//给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点） 
//
// 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。 
//
// 请你删除所有不足节点，并返回生成的二叉树的根。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
//
//输出：[1,2,3,4,null,null,7,8,9,null,14]
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
//
//输出：[5,4,8,11,null,17,4,7,null,null,null,5] 
//
// 示例 3： 
//
// 
//输入：root = [5,-6,-6], limit = 0
//输出：[] 
//
// 
//
// 提示： 
//
// 
// 给定的树有 1 到 5000 个节点 
// -10^5 <= node.val <= 10^5 
// -10^9 <= limit <= 10^9 
// 
//
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 79, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

/**
 * 根到叶路径上的不足节点
 *
 * @author wangsibo
 * @date 2023-04-01 12:02:26
 */
public class InsufficientNodesInRootToLeafPaths_1080 {

    private static Solution getSolution() {
        return new InsufficientNodesInRootToLeafPaths_1080().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();

        TreeNode treeNode = Builder.buildTreeNode(5, -6, -6);
        TreeNode treeNode1 = solution.sufficientSubset(treeNode, 0);
        Console.log(treeNode1);

        TreeNode treeNode2 = solution.sufficientSubset(Builder.buildTreeNode(1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12, 13, -99, 14), 1);
        Console.log(treeNode2);
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

        private int limit;

        public TreeNode sufficientSubset(TreeNode root, int limit) {
            this.limit = limit;
            if (root == null) {
                return root;
            }
            boolean rootDeleted = traverse(root, 0);
            if (rootDeleted) {
                return null;
            }
            return root;
        }

        private boolean traverse(TreeNode root, int currentSum) {
            // 若为单个节点时，有个空节点，进入了这里，这里默认要返回true
            if (root == null) {
                return true;
            }
            currentSum += root.val;
            if (root.left == null && root.right == null) {
                // 到了根节点去判断是否当前节点要删除
                return currentSum < limit;
            }
            // 为什么初始化为true? 考虑在叶子节点的时候，
            boolean leftDeleted = traverse(root.left, currentSum);
            if (leftDeleted) {
                root.left = null;
            }
            boolean rightDeleted = traverse(root.right, currentSum);
            if (rightDeleted) {
                root.right = null;
            }
            return leftDeleted && rightDeleted;
        }

        // currentSum + root.val < limit 此条件在根节点判断一次就好了
        // 根节点判断了该条路径要删除
        // 其实非叶子节点只需要判断自己要不要删除即可
        // 非叶子节点判断自己要不要删除：如果两个孩子都是空的，则自己
    }
//leetcode submit region end(Prohibit modification and deletion)


}