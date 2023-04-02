//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
// 
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics栈 | 树 | 数组 | 分治 | 二叉树 | 单调栈 
//
// 👍 656, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 最大二叉树
 *
 * @author wangsibo
 * @date 2023-04-02 11:33:47
 */
public class MaximumBinaryTree_654 {

    private static Solution getSolution() {
        return new MaximumBinaryTree_654().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        int[] ints = Builder.buildInt(3, 2, 1, 6, 0, 5);
        TreeNode treeNode = solution.constructMaximumBinaryTree(ints);
        Console.log(treeNode);
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

        private int[] nums;

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            this.nums = nums;
            return createMaxTreeNode(0, this.nums.length - 1, null);
        }

        private TreeNode createMaxTreeNode(int left, int right, TreeNode root) {
            if (left > right || left < 0 || right >= nums.length) {
                return null;
            }
            // 找最大值的序号
            int maxIndex = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[maxIndex] < nums[i]) {
                    maxIndex = i;
                }
            }
            TreeNode treeNode = new TreeNode(nums[maxIndex]);
            treeNode.left = createMaxTreeNode(left, maxIndex - 1, treeNode.left);
            treeNode.right = createMaxTreeNode(maxIndex + 1, right, treeNode.right);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}