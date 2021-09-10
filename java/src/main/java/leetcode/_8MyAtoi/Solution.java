package leetcode._8MyAtoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XiaoLOrange
 * @time 2021.09.10
 * @title
 */

public class Solution {

	/**
	 * 最简便方法
	 * @param s
	 * @return
	 */
	public int myAtoi(String s) {
		if(s == null) return 0;
		Pattern p = Pattern.compile("^\\s*(-|\\+?)(\\d+)");
		Matcher m = p.matcher(s);
		if(m.find()){
			try {
				return Integer.valueOf(m.group(1) + m.group(2));
			}catch (NumberFormatException e){
				return "-".equals(m.group(1)) ? -2147483648 : 2147483647;
			}
		}
		return 0;
	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public int myAtoi2(String s){
		if(s == null) return 0;
		byte[] bs = s.getBytes();
		long rs = 0;
		boolean negative = false;
		int i = 0, size = bs.length;
		for (;i < size; i++){
			if(bs[i] == 32) continue;
			if(bs[i] == 45 || bs[i] == 43) {
				if(bs[i] == 45) negative = true;
				i++;
			}
			break;
		}
		for (; i < size; i++){
			if(bs[i] >= 48 && bs[i] <= 57){
				rs *= 10;
				rs += (bs[i] - 48);
				if(rs >= 2147483648L) return negative ? -2147483648 : 2147483647;
			}else break;
		}
		if(negative) rs = -rs;
		return (int) rs;
	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public int myAtoi3(String s){
		if(s == null) return 0;
		long rs = 0;
		Boolean negative = null;
		int size = s.length();
		byte c;
		for (int i = 0;i < size; i++){
			c = (byte) s.charAt(i);
			if(negative == null){
				if(c == 32) continue;
				if(negative = c == 45) continue;
				if(c != 43) i--;
			}else{
				if(c < 48 || c > 57) break;
				rs *= 10;
				rs += (c - 48);
				if(rs >= 2147483648L) return negative ? -2147483648 : 2147483647;
			}
		}
		if(negative == null || negative) rs = -rs;
		return (int) rs;
	}

	/**
	 * 与{@link Solution#myAtoi3(String)} 相比，修改了一个变量类型，提高了0.4M内存，(leetcode中）
	 * @param s
	 * @return
	 */
	public int myAtoi4(String s){
		if(s == null) return 0;
		long rs = 0;
		Boolean negative = null;
		int size = s.length();
		char c;
		for (int i = 0;i < size; i++){
			c = s.charAt(i);
			if(negative == null){
				if(c == 32) continue;
				if(negative = c == 45) continue;
				if(c != 43) i--;
			}else{
				if(c < 48 || c > 57) break;
				rs *= 10;
				rs += (c - 48);
				if(rs >= 2147483648L) return negative ? -2147483648 : 2147483647;
			}
		}
		if(negative == null || negative) rs = -rs;
		return (int) rs;
	}

}
