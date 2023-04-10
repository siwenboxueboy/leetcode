//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics树 | 二叉搜索树 | 二叉树 
//
// 👍 1111, 👎 0 
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
 * 删除二叉搜索树中的节点
 *
 * @author wangsibo
 * @date 2023-04-09 11:51:49
 */
public class DeleteNodeInABst_450 {

    private static Solution getSolution() {
        return new DeleteNodeInABst_450().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode treeNode = Builder.buildTreeNode(5, 3, 6, 2, 4, null, 7);
        TreeNode treeNode1 = solution.deleteNode(treeNode, 3);
        Console.log(treeNode1);
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
        // 通过二分查找找到对应待删除节点的父节点
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                // 左孩子空
                if (root.left == null) {
                    return root.right;
                }
                // 右孩子空
                if (root.right == null) {
                    return root.left;
                }
                // 将左孩子接到右孩子的左下
                TreeNode node = findLeftLeaf(root.right);
                node.left = root.left;
                return root.right;
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        private TreeNode findLeftLeaf(TreeNode root) {
            while (root != null && root.left != null) {
                root = root.left;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}