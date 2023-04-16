//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 
//
// 👍 761, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import com.quickcode.builder.Builder;
import com.quickcode.debug.Recursion;
import com.quickcode.predicate.Assert;
import com.quickcode.print.Console;

import java.util.LinkedList;
import java.util.List;

/**
 * 课程表 II
 *
 * @author wangsibo
 * @date 2023-04-16 09:29:54
 */
public class CourseScheduleIi_210 {

    private static Solution getSolution() {
        return new CourseScheduleIi_210().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();

        int[] order = solution.findOrder(2, Builder.buildDimensionalIntsArray("[]"));
        Console.log(order);
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 邻接表
        private List<Integer>[] graph = null;


        // 栈，存储当前入度为0的元素
        private int[] queue = null;
        // 入度数组
        private int[] inDegree = null;


        // 遍历的个数
        private int front;
        private int rear;
        // 拓扑排序路径结果

        // 本题可以将path 还有stack 合并成一个数组，栈改成队列，后进先出，用front,rear指向
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses < 0 || prerequisites == null) {
                return new int[0];
            }
            // init
            graph = new List[numCourses];
            inDegree = new int[numCourses];
            if (prerequisites.length != 0){
                for (int[] prerequisite : prerequisites) {
                    if (prerequisite.length==0) {
                        continue;
                    }
                    int to = prerequisite[0];
                    int from = prerequisite[1];
                    // init inDegree
                    inDegree[to]++;

                    // init graph
                    if (graph[from] == null) {
                        graph[from] = new LinkedList<>();
                    }
                    graph[from].add(to);
                }
            }

            // 拓扑排序
            tpSort();

            if (rear < graph.length) {
                return new int[0];
            }

            return queue;
        }

        private void tpSort() {
            // init stack
            queue = new int[graph.length];
            front = 0; // front指向第一个非空元素
            rear = 0;// rear指向空元素

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0){
                    queue[rear++] = i;
                }
            }

            // 栈不空则可以遍历
            while (rear > front) {
                // 入度为0的元素出栈
                int pop = queue[front++];
                // 维护出栈的元素
                List<Integer> list = graph[pop];
                if (list != null) {
                    for (Integer outSideNode : list) {
                        // 如果当前边表节点的入度为0，则可以遍历了，需要添加到队列中
                        if (--inDegree[outSideNode] == 0) {
                            queue[rear++] = outSideNode;
                        }
                    }
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}