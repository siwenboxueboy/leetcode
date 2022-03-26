//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 621 👎 0


package leetcode.editor.cn;

import com.quickcode.entity.ListNode;
import com.quickcode.entity.TreeNode;

public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
         Solution solution = new ZhongJianErChaShuLcof().new Solution();
        int[] preorder ={3,9,20,15,7};
        int[] inorder ={9,3,15,20,7};
/*        int[] preorder ={1,2,3};
        int[] inorder ={3,2,1};*/
        TreeNode treeNode = solution.buildTree(preorder, inorder);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode treeNode = traverse(0,inorder.length-1);
        return treeNode;
    }

    private int[] preorder = null;
    private int[] inorder = null;
    private int pre = 0;
    private int in = 0;

    private TreeNode traverse(int start,int end){
        if (start > end){
            return null;
        }
/*        if (start == end) {
            return new TreeNode(preorder[pre++]);
        }*/
        in = findIn(start,end);
        if (pre < preorder.length){
            TreeNode node = new TreeNode(preorder[pre++]);
            node.left = traverse(start,in -1);
            node.right = traverse(in + 1,end);
            return node;
        }
        return null;
    }

    private int findIn(int start, int end) {
        for (; start <= end; start++) {
            if (inorder[start] == preorder[pre]){
                return start;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}