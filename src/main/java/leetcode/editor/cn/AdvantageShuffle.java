//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心 数组 排序 👍 168 👎 0


package leetcode.editor.cn;


import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.entity.*;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

import java.util.Arrays;

public class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
        Assert.checkEqual();
        Builder.buildChar("");
        Console.log("");
        Recursion.getInstance().pop();
        TreeNode treeNode = new TreeNode();
        ListNode listNode = new ListNode();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int[] sortedNums1 = Arrays.copyOf(nums1, nums1.length);
            Arrays.sort(sortedNums1);
            int[] sortedNums2 = Arrays.copyOf(nums2, nums2.length);
            Arrays.sort(sortedNums2);
            // if nums1 can win , then complete

            // if nums1 can not win, then swap last to complete
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}