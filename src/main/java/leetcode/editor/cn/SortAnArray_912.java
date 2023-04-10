//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics数组 | 分治 | 桶排序 | 计数排序 | 基数排序 | 排序 | 堆（优先队列） | 归并排序 
//
// 👍 820, 👎 0 
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
 * 排序数组
 *
 * @author wangsibo
 * @date 2023-04-08 22:34:44
 */
public class SortAnArray_912 {

    private static Solution getSolution() {
        return new SortAnArray_912().new Solution();
    }

    private static Recursion getRecursion() {
        return Recursion.getInstance();
    }

    public static void main(String[] args) {
        Solution solution = getSolution();

        int[] ints = solution.sortArray(Builder.buildInt(5,1,1,2,0,0));
        Console.log(ints);
        Assert.checkEqual();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums == null) {
                return null;
            }
            tmp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        int tmp[] = null;

        private void sort(int[] nums, int low, int high) {
            // 这样写可以防止越界
            if (low < high){
                int mid = low + (high - low) / 2;
                sort(nums, low, mid);
                sort(nums, mid + 1, high);
                merge(nums, low, mid, mid + 1, high);
            }
        }

        private void merge(int[] nums, int low1, int high1, int low2, int high2) {
            if (low1 < 0 || high2 >= nums.length) {
                return;
            }
            int i = low1, j = low2, k = low1;
            // 将待排序数据拷贝到临时区域
            for (int t = low1; t <= high2; t++) {
                tmp[t] = nums[t];
            }
            // 开始对前后进行排序
            for (; k <= high2; k++) {
                if (i > high1 || j > high2){
                    break;
                }
                if (tmp[i] <= tmp[j]) {
                    nums[k] = tmp[i++];
                } else {
                    nums[k] = tmp[j++];
                }
            }
            while (i <= high1){
                nums[k++] = tmp[i++];
            }
            while (j <= high2){
                nums[k++] = tmp[j++];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}