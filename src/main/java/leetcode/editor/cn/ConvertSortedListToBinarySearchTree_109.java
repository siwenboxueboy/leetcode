//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 819 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.ListNode;
import com.quickcode.entity.TreeNode;
import com.quickcode.print.Console;

/**
 * 有序链表转换二叉搜索树
 *
 * @author wangsibo
 * @date 2023-03-25 09:46:20
 */
public class ConvertSortedListToBinarySearchTree_109 {

    private static Solution getSolution() {
        return new ConvertSortedListToBinarySearchTree_109().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    // 本题其实就是给了一个中序遍历的链表，让构造一个以该链表为顺序的二叉树
    // 难点在中序链表定位中间元素，这个可以用快慢指针来搞定
    // 为什么没有想到这种方式？因为对这个性质不太熟悉导致的
    // 性质为：折半查找的判断树是一个平衡二叉树
    // 本题思路：快慢指针 + 分治
    public static void main(String[] args) {
        Solution solution = getSolution();
        ListNode listNode = Builder.buildListNode(-10, -3, 0, 5, 9);
        TreeNode node = solution.sortedListToBST(listNode);
        Console.log(node);
        // Assert.checkEqual(node,Builder.buildTreeNode());
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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


        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            TreeNode node = insert(head, null);
            return node;
        }

        /**
         * 如果本层节点要依赖下层递归生产新值
         * 那么该函数应该设置返回值，返回值的接收对象即为上层函数的左右子树
         */

        private TreeNode insert(ListNode head, ListNode rear) {
            ListNode mid = findMid(head, rear);
            if (mid == null) {
                return null;
            }
            TreeNode root = new TreeNode(mid.val);
            if (head != mid) {
                root.left = insert(head, mid);
            }
            if (mid.next != rear) {
                // 由于mid已经是当前元素了，所以要从mid.next开始找起
                root.right = insert(mid.next, rear);
            }
            return root;
        }


        // 快慢指针找中间元素 [head,rear)
        private ListNode findMid(ListNode head, ListNode rear) {
            ListNode slow = head, fast = head;
            // 区间是左闭右开
            while (fast != rear && fast.next != rear) {
                slow = slow.next;
                fast = fast.next;
                fast = fast.next;
            }
            return slow;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}