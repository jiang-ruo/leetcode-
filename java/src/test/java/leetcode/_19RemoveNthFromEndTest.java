package leetcode;

import leetcode._19RemoveNthFromEnd.ListNode;
import leetcode._19RemoveNthFromEnd.Solution;
import leetcode.test.AbstractTestInfo;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author XiaoLOrange
 * @time 2021.10.02
 * @title
 */

public class _19RemoveNthFromEndTest extends AbstractTestInfo<ListNode> {

	private Solution s = new Solution();

	@Override
	public String RsForPrint(ListNode rs) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(rs != null) {
			sb.append(rs.val);
			rs = rs.next;
			while (rs != null){
				sb.append(", ");
				sb.append(rs.val);
				rs = rs.next;
			}
		}
		sb.append("]");
		return sb.toString();
	}

	@Before
	public void rnfetBefore(){
		super.setIb(new Object[][]{
				{buildLn(1, 2, 3, 4, 5), 2},
				{buildLn(1), 1},
				{buildLn(1, 2), 1}
		});
	}

	private ListNode buildLn(int... nums){
		if(nums.length == 0) return new ListNode();
		ListNode ln = new ListNode(nums[0]);
		ListNode p = ln;
		for (int i = 1; i < nums.length; i++){
			p.next = new ListNode(nums[i]);
			p = p.next;
		}
		return ln;
	}

	@Test
	@SneakyThrows
	public void rnfet(){
		Method m = Solution.class.getMethod("removeNthFromEnd", ListNode.class, int.class);
		super.doMethod(s, m);
	}

	@Test
	@SneakyThrows
	public void rnfet2(){
		Method m = Solution.class.getMethod("removeNthFromEnd2", ListNode.class, int.class);
		super.doMethod(s, m);
	}

}
