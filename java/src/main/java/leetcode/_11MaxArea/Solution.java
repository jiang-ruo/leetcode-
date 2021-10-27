package leetcode._11MaxArea;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 *
 */

public class Solution {

	/**
	 *
	 * (x - y) * min(ax, ay)
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int[] p = {0, 0};
		int tmp, rs = 0, size = height.length;
		for (int i = 0; i < size; i++){
			for (int j = i + 1; j < size; j++){
				tmp = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
				if(tmp > rs) rs = tmp;
			}
		}
		return rs;
	}

	/**
	 * https://leetcode-cn.com/problems/container-with-most-water/comments/5175
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
		int i = 0, j = height.length - 1;
		int tmp, rs = 0;
		while(i < j){
			int h = height[i] < height[j] ? height[i++] : height[j--];
			tmp = (j - i + 1) * h;
			if(tmp > rs) rs = tmp;
		}
		return rs;
	}

	/**
	 * {@link Solution#maxArea2(int[])} 稍微优化
	 * @param height
	 * @return
	 */
	public int maxArea3(int[] height) {
		int i = 0, j = height.length - 1;
		int tmp, rs = 0, mark = 0;
		while(i < j){
			int h = height[i] < height[j] ? height[i++] : height[j--];
			if(h <= mark) continue;
			tmp = (j - i + 1) * h;
			if(tmp > rs) rs = tmp;
		}
		return rs;
	}

}
