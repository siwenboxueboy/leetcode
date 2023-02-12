//给定二叉搜索树（BST）的根节点
// root 和一个整数值
// val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
// null 。 
//
// 
//
// 示例 1: 
//
// 
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// 示例 2: 
// 
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 数中节点数在 [1, 5000] 范围内 
// 1 <= Node.val <= 10⁷ 
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
//
// Related Topics 树 二叉搜索树 二叉树 👍 360 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

/**
 * 二叉搜索树中的搜索
 *
 * @author wangsibo
 * @date 2023-02-11 20:31:46
 */
public class SearchInABinarySearchTree_700 {

    private static Solution getSolution() {
        return new SearchInABinarySearchTree_700().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        Console.log(solution.searchBST(Builder.buildTreeNode(4, 2, 7, 1, 3), 2));
        Console.log(solution.searchBST(Builder.buildTreeNode(4, 2, 7, 1, 3), 5));
        Assert.checkEqual();
    }

    // 递归算法
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
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
        // 非递归算法
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            TreeNode p = root;
            while (p != null) {
                if (p.val == val) return p;
                if (val > p.val) {
                    // 说明在右子树里
                    p = p.right;
                } else {
                    p = p.left;
                }
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}