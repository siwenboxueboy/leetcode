//存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u]
// 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有
//以下属性：
//
// 
// 不存在自环（graph[u] 不包含 u）。 
// 不存在平行边（graph[u] 不包含重复值）。 
// 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图） 
// 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。 
// 
//
// 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称
//为 二分图 。 
//
// 如果图是二分图，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//输出：false
//解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。 
//
// 示例 2： 
// 
// 
//输入：graph = [[1,3],[0,2],[1,3],[0,2]]
//输出：true
//解释：可以将节点分成两组: {0, 2} 和 {1, 3} 。 
//
// 
//
// 提示： 
//
// 
// graph.length == n 
// 1 <= n <= 100 
// 0 <= graph[u].length < n 
// 0 <= graph[u][i] <= n - 1 
// graph[u] 不会包含 u 
// graph[u] 的所有值 互不相同 
// 如果 graph[u] 包含 v，那么 graph[v] 也会包含 u 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 图 
//
// 👍 458, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二分图
 *
 * @author wangsibo
 * @date 2023-04-18 19:42:52
 */
public class IsGraphBipartite_785 {

    private static Solution getSolution() {
        return new IsGraphBipartite_785().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();
        System.out.println(solution.isBipartite(Builder.buildDimensionalIntsArray("[[1,2,3],[0,2],[0,1,3],[0,2]]")));
        System.out.println(solution.isBipartite(Builder.buildDimensionalIntsArray("[[1,3],[0,2],[1,3],[0,2]]")));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        // 1 / 0
        private Boolean[] parts;
        private Queue<Integer> queue;

        private Queue<Boolean> queueParts;

        public boolean isBipartite(int[][] graph) {
            if (graph == null || graph.length == 0) {
                return true;
            }
            // init visited
            parts = new Boolean[graph.length];
            queue = new LinkedList<>();
            queueParts = new LinkedList<>();
            for (int i = 0; i < graph.length; i++) {
                if (parts[i] == null) {
                    bfs(graph, i);
                }
            }

            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (parts[i].equals(parts[graph[i][j]])) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void bfs(int[][] graph, int i) {
            boolean p = false;
            queue.offer(i);
            queueParts.offer(p);
            parts[i] = p;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                Boolean parts = queueParts.poll();
                for (int k = 0; k < graph[poll].length; k++) {
                    if (this.parts[graph[poll][k]] == null) {
                        queue.offer(graph[poll][k]);
                        this.parts[graph[poll][k]] = !parts;
                        queueParts.offer(!parts);
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}