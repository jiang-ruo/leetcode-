package leetcode._11MaxArea;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 * @url https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 例：
 * ![img] (leetcode._11MaxArea.jpg)
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
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
