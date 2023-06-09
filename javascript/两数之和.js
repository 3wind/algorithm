/**
 * @ title: Day1
 * @ description:
 * @ author WangXin
 * @ date 2023/5/8 10:09
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */


/**
 * 思路
 * 使用value做key，index做value存一个map，每次判断map中是否存在和为target的值
 *
 */
function twoSum(nums, target) {
    if(!nums || nums.length === 0) {
        return null
    }
    const m = new Map()
    for (let i = 0; i < nums.length; i++) {
        if(m.has(target - nums[i])) {
            return [i, m.get(target - nums[i])]
        } else {
            m.set(nums[i], i)
        }
    }
    return null

}

console.log(twoSum([2,7,11,15], 9))
