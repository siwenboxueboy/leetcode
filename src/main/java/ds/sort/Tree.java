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
}
