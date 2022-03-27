//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1738 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;

/**
 * 跳跃游戏
 *
 * @author wangsibo
 * @date 2022-03-26 15:42:29
 */
public class JumpGame {

    private static Solution getSolution() {
        return new JumpGame().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        System.out.println(solution.canJump(Builder.buildInt(2, 3, 1, 1, 4)));
        System.out.println(solution.canJump(Builder.buildInt(3, 2, 1, 0, 4)));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心解法
     */
    class Solution {
        public boolean canJump(int[] nums) {
            // 贪心的解法 每一步都在求局部的最优解 然后到达总体最优解
            // 都是下标值
            if (nums == null || nums.length == 0) return false;
            int maxIndex = 0; // 总体上最大的长度
            int currentIndex = 0; // 当前节点能走到的最大的长度
            for (int i = 0; i < nums.length; i++) {
                // 如果当前的路径长度已经大于最大能到达的路径长度,则表示到不了从当前的位置
                if (i > maxIndex) return false;
                // 更新局部值
                currentIndex = i + nums[i];
                // 更新全局最优值
                if (currentIndex > maxIndex) {
                    maxIndex = currentIndex;
                }
            }
            return maxIndex >= nums.length - 1;
        }

        /*
         * dp解法
         * */
        public boolean canJumpDp(int[] nums) {
            if (nums == null || nums.length == 0) return true;
            boolean[] f = new boolean[nums.length];
            // 遍历填充bool数组
            f[0] = true; //
            for (int i = 1; i < f.length; i++) {
                // [0,i) 去找能不能到达f[i]
                for (int j = 0; j < i; j++) {
                    // 能走到f[i - j],并且(i - j)这一步所可以走到的最大路径 要覆盖到可以走到j
                    if (f[j] && nums[j] >= i - j) {
                        f[i] = true;
                        break;
                    }
                }
            }
            return f[f.length - 1];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}