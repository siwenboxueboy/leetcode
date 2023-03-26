//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2458 👎 0


package leetcode.editor.cn;

import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;

/**
 * 回文数
 *
 * @author wangsibo
 * @date 2023-03-19 22:16:10
 */
public class PalindromeNumber_9 {

    private static Solution getSolution() {
        return new PalindromeNumber_9().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();

        System.out.println("solution.isPalindrome(121) = " + solution.isPalindrome(121));
        System.out.println("solution.isPalindrome(-121) = " + solution.isPalindrome(-121));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            String intStr = Integer.toString(x);
            char[] chars = intStr.toCharArray();
            for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
                if (chars[i] != chars[j]){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}