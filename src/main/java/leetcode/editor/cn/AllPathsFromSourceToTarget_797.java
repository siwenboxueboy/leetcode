//给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序） 
//
// 
// graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i（即不存在自环） 
// graph[i] 中的所有元素 互不相同 
// 保证输入为 有向无环图（DAG） 
// 
//
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 回溯 
//
// 👍 394, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 *
 * @author wangsibo
 * @date 2023-04-10 20:26:14
 */
public class AllPathsFromSourceToTarget_797 {

    private static Solution getSolution() {
        return new AllPathsFromSourceToTarget_797().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        List<List<Integer>> lists = solution.allPathsSourceTarget(Builder.buildDimensionalIntsArray("[[4,3,1],[3,2,4],[3],[4],[]]"));
        Console.log(lists);
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = null;
        private List<Integer> currentPath = null;


        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            res = new ArrayList<>();
            currentPath = new ArrayList<>();
            dfs(graph, 0);
            return res;
        }

        private void dfs(int[][] graph, int index) {
            currentPath.add(index);
            if (index >= graph.length - 1) {
                List<Integer> list = new ArrayList<>(currentPath);
                res.add(list);
            }
            for (int i : graph[index]) {
                dfs(graph, i);
            }
            currentPath.remove((Object) index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}