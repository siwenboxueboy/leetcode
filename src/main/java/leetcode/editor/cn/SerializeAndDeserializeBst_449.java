//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 403 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.TreeNode;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

/**
 * 序列化和反序列化二叉搜索树
 *
 * @author wangsibo
 * @date 2023-02-12 09:30:32
 */
public class SerializeAndDeserializeBst_449 {

    private static Codec getSolution() {
        return new SerializeAndDeserializeBst_449().new Codec();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Codec solution = getSolution();
        TreeNode treeNode = Builder.buildTreeNode(2, 1, 3);
        Console.log(solution.serialize(treeNode));
        Console.log(solution.serialize(null));

        Console.log(solution.deserialize("[2,1,3]"));
        Console.log(solution.deserialize("[]"));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        private StringBuilder stringBuilder = new StringBuilder();

        // Encodes a tree to a single string.
        // 序列化 其实就是中序输出二叉树
        public String serialize(TreeNode root) {
            stringBuilder.append('[');
            traverse(root);
            int i = stringBuilder.lastIndexOf(",");
            if (i != -1) {
                stringBuilder.deleteCharAt(i);
            }
            stringBuilder.append(']');
            String res = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            stringBuilder.append(root.val);
            stringBuilder.append(',');
            traverse(root.left);
            traverse(root.right);
        }


        // 反序列化 其实就是构建一个二叉树
        // Decodes your encoded data to tree.
        public TreeNode deserialize1(String data) {
            String substringData = data.substring(1, data.length() - 1);
            if ("".equals(substringData)) {
                return null;
            }
            String[] nodeValArray = substringData.split(",");
            TreeNode treeNode = new TreeNode(Integer.parseInt(nodeValArray[0]));
            for (int i = 1; i < nodeValArray.length; i++) {
                buildBST(Integer.parseInt(nodeValArray[i]), treeNode);
            }
            return treeNode;
        }

        private void buildBST(int nodeVal, TreeNode node) {
            if (nodeVal > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(nodeVal);
                } else {
                    buildBST(nodeVal, node.right);
                }
            } else if (nodeVal < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(nodeVal);
                } else {
                    buildBST(nodeVal, node.left);
                }
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            root = null;
            String substringData = data.substring(1, data.length() - 1);
            if ("".equals(substringData)) {
                return null;
            }
            String[] nodeValArray = substringData.split(",");
            for (int i = 0; i < nodeValArray.length; i++) {
                insert(Integer.parseInt(nodeValArray[i]));
            }
            return root;
        }

        private TreeNode root;

        private void insert(int key) {
            root = insertRec(root, key);
        }

        private TreeNode insertRec(TreeNode root, int key) {

            if (root == null) {
                root = new TreeNode(key);
                return root;
            }

            if (key < root.val) {
                root.left = insertRec(root.left, key);
            } else if (key > root.val) {
                root.right = insertRec(root.right, key);
            }
            return root;
        }
    }
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)


}