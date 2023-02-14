package ds.sort;

import com.quickcode.entity.TreeNode;

import java.util.LinkedList;

public class Tree {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        String first = queue.getFirst();// 队头
        String last = queue.getLast();// 队尾
        String peek = queue.peek();
        boolean offer = queue.offer("");

    }


    // 先根遍历
    static void preTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println("treeNode.val = " + treeNode.val);
            preTraverse(treeNode.left);
            preTraverse(treeNode.right);
        }
    }

    static void midTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            midTraverse(treeNode.left);
            System.out.println("treeNode.val = " + treeNode.val);
            midTraverse(treeNode.right);
        }
    }

    static void postTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            postTraverse(treeNode.left);
            postTraverse(treeNode.right);
            System.out.println("treeNode.val = " + treeNode.val);
        }
    }

    private static TreeNode delBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 根节点的删除如何处理
        if (root.val == target) {
            return delBSTTreeNode(root);
        }
        delBSTTreeNode(root, target);
        return root;
    }

    private static void delBSTTreeNode(TreeNode parent, int target) {
        if (parent == null) return;
        if (parent.left != null && parent.left.val == target) {
            parent.left = delBSTTreeNode(parent.left);
        } else if (parent.right != null && parent.right.val == target) {
            parent.right = delBSTTreeNode(parent.right);
        } else {
            delBSTTreeNode(parent.left, target);
            delBSTTreeNode(parent.right, target);
        }
    }

    private static TreeNode delBSTTreeNode(TreeNode node) {
        // 如果待删除节点左右子树都不剩，则删除之后直接为空
        if (node.left == null && node.right == null) return null;
        // 如果待删除节点的仅剩左子树或者右子树，则返回即可
        if (node.left != null && node.right == null) {
            return node.left;
        }
        if (node.left == null && node.right != null) {
            return node.right;
        }
        // 以下为左右子树都有值的情况 这里处理的是找左子树的最小值（也可找右子树的最大值来替代）
        // 其实就是找到左子树的最右边的节点
        TreeNode leftParentMinNode = node;
        TreeNode leftMinNode = node.left;
        while (leftMinNode.left != null) {
            leftParentMinNode = leftMinNode;
            leftMinNode = leftMinNode.left;
        }
        node.val = leftMinNode.val;
        leftParentMinNode = delBSTTreeNode(leftMinNode);
        return node;
    }

}
