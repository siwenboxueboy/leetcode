//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 1969, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;

/**
 * 验证二叉搜索树
 *
 * @author wangsibo
 * @date 2023-04-09 11:54:12
 */
public class ValidateBinarySearchTree_98 {

    private static Solution getSolution() {
        return new ValidateBinarySearchTree_98().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode treeNode = Builder.buildTreeNode(5, 1, 4, null, null, 3, 6);
        System.out.println("solution.isValidBST(treeNode) = " + solution.isValidBST(treeNode));
        TreeNode treeNode1 = Builder.buildTreeNode(2, 1, 3);
        solution.lastVal = null;
        System.out.println("solution.isValidBST(treeNode1) = " + solution.isValidBST(treeNode1));
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

        private Integer lastVal;

        // 满足中序遍历顺序特性即是一棵BST
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean isValidLeft = isValidBST(root.left);
            if (!isValidLeft){
                return false;
            }
            boolean isValid = false;
            if (lastVal == null || lastVal < root.val) {
                isValid = true;
            }
            lastVal = root.val;
            if (!isValid){
                return false;
            }
            boolean isValidRight = isValidBST(root.right);
            return isValidRight;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)


}