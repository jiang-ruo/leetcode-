package leetcode;

import leetcode._2AddTwoNumbers.ListNode;
import leetcode._2AddTwoNumbers.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author XiaoLOrange
 * @time 2021.07.21
 * @title
 */

public class _2AddTwoNumbersTest implements TestInfo<ListNode> {

	private int testNum = 1000;

	@Test
	@SneakyThrows
	public void atnt(){
		Random r = new Random();
		long num1 = 9;
//		int num1 = r.nextInt(Integer.MAX_VALUE / 2);
		long n1 = num1;
		long num2 = 9999999991L;
//		int num2 = r.nextInt(Integer.MAX_VALUE / 2);
		long n2 = num2;
		ListNode l1 = new ListNode((int) (num1 % 10));
		ListNode pointer = l1;
		num1 /= 10;
		while(num1 > 0){
			pointer.next = new ListNode((int) (num1 % 10));
			num1 /= 10;
			pointer = pointer.next;
		}
		ListNode l2 = new ListNode((int) (num2 % 10));
		pointer = l2;
		num2 /= 10;
		while(num2 > 0){
			pointer.next = new ListNode((int) (num2 % 10));
			num2 /= 10;
			pointer = pointer.next;
		}

		long time = 0, t1, t2, memory = 0, m1, m2;
		Runtime rt = Runtime.getRuntime();
		Solution atn = new Solution();
		ListNode rs = null;
		rt.gc();
		for (int i = 0; i < testNum; i++){
			m1 = rt.freeMemory();
			t1 = System.nanoTime();
			// TODO func
			rs = atn.addTwoNumbers(l1, l2);

			t2 = System.nanoTime();
			m2 = rt.freeMemory();
			time += (t2 - t1);
			memory += (m1 - m2);
		}
		print(n1, n2, rs);
		System.out.println(time / testNum);
		System.out.println(memory / testNum);

		time = 0;
		memory = 0;
		atn = new Solution();
		rt.gc();
		for (int i = 0; i < testNum; i++){
			m1 = rt.freeMemory();
			t1 = System.nanoTime();
			// TODO func
			rs = atn.addTwoNumbers2(l1, l2);

			t2 = System.nanoTime();
			m2 = rt.freeMemory();
			time += (t2 - t1);
			memory += (m1 - m2);
		}
		print(n1, n2, rs);
		System.out.println(time / testNum);
		System.out.println(memory / testNum);

		Method method = Solution.class.getDeclaredMethod("addTwoNumbers", ListNode.class, ListNode.class);
		StatisTest st = new StatisTest(this);
//		st.doMethod(testNum, new Solution(), method, l1, l2);
	}

	public void print(long num1, long num2, ListNode rs){
		System.out.print(num1);
		System.out.print(" + ");
		System.out.print(num2);
		System.out.print(" = ");
		List<Integer> ns = new ArrayList<>();
		while (rs != null){
			ns.add(rs.val);
			rs = rs.next;
		}
		int size = ns.size();
		for (int i = size - 1; i >= 0; i--){
			System.out.print(ns.get(i));
		}
		System.out.println();
	}

	@Override
	public boolean verify(Object[] params, ListNode rs) {
		return true;
	}

	@Override
	public Object[] buildParams() {
		return null;
	}

	@Override
	public void print(Object[] params, ListNode rs) {
		System.out.println("result");
	}
}