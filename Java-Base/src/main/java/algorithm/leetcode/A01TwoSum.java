package algorithm.leetcode;

/**
 * @Author weimenghua
 * @Date 2022-03-06 16:26
 * @Description 给定一个整数数组 nums 和一个目标值 target，在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class A01TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 6;
        int[] tmp = A01TwoSum.twoSum(nums, target);

        for (int i = 0; i < tmp.length; i++) {
            System.out.printf("下标%d",  tmp[i]);
        }
    }

    //方法一
    public static int[] twoSum(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }
}
