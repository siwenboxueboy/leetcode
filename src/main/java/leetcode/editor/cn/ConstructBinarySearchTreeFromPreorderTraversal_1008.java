//给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。 
//
// 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。 
//
// 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大
//于 Node.val。 
//
// 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1,3]
//输出: [1,null,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 10^8 
// preorder 中的值 互不相同 
// 
//
// 
//
// Related Topics 栈 树 二叉搜索树 数组 二叉树 单调栈 👍 250 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

import java.util.*;

/**
 * 前序遍历构造二叉搜索树
 *
 * @author wangsibo
 * @date 2023-03-26 20:21:05
 */
public class ConstructBinarySearchTreeFromPreorderTraversal_1008 {

    private static Solution getSolution() {
        return new ConstructBinarySearchTreeFromPreorderTraversal_1008().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
/*        Solution solution = getSolution();
        TreeNode treeNode = solution.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        Console.log(treeNode);
        TreeNode treeNode1 = solution.bstFromPreorder(new int[]{1, 3});
        Console.log(treeNode1);*/

        Integer[] ints = {8, 5, 1, 7, 10, 12};
        Solution solution = getSolution();
       // Console.log(solution.preorderTraverse(Builder.buildTreeNode(ints)));
        Assert.checkEqual();
        Queue queue = new LinkedList<>();
        Stack stack = new Stack();
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


        // 普通的建立树的过程即可
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode treeNode = null;
            for (int val : preorder) {
                treeNode = addTreeNode(val, treeNode);
            }
            return treeNode;
        }

        // 递归写法
        // 遍历后 判断后一个节点
        private TreeNode addTreeNode(int val, TreeNode root) {
            if (root == null) {
                root = new TreeNode(val);
            }
            int rootVal = root.val;
            if (val > rootVal) {
                root.right = addTreeNode(val, root.right);
            } else if (val < rootVal) {
                root.left = addTreeNode(val, root.left);
            }
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}