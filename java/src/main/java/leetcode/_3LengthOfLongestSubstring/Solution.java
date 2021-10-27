package leetcode._3LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaoLOrange
 * @time 2021.07.22
 * @title
 *
 */

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		byte[] bs = s.getBytes();
		// <字母，下标> - 当下标>pointer时，出现重复
		Map<Byte, Integer> map = new HashMap<>();
		// max 最长的不重复字母
		// size 当前的不重复字母长度
		// pointer 上一次出现重复的位置
		int max = 0, size = 0, pointer = 0, length = bs.length;
		Integer index;
		for (int i = 0; i < length; i++){
			index = map.get(bs[i]);
			if(index == null || index < pointer) {
				map.put(bs[i], i);
				size++;
			}else{
				// 出现重复
				if(size > max) max = size;
				size = (i - index);
				map.put(bs[i], i);
				pointer = index;
			}
		}
		return max > size ? max : size;
	}

	/**
	 * @author VioletKiss https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/javati-jie-3wu-zhong-fu-zi-fu-de-zui-chang-zi-chua/
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {
		int pointer = 0, length = s.length(), size = 0, rs = 0;
		for(int i = 0; i < length; i++){
			int pos = s.indexOf(s.charAt(i), pointer);
			if(pos < i){
				if(size > rs) rs = size;
				if(rs >= length - pos - 1) return rs;
				size = i - pos - 1;
				pointer = pos + 1;
			}
			size++;
		}
		return size;
	}

}
