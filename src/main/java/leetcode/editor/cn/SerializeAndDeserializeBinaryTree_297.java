//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树 
//
// 👍 1084, 👎 0 
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
 * 二叉树的序列化与反序列化
 *
 * @author wangsibo
 * @date 2023-04-03 20:28:29
 */
public class SerializeAndDeserializeBinaryTree_297 {


    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        char c = '(';
        int t = c;
        System.out.println("t = " + t);
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode node = Builder.buildTreeNode(3, 2, 4, 3);
        String serialize = ser.serialize(node);
        TreeNode ans = deser.deserialize(serialize);
        Console.log(ans);
        Assert.checkEqual();
    }
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
class Codec {
    // 采用层序遍历的方式
    // 序列化 即层序遍历，空值用n代替即可
    // 反序列化 反层序遍历

    private StringBuilder builder;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        this.builder = new StringBuilder();
        preTraverse(root, 1);
        return this.builder.toString();
    }

    private void preTraverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        builder.append('(');
        builder.append(root.val);
        if (root.left != null) {
            preTraverse(root.left, depth + 1);
        } else {
            builder.append("(n)");
        }
        if (root.right != null) {
            preTraverse(root.right, depth + 1);
        } else {
            builder.append("(n)");
        }
        builder.append(')');
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        TreeNode node = findNode(data);
        return node;
    }

    /**
     * 举例：(3(2(3(n)(n))(n))(4(n)(n)))
     * */
    private TreeNode findNode(String data) {
        // 去外层括号
        String substring = data.substring(1, data.length() - 1);
        int firstIndex = substring.indexOf('(');
        int lastIndex = substring.lastIndexOf(')');
        if (firstIndex < 0 || lastIndex < 0) {
            return null;
        }
        // 取数字
        String valStr = substring.substring(0, firstIndex);
        data = substring.substring(firstIndex);

        int val = Integer.parseInt(valStr);
        TreeNode root = new TreeNode(val);

        char[] chars = data.toCharArray();
        int left = 0, i = 0;
        for (; i < chars.length; i++) {
            if ('(' == chars[i]) {
                left++;
            }
            if (')' == chars[i]) {
                left--;
            }
            if (left == 0) {
                break;
            }
        }
        root.left = findNode(data.substring(0, i + 1));
        root.right = findNode(data.substring(i + 1));
        return root;
    }

    // 层序构建 利用前序+中序还原 但是此方法只适用于唯一节点 一旦有重复节点就不行了
    public TreeNode deserialize1(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] split = data.split(",\\|");
        if (split.length != 2) {
            return null;
        }
        String preStr = split[0];
        String midStr = split[1];
        String[] preArray = preStr.split(",");
        String[] midArray = midStr.split(",");
        if (midArray.length != preArray.length) {
            return null;
        }
        TreeNode node = buildTreeNode(preArray, midArray, 0, preArray.length - 1, 0, midArray.length - 1);
        return node;
    }

    private TreeNode buildTreeNode(String[] preArray, String[] midArray, int preStart, int preEnd, int midStart, int midEnd) {
        if (preStart < 0 || preStart >= preArray.length) {
            return null;
        }
        if (midStart > midEnd) {
            return null;
        }
        String valStr = preArray[preStart];
        int i = midStart;
        for (; i < midEnd; i++) {
            if (valStr.equals(midArray[i])) {
                break;
            }
        }
        int val = Integer.parseInt(valStr);
        TreeNode node = new TreeNode(val);
        if (midStart <= i - 1) {
            node.left = buildTreeNode(preArray, midArray, preStart + 1, preStart + i - 1 - midStart + 1, midStart, i - 1);
        }
        if (i + 1 <= midEnd) {
            node.right = buildTreeNode(preArray, midArray, preStart + i - 1 - midStart + 2, preEnd, i + 1, midEnd);
        }
        return node;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


