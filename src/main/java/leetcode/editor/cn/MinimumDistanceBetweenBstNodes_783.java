//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
// 
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 100] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-
//bst/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 243 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;

import java.util.LinkedList;

/**
 * 二叉搜索树节点最小距离
 *
 * @author wangsibo
 * @date 2023-02-15 21:39:54
 */
public class MinimumDistanceBetweenBstNodes_783 {

    private static Solution getSolution() {
        return new MinimumDistanceBetweenBstNodes_783().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode node = Builder.buildTreeNode(4, 2, 6, 1, 3);
        System.out.println("solution.minDiffInBST(node) = " + solution.minDiffInBST(node));

        TreeNode node1 = Builder.buildTreeNode(1, 0, 48, null, null, 12, 49);
        System.out.println("solution.minDiffInBST(node1) = " + solution.minDiffInBST(node1));
        TreeNode node2 = Builder.buildTreeNode(90, 69, null, 49, 89, null, 52);
        System.out.println("solution.getMinDiff(node2) = " + solution.minDiffInBST(node2));
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

        private LinkedList<Integer> list = new LinkedList<>();

        public int minDiffInBST(TreeNode root) {
            if (root == null) return 0;
            traverse(root);

            if (list.size() == 1) {
                return list.getFirst();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min, Math.abs(list.get(i - 1) - list.get(i)));
            }
            list.clear();
            return min;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.left);
            list.add(root.val);
            traverse(root.right);
        }

    }


//leetcode submit region end(Prohibit modification and deletion)


}