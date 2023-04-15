//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 2151, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

/**
 * 岛屿数量
 *
 * @author wangsibo
 * @date 2023-04-15 16:35:05
 */
public class NumberOfIslands_200 {

    private static Solution getSolution() {
        return new NumberOfIslands_200().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main1(String[] args) {
        Solution solution = getSolution();

        char[][] chars = Builder.buildDimensionalCharsArray("[[\"1\",\"1\",\"1\",\"1\",\"0\"], [\"1\",\"1\",\"0\",\"1\",\"0\"], [\"1\",\"1\",\"0\",\"0\",\"0\"], [\"0\",\"0\",\"0\",\"0\",\"0\"]]");
        System.out.println("solution.numIslands(chars) = " + solution.numIslands(chars));
        Console.log(chars);
        Assert.checkEqual();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();

        char[][] chars = Builder.buildDimensionalCharsArray("[[\"1\",\"1\",\"1\"],[\"0\",\"1\",\"0\"],[\"1\",\"1\",\"1\"]]");
        System.out.println("solution.numIslands(chars) = " + solution.numIslands(chars));
        Console.log(chars);
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean visited[][] = null;
        private int count;

        public int numIslands(char[][] grid) {

            if (grid == null) {
                return 0;
            }
            int length = grid.length;
            if (length == 0) {
                return 0;
            }
            int length1 = grid[0].length;
            if (length1 == 0) {
                return 0;
            }
            this.count = 0;
            visited = new boolean[grid.length][grid[0].length];
            // 初始化visited[i][j] = false
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j]) {
                        dfs(grid, i, j, true);
                    }
                }
            }
            return this.count;
        }

        /**
         * 思路：dfs思想，对于可以遍历的一整块`1`,仅计数count一次
         * */
        private void dfs(char[][] grid, int i, int j, boolean plus) {
            if (!visited[i][j]) {
                visited[i][j] = true;
                if (plus && grid[i][j] == '1') {
                    count++;
                    plus = false;
                }
                if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
                    dfs(grid, i, j + 1, plus);
                }
                if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                    dfs(grid, i + 1, j, plus);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    dfs(grid, i, j - 1, plus);
                }
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    dfs(grid, i - 1, j, plus);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}