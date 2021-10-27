package leetcode._1TwoSum;


import java.util.*;

/**
 * @author XiaoLOrange
 * @time 2021.07.21
 * @title
 *
 */

public class Solution {

	public int[] twoSum(int[] nums, int target) {
		// <数字, 下标队列>
		Map<Integer, List<Integer>> map = new HashMap<>((int) (nums.length / 0.75));
		int total = nums.length;
		List<Integer> list;
		int other;
		int[] rs = new int[2];
		for (int i = 0; i < total; i++){
			// 寻找是否有互补数字;
			other = target - nums[i];
			list = map.get(other);
			if(list != null){
				rs[0] = list.get(0);
				rs[1] = i;
				break;
			}
			// 不存在互补数字
			list = map.get(nums[i]);
			if(list == null){
				list = new ArrayList<>();
				map.put(nums[i], list);
			}
			list.add(i);
		}
		return rs;
	}

	public int[] twoSum2(int[] nums, int target) {
		// <数字, 下标队列>
		Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75));
		int total = nums.length;
		Integer num;
		int other;
		int[] rs = new int[2];
		for (int i = 0; i < total; i++){
			// 寻找是否有互补数字;
			other = target - nums[i];
			num = map.get(other);
			if(num != null){
				rs[0] = num;
				rs[1] = i;
				break;
			}
			// 不存在互补数字
			map.put(nums[i], i);
		}
		return rs;
	}

	/**
	 *
	 * @author liulusheng https://leetcode-cn.com/problems/two-sum/solution/zhi-xing-yong-shi-1ms-by-liulusheng-8q6a/
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum3(int[] nums, int target) {
		int count = nums.length;
		int[] result = new int[2];
		// 采用hash表来优化解答
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < count; i++) {
			if(hash.containsKey(nums[i])){
				result[0] = hash.get(nums[i]);
				result[1] = i;
				return result;
			}
			// 否则将数据存入hash表中，key为target与nums[i]的补数，value为下标i
			hash.put(target - nums[i], i);
		}
		return result;
	}


}
