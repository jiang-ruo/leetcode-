package leetcode._16ThreeSumClosest;

import java.util.Arrays;

/**
 * @author XiaoLOrange
 * @time 2021.09.26
 * @title
 *
 */

public class Solution {

	/**
	 * 普通遍历
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
//		Arrays.sort(nums);
		int size = nums.length;
		int min = Integer.MAX_VALUE;
		int rs = 0, t1, t2;
		for (int l = 0; l < size - 2; l++){
			for (int i = l + 1; i < size - 1; i++){
				for (int r = i + 1; r < size; r++){
					t1 = nums[l] + nums[i] + nums[r];
					if((t2 = Math.abs(t1 - target)) < min){
						rs = t1;
						min = t2;
					}
				}
			}
		}
		return rs;
	}

	/**
	 * {@link #threeSumClosest(int[], int)} 优化
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest2(int[] nums, int target) {
		Arrays.sort(nums);
		int size = nums.length;
		int min = Integer.MAX_VALUE;
		int rs = 0, t1, t2;
		for (int l = 0; l < size - 2; l++){
			for (int i = l + 1; i < size - 1; i++){
				for (int r = i + 1; r < size; r++){
					t1 = nums[l] + nums[i] + nums[r];
					t2 = t1 - target;
					// t2 > min, r继续右移t2只会更大，直接break;
					if(t2 > min) break;
					if((t2 = Math.abs(t2)) < min){
						rs = t1;
						min = t2;
					}
				}
			}
		}
		return rs;
	}

	/**
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest3(int[] nums, int target) {
		Arrays.sort(nums);
		int size = nums.length - 1;
		int rs = nums[0] + nums[1] + nums[2];
		for (int i = 0; i <= size; i++){
			int l = i + 1, r = size;
			while (l < r){
				int sum = nums[i] + nums[l] + nums[r];
				if(Math.abs(sum - target) < Math.abs(rs - target)) rs = sum;
				if(sum > target) {
					while (r > l && nums[r] == nums[r - 1]) r--;
					r--;
				}else {
					while (l < r && nums[l] == nums[l + 1]) l++;
					l++;
				}
			}
		}
		return rs;
	}

}
