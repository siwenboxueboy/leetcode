//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 
//
// 👍 1558, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * 课程表
 *
 * @author wangsibo
 * @date 2023-04-12 20:04:40
 */
public class CourseSchedule_207 {

    private static Solution getSolution() {
        return new CourseSchedule_207().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();

        System.out.println("" + solution.canFinish(2, Builder.buildDimensionalIntsArray("[[1,0],[0,1]]")));
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean path[] = null;
        private boolean visited[] = null;
        // 构建邻接表
        private List<Integer>[] graph = null;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
                return true;
            }
            path = new boolean[numCourses];
            visited = new boolean[numCourses];
            graph = new List[numCourses];
            for (int[] prerequisite : prerequisites) {
                int to = prerequisite[0];
                int from = prerequisite[1];
                List<Integer> nodes = graph[from];
                if (nodes == null) {
                    nodes = new LinkedList<>();
                    graph[from] = nodes;
                }
                nodes.add(to);
            }
            for (int i = 0; i < numCourses; i++) {
                if (visited[i]){
                    continue;
                }
                if (dfs(i)) {
                    return false;
                }
            }
            return true;
        }

        // 返回 是否有环
        private boolean dfs(int index) {
            // 判断是否在路径中，如果在路径中则说明已经成环
            if (path[index]) {
                return true;
            }
            // 如果已经遍历过一次，则直接退出遍历
            if (visited[index]) {
                return false;
            }
            path[index] = true;
            visited[index] = true;
            if (graph[index] != null) {
                List<Integer> nodes = graph[index];
                for (Integer node : nodes) {
                    if (dfs(node)) {
                        return true;
                    }
                }
            }
            path[index] = false;
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}