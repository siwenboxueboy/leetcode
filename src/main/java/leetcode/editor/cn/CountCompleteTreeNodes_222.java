//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 树 深度优先搜索 二分查找 二叉树 👍 770 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

import java.util.Objects;

/**
 * 完全二叉树的节点个数
 *
 * @author wangsibo
 * @date 2022-08-29 22:29:00
 */
public class CountCompleteTreeNodes_222 {

    private static Solution getSolution() {
        return new CountCompleteTreeNodes_222().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        int i = solution.countNodes(Builder.buildTreeNode(1, 2, 3, 4, 5, 6));
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
        public int countNodes(TreeNode root) {
            preTraverse(root);
            return count;
        }

        private int count = 0;

        private void preTraverse(TreeNode treeNode) {
            if (Objects.nonNull(treeNode)) {
                this.count++;
                preTraverse(treeNode.right);
                preTraverse(treeNode.left);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}