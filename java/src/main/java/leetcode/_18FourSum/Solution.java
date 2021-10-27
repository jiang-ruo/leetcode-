package leetcode._18FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XiaoLOrange
 * @time 2021.10.01
 * @title
 */

public class Solution {

	/**
	 * 暴力遍历，估计会超时，没有提交
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> lli = new ArrayList<>();
		int size = nums.length;
		for (int i = 0; i < size - 3; i++){
			// 与上次数字相同则跳过
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < size - 2; j++){
				// 与上次数字相同则跳过
				if(j > i + 1 && nums[j] == nums[j - 1]) continue;
				for (int x = j + 1; x < size - 1; x++){
					// 与上次数字相同则跳过
					if(x > j + 1 && nums[x] == nums[x - 1]) continue;
					for (int y = x + 1; y < size; y++){
						// 与上次数字相同则跳过
						if(y > x + 1 && nums[y] == nums[y - 1]) continue;
						if(nums[i] + nums[j] + nums[x] + nums[y] == target){
							List<Integer> li = new ArrayList<>();
							li.add(nums[i]);
							li.add(nums[j]);
							li.add(nums[x]);
							li.add(nums[y]);
							lli.add(li);
						}
					}
				}
			}
		}
		return lli;
	}

	/**
	 * 四个指针
	 * 双重循环，第一重以i为基准，第二重以j为基准
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		int size = nums.length - 1;
		Arrays.sort(nums);
		for (int i = 0; i <= size - 3; i++){
			// 与上次数字相同则跳过
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j <= size - 2; j++){
				// 与上次数字相同则跳过
				if(j > i + 1 && nums[j] == nums[j - 1]) continue;
				//
				int r = size;
				for (int l = j + 1; l < r; l++){
					// 与上次数字相同则跳过
					if(l > j + 1 && nums[l] == nums[l - 1]) continue;
					while (l < r && nums[i] + nums[j] + nums[l] + nums[r] > target) r--;
					if(l == r) break;
					if(nums[i] + nums[j] + nums[l] + nums[r] == target) list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
				}
			}
		}
		return list;
	}

}
