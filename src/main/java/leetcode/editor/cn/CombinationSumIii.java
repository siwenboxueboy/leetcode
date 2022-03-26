//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics 数组 回溯 👍 432 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIii {
    public static void main(String[] args) {
        // 每次print 只是开头指定长度 遇到push 或者pop就重置
/*        Recursion.print("n", 2).print("i", 4).push();
        Recursion.print("n", 6).print("i", 8).push();
        Recursion.print("n", 6).print("i", 8).push();*/
        Solution solution = new CombinationSumIii().new Solution();
        List<List<Integer>> lists = solution.combinationSum3(3, 9);
        lists.forEach(System.out::println);
        System.out.println();
        Solution solution1 = new CombinationSumIii().new Solution();
        List<List<Integer>> lists1 = solution1.combinationSum3(2, 18);
        lists1.forEach(System.out::println);
        System.out.println();
        Solution solution2 = new CombinationSumIii().new Solution();
        List<List<Integer>> lists2 = solution2.combinationSum3(9, 45);
        lists2.forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            // 1 ~ k 是否大于 n
            if (k * (k + 1) / 2 > n) {
                return res;
            }
            backtrack(k, n, 1);
            return res;
        }

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        private void backtrack(int k, int n, int start) {

            // 如果遍历到叶子节点
            if (k == 0) {
                // 如果刚好n被减完 则加入结果集 否则退出
                if (n == 0)
                    res.add(new LinkedList<>(track));
                return;
            }

            for (int i = start; i <= 9; i++) {
                // 剪枝优化:如果k - 1个最小的两个数 大于 等于n 那么就没有必要去遍历了
                // 比如k=5,n=9 4,5是最小的两个数 k-1 + k-1+1 刚好是4,5
                if (k > 1 && (k - 1) * i + 1 >= n)
                    return;
                if (n < i) {
                    return;
                }
                track.add(i);
                //Recursion.push().print("i", i).print("k", k - 1).print("n", n - i).print("start", start + 1).print("track", track);
                // k - 1:决策树递归深度
                // n - i:剩余应该匹配的匹配的数值
                // i + 1:每个数字只能用一次 相当于 决策树的宽度
                backtrack(k - 1, n - i, i + 1);
                track.removeLast();
                // 因为track已经removeLast,所有剩下元素也要跟着变为本层的
                //Recursion.popNoNewLine();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}