//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 👍 616 👎 0


package leetcode.editor.cn;

public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
//        int nums[] = {2, 3, 1, 0, 2, 5, 3};
        int nums[] = {1, 1, 1};
        int repeatNumber = solution.findRepeatNumber(nums);
        System.out.println(repeatNumber);
        /*
        * 时间复杂度
        * */
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (i != nums[i]) {
                    if (nums[i] != nums[nums[i]]) {
                        swap(nums, i, nums[i]);
                    } else {
                        return nums[i];
                    }
                }
            }
            return -1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}