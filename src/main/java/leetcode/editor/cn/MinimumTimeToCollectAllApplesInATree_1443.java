//给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从 节点 0 出发，请你返回最
//少需要多少秒，可以收集到所有苹果，并回到节点 0 。 
//
// 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数
//组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
//false,true,false,true,true,false]
//输出：8 
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
//false,true,false,false,true,false]
//输出：6
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 3： 
//
// 
//输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
//false,false,false,false,false,false]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai < bi <= n - 1 
// hasApple.length == n 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 哈希表 
//
// 👍 79, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;

import java.util.*;

/**
 * 收集树上所有苹果的最少时间
 *
 * @author wangsibo
 * @date 2023-04-13 20:19:43
 */
public class MinimumTimeToCollectAllApplesInATree_1443 {

    private static Solution getSolution() {
        return new MinimumTimeToCollectAllApplesInATree_1443().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        int[][] ints = Builder.buildDimensionalIntsArray("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]");
        List<Boolean> booleans = List.of(false, false, true, false, false, true, false);
        int minTime = solution.minTime(7, ints, booleans);
        Assert.check(minTime, 6, (v1, v2) -> v1 == v2);
        int[][] ints1 = Builder.buildDimensionalIntsArray("[[0,2],[0,3],[1,2]]");
        List<Boolean> booleans1 = List.of(false, true, false, false);
        int minTime1 = solution.minTime(4, ints1, booleans1);
        Assert.check(minTime1, 4, (v1, v2) -> v1 == v2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean[] visited = null;
        private Map<Integer, List<Integer>> map = null;


        private void set(int key, int value) {
            List<Integer> integers = map.get(key);
            if (integers == null) {
                integers = new LinkedList<>();
            }
            integers.add(value);
            map.put(key, integers);
        }

        private List<Integer> get(int key) {
            List<Integer> integers = map.get(key);
            return integers == null ? Collections.emptyList() : integers;
        }

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            if (n <= 0) {
                return 0;
            }
            visited = new boolean[n];
            map = new HashMap<>(n);
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                set(from, to);
                set(to, from);
            }
            return dfs(-1, 0, edges, hasApple);
        }


        private int dfs(int currentTime, int currentNode, int[][] edges, List<Boolean> hasAppleList) {
            int time = ++currentTime;
            // 不是节点 并且也不是中间路径 则就不加
            // 如何判断不是节点
            visited[currentNode] = true;
            List<Integer> list = get(currentNode);
            for (Integer toNode : list) {
                if (!visited[toNode] && currentNode == currentNode) {
                    currentTime = dfs(currentTime, toNode, edges, hasAppleList);
                }
            }

            Boolean hasApple = hasAppleList.get(currentNode);
            // 如果次数比开始时候的次数大 则说明子节点有 说明该路径不需要进行加入
            if (currentNode == 0) {
                return currentTime;
            }
            if (hasApple || currentTime > time) {
                // 当前节点含有苹果 则要
                currentTime++;
            } else {
                currentTime--;
            }
            return currentTime;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}