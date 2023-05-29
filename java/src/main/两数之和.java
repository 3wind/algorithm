import java.util.Arrays;
import java.util.HashMap;

/**
 * @ title: Day1
 * @ author WangXin
 * @ date 2023/5/8 10:09
 * @ description:
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class 两数之和 {
    public static void main( String[] args ) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }

    /**
     * 思路
     * 使用value做key，index做value存一个map，每次判断map中是否存在和为target的值
     *
     */
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(target - nums[i])) {
                return new int[]{i, m.get(target - nums[i])};
            } else {
                m.put(nums[i], i);
            }
        }
        return null;

    }
}
