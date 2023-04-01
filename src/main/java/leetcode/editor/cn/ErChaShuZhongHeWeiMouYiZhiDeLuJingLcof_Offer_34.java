//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
//
// Related Topics树 | 深度优先搜索 | 回溯 | 二叉树 
//
// 👍 416, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * @author wangsibo
 * @date 2023-04-01 17:47:17
 */
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof_Offer_34 {

    private static Solution getSolution() {
        return new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof_Offer_34().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        TreeNode treeNode = Builder.buildTreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        List<List<Integer>> lists = solution.pathSum(treeNode, 22);
        Console.log(lists);

        TreeNode treeNode1 = Builder.buildTreeNode(1,2,3);
        List<List<Integer>> lists1 = solution.pathSum(treeNode1, 5);
        Console.log(lists1);

        TreeNode treeNode2 = Builder.buildTreeNode(1,2);
        List<List<Integer>> lists2 = solution.pathSum(treeNode2, 5);
        Console.log(lists2);
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


        private List<List<Integer>> res;

        private int target;

        /**
         * 思路：第一次遇到节点时加入遍历列表
         * 当为叶子节点时计算是否为目标值，若是，则加入最终结果集
         * 第三次遇到节点时，将遍历列表尾部删除
         */
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            this.target = target;
            traverse(root, 0, new ArrayList<>());
            return res;
        }

        private void traverse(TreeNode root, int currentSum, List<Integer> list) {
            if (root == null) {
                return;
            }
            int size = list.size();
            list.add(root.val);
            currentSum += root.val;
            if (root.left == null && root.right == null && currentSum == this.target) {
                res.add(new ArrayList<>(list));
            }
            traverse(root.left, currentSum, list);
            traverse(root.right, currentSum, list);
            list.remove(size);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}