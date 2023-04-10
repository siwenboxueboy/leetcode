//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 722, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;

/**
 * 二叉搜索树中第K小的元素
 *
 * @author wangsibo
 * @date 2023-04-09 11:24:16
 */
public class KthSmallestElementInABst_230 {

    private static Solution getSolution() {
        return new KthSmallestElementInABst_230().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();

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

        private int value = 0;
        private int k;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            boolean found = traverse(root);
            if (found) return value;
            else return -1;
        }

        private boolean traverse(TreeNode root) {
            if (root == null) {
                return false;
            }
            boolean found = traverse(root.left);
            if (found) {
                return true;
            }
            if (--k == 0) {
                value = root.val;
                return true;
            }
            found = traverse(root.right);
            if (found) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}