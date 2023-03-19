package ds.sort;

import com.quickcode.builder.Builder;
import com.quickcode.entity.TreeNode;
import com.quickcode.print.Console;

import java.util.LinkedList;

public class Tree {
    public static void main(String[] args) {
        String s = null;
        LinkedList<String> queue = new LinkedList<>();
/*        String first = queue.getFirst();// 队头
        String last = queue.getLast();// 队尾
        String peek = queue.peek();
        boolean offer = queue.offer("");*/

        TreeNode root = Builder.buildTreeNode(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15);
        System.out.println("isBST(root) = " + isBST(root));

        // 测试左右孩子都存在的情况
        // 删除节点12，并验证删除后是否符合二叉搜索树的特性
        root = delBSTByChatGPT(root, 12);
        System.out.println("isBST(root) = " + isBST(root));

        // 测是根节点删除
        // 删除根节点8，并验证删除后是否符合二叉搜索树的特性
        root = delBSTByChatGPT(root, 8);
        System.out.println("isBST(root) = " + isBST(root));

        // 测试单孩子删除
        // 删除根节点14，并验证删除后是否符合二叉搜索树的特性
        root = delBSTByChatGPT(root, 14);
        System.out.println("isBST(root) = " + isBST(root));

        // 测试叶子节点删除
        // 删除根节点1，并验证删除后是否符合二叉搜索树的特性
        root = delBSTByChatGPT(root, 1);
        System.out.println("isBST(root) = " + isBST(root));

        // 测试不存在的节点删除
        // 删除根节点100，并验证删除后是否符合二叉搜索树的特性
        root = delBSTByChatGPT(root, 100);
        System.out.println("isBST(root) = " + isBST(root));

        // 不存在的节点删除
        // 删除根节点1，并验证删除后是否符合二叉搜索树的特性
        root = delBSTByChatGPT(root, 1);
        System.out.println("isBST(root) = " + isBST(root));

        Console.log(root);
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
        // 如果待删除节点的仅剩左子树或者右子树，则返回即可
        if (node.left == null && node.right == null) {
            return null;
        }
        if (node.left != null && node.right == null) {
            return node.left;
        }
        if (node.left == null && node.right != null) {
            return node.right;
        }
        // 左右子树都存在，寻找右子树中的最小值作为替代节点
        TreeNode rightParentMinNode = node;
        TreeNode rightMinNode = node.right;
        while (rightMinNode.left != null) {
            rightParentMinNode = rightMinNode;
            rightMinNode = rightMinNode.left;
        }
        node.val = rightMinNode.val;
        rightParentMinNode.left = delBSTTreeNode(rightMinNode);
        return node;
    }

    private static boolean isBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;
        return isBST(root.left) && isBST(root.right);
    }

    // 写递归算法 核心要义
    // 定义清晰：确保函数的定义及参数和返回值的含义清晰明确；
    //子问题规模更小：每次递归调用都将原问题分解为一个或多个规模更小但相同的子问题；
    //结束递归：递归函数的结束条件要明确，确保子问题无法再分解，直接得到结果或者可以递归地合并得到原问题的解；
    //状态独立：每次递归调用时，参数和函数体内的局部变量都应该独立于其他调用，避免出现状态共享导致结果错误的情况；
    //合并结果：递归调用的结果需要合并得到原问题的解。
    // 此外，我的写法对于删除节点的处理逻辑做了一些优化，能够更好地处理节点的删除，尤其是对于有两个子节点的节点的删除。
    // 同时，我的写法在递归时采用的是函数返回值来传递删除后子树的根节点，避免了通过修改父节点指针来实现子树连接的复杂操作。
    private static TreeNode delBSTByChatGPT(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val > target) {
            root.left = delBSTByChatGPT(root.left, target);
        } else if (root.val < target) {
            root.right = delBSTByChatGPT(root.right, target);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = delBSTByChatGPT(root.right, minNode.val);
            }
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }



}
