package leetcode._8MyAtoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XiaoLOrange
 * @time 2021.09.10
 * @title
 * @url https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 例：
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 *              ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
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
		// 在标记正负号的同时，用于标记是否在前导空格/符号阶段
		Boolean negative = null;
		int size = s.length();
		byte c;
		for (int i = 0;i < size; i++){
			c = (byte) s.charAt(i);
			if(negative == null){
				// 去除前导空格及符号
				if(c == 32) continue;
				if(negative = c == 45) continue;
				if(c != 43) i--;
			}else{
				if(c < 48 || c > 57) break;
				// 数字累加
				rs *= 10;
				rs += (c - 48);
				// 越界判断
				if(rs >= 2147483648L) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
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
