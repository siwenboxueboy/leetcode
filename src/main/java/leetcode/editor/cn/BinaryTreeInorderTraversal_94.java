//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1755 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author wangsibo
 * @date 2023-03-26 19:29:32
 */
public class BinaryTreeInorderTraversal_94 {

    private static Solution getSolution() {
        return new BinaryTreeInorderTraversal_94().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        List<Integer> integers = solution.inorderTraversal(Builder.buildTreeNode(1, 2, null, 3, 5));
        integers.forEach(System.out::println);
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
        // 中序非递归遍历
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (p != null || stack.size() > 0) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                // 因为while条件中两个条件的关系是或的关系 所以会出现栈空的情况 真的会出现这种情况吗？
                // 1, 2, null, 3, 5 回溯到1的位置的时候，此时1出栈，栈空，p = p->right 也为 null 所以while条件是进不来的 所以不存在这种情况
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}