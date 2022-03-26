//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1805 👎 0


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;

/**
 * 零钱兑换
 *
 * @author wangsibo
 * @date 2022-03-20 10:35:29
 */
public class CoinChange {

    private static Solution getSolution() {
        return new CoinChange().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        System.out.println(solution.coinChange(Builder.buildInt(1, 2, 5), 11));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount == 0) return 0;
            int[] f = new int[amount + 1];
            // 从0块到27块最少的硬币数量
            f[0] = 0;// 初始条件 0块钱用0枚硬币拼出
            for (int i = 1; i <= amount; i++) {
                // 每一步都要进行用3个硬币去比较 看谁大
                f[i] = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    // 当前的面值应该是大于硬币面值的才可以更新 也就是i > coins[j]
                    // 并且上一枚硬币应该也可以拼出 否则他还是初始值
                    if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE){
                        f[i] = Integer.min(f[i],  f[i - coins[j]] + 1);
                    }
                }
            }
            // 如果最后一枚没有拼出 则返回-1
            return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}