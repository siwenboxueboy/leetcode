//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 栈 递归 链表 双指针 ? 208 ? 0


package leetcode.editor.cn;

import com.quickcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siwenboxue
 */
public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {


         Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode listNode = new ListNode(2, new ListNode(3, new ListNode(1)));
//        new ListNode()
        int[] ints = solution.reversePrint(listNode);
        for (int anInt : ints) {

            System.out.println(anInt);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    List<Integer> list = new ArrayList<>();

    public void traverse(ListNode node){
        if (node == null) {
            return;
        }
        traverse(node.next);
        list.add(node.val);
    }

    public int[] reversePrint(ListNode head) {
        traverse(head);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

/*    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }
        int size = 0;
        ListNode top = null,p = head,q = head.next;
        // 节点入栈 倒着输出
        while (p != null){
            top = push(top,p);
            size++;
            p = q;
            if (q == null) break;
            q = q.next;
        }

        int[] ints = new int[size];
        int i = 0;
        while (top!=null){
            ints[i++] = top.val;
            top = top.next;
        }
        return ints;
    }

    // ListNode 节点入栈
    private ListNode push(ListNode top,ListNode p){
        if (top == null){
            top = p;
            p.next = null;
        }else if (top != null){
            p.next = top;
            top = p;
        }
        return top;
    }*/
/*    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int temp = 0;
        for (int i = 0,j = list.size() - 1; i < j; i++,j--) {
            temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
        }
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}