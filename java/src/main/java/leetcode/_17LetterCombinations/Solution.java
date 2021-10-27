package leetcode._17LetterCombinations;

import java.util.*;

/**
 * @author XiaoLOrange
 * @time 2021.09.28
 * @title
 *
 */

public class Solution {

	private Map<Integer, String[]> keyMap = new HashMap<>();

	public Solution(){
		// 50, 97 - 99
		keyMap.put(2, new String[]{"a", "b", "c"});
		// 51, 100 - 102
		keyMap.put(3, new String[]{"d", "e", "f"});
		// 52, 103 - 105
		keyMap.put(4, new String[]{"g", "h", "i"});
		// 53, 106 - 108
		keyMap.put(5, new String[]{"j", "k", "l"});
		// 54, 109 - 111
		keyMap.put(6, new String[]{"m", "n", "o"});
		// 55, 112 - 115
		keyMap.put(7, new String[]{"p", "q", "r", "s"});
		// 56, 116 - 118
		keyMap.put(8, new String[]{"t", "u", "v"});
		// 57, 119 - 122
		keyMap.put(9, new String[]{"w", "x", "y", "z"});
	}

	public List<String> letterCombinations(String digits) {
		int size = digits.length();
		List<String> ls = new ArrayList<>();
		if(size == 0) return ls;

		char[] ds = digits.toCharArray();
		for (char c: ds){
			ls = concat(ls, Arrays.asList(keyMap.get(c - 48)));
		}

		return ls;
	}

	/**
	 * 组合两个集合中的元素
	 * @return
	 */
	private List<String> concat(List<String> l1, List<String> l2){
		int s1 = l1.size(), s2 = l2.size();
		if(s1 == 0) return l2;
		if(s2 == 0) return l1;
		List<String> rs = new ArrayList<>(s1 * s2);
		for (int i = 0; i < s1; i++){
			for (int j = 0; j < s2; j++){
				rs.add(l1.get(i) + l2.get(j));
			}
		}
		return rs;
	}

	public List<String> letterCombinations2(String digits) {
		int size = digits.length();
		LinkedList<String> ls = new LinkedList<>();
		if(size == 0) return ls;

		char[] ds = digits.toCharArray();
		ls.add("");
		for (char c: ds){
			int l = ls.size();
			for (int i = 0; i < l; i++){
				String s = ls.poll();
				for (String cs: keyMap.get(c - 48)){
					ls.offer(s + cs);
				}
			}
		}

		return ls;
	}

	public List<String> letterCombinations3(String digits) {
		int size = digits.length();
		List<String> ls = new ArrayList<>();
		if(size == 0) return ls;

		char[] ds = digits.toCharArray();
		ls.add("");
		for (char c: ds){
			int l = ls.size();
			for (int i = 0; i < l; i++){
				String s = ls.get(0);
				ls.remove(0);
				for (String cs: keyMap.get(c - 48)){
					ls.add(s + cs);
				}
			}
		}

		return ls;
	}
}
