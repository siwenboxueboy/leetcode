//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
// Related Topics 数学 动态规划 组合数学 👍 1339 👎 0


package leetcode.editor.cn;

import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;

/**
 * 不同路径
 *
 * @author wangsibo
 * @date 2022-03-26 15:05:32
 */
public class UniquePaths {

    private static Solution getSolution() {
        return new UniquePaths().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.uniquePaths(3, 2));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 0 || n == 0) return 0;
            // 开2行n列 滚动数组优化
            int[][] f = new int[2][n];
            f[0][0] = f[1][0] = 1;
            for (int i = 1; i < n; i++) {
                f[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    f[i % 2][j] = f[(i - 1) % 2][j] + f[i % 2][j - 1];
                }
            }
            return f[(m - 1) % 2][n - 1];
        }

/*        public int uniquePaths(int m, int n) {
            // 未进行滚动数组优化
            if (m == 0 || n == 0) return 0;
            int[][] f = new int[m][n];
            for (int i = 0; i < m; i++) {
                f[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                f[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
            return f[m - 1][n - 1];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)


}