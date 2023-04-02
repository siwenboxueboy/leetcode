//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 链表 | 二叉树 
//
// 👍 1435, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 二叉树展开为链表
 *
 * @author wangsibo
 * @date 2023-04-01 18:46:05
 */
public class FlattenBinaryTreeToLinkedList_114 {

    private static Solution getSolution() {
        return new FlattenBinaryTreeToLinkedList_114().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode node = Builder.buildTreeNode(0);
        solution.flatten(node);
        Console.log(node);
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
        /**
         * 解题思路：先考虑一个子树，比如2，3，4构成的子树
         * 2，3，4构成的子树，最终是要变换成为2的右孩子是3，3的右孩子是4
         *
         * */
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            if (root.left != null) {

                    // 取左孩子的最右边节点
                    TreeNode node = getRightNode(root.left);
                    node.right = root.right;

                // 改变孩子指向 左孩子变为右孩子
                root.right = root.left;
                root.left = null;
            }
        }

        private TreeNode getRightNode(TreeNode node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}