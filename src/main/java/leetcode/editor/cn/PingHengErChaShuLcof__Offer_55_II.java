//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 348, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 平衡二叉树
 *
 * @author wangsibo
 * @date 2023-04-01 18:15:27
 */
public class PingHengErChaShuLcof__Offer_55_II {

    private static Solution getSolution() {
        return new PingHengErChaShuLcof__Offer_55_II().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode treeNode = Builder.buildTreeNode(1, 2, 2, 3, null, null, 3, 4, null, null, 4);
        boolean balanced = solution.isBalanced(treeNode);
        Console.log(balanced);
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean leftBalanced = isBalanced(root.left);
            boolean rightBalanced = false;
            // 如果左不平衡 则右边不用遍历了
            if (leftBalanced) {
                rightBalanced = isBalanced(root.right);
            }
            // 如果已经找到不平衡了 则不用计算深度了
            if (!leftBalanced || !rightBalanced) {
                return false;
            }
            int leftDepth = traverse(root.left);
            int rightDepth = traverse(root.right);

            return Math.abs(leftDepth - rightDepth) <= 1 && rightBalanced && leftBalanced;
        }


        private int traverse(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            int leftDepth = traverse(treeNode.left);
            int rightDepth = traverse(treeNode.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}