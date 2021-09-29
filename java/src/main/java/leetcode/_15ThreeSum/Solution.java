package leetcode._15ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XiaoLOrange
 * @time 2021.09.24
 * @title
 * @url https://leetcode-cn.com/problems/3sum
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例：
 * 来源：力扣（LeetCode）输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */

public class Solution {

	/**
	 * 双指针法，left i right
	 * 1、left i向右移动
	 * 2、right向左移动
	 * 3、left o right移动时碰到和自己相同的数字则继续移动
	 * 4、left < right， left < i < right
	 * 参考了{@link #threeSum2(int[])}
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rs = new ArrayList<>();
		Arrays.sort(nums);
		int size = nums.length;
		for (int l = 0; l < size; l++){
			// 需要和上一次枚举的数不相同
			if (l > 0 && nums[l] == nums[l - 1]) continue;
			int r = size - 1;
			for (int i = l + 1; i < r; i++){
				// 需要和上一次枚举的数不相同
				if (i > l + 1 && nums[i] == nums[i - 1]) continue;
				while (i < r && nums[l] + nums[i] + nums[r] > 0) r--;
				if(i == r) break;
				if(nums[l] + nums[i] + nums[r] == 0) rs.add(Arrays.asList(nums[l], nums[i], nums[r]));
			}
		}
		return rs;
	}

	/**
	 * 作者：gu-xx-qi
	 * 链接：https://leetcode-cn.com/problems/3sum/solution/si-wei-dao-tu-zheng-li-san-shu-zhi-he-xi-uya0/
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum2(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums); //将数组进行排序
		List<List<Integer>> ans = new ArrayList<List<Integer>>(); //元素为整型链表的数组链表
		// 枚举 a
		for (int first = 0; first < n; ++first) {
			// 需要和上一次枚举的数不相同
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// c 对应的指针初始指向数组的最右端
			int third = n - 1;
			int target = -nums[first];
			// 枚举 b
			for (int second = first + 1; second < n; ++second) {
				// 需要和上一次枚举的数不相同
				if (second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// 需要保证 b 的指针在 c 的指针的左侧
				while (second < third && nums[second] + nums[third] > target) {
					--third;
				}
				if (second == third) { // 如果指针重合,后续也不会满足条件,可以退出循环
					break;
				}
				if (nums[second] + nums[third] == target) {
					ans.add(Arrays.asList(nums[first],nums[second],nums[third]));
				}
			}
		}
		return ans;
	}

}
