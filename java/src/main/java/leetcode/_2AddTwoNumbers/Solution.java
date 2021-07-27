package leetcode._2AddTwoNumbers;

/**
 * @author XiaoLOrange
 * @time 2021.07.21
 * @title
 */

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int count = 0, num1, num2;
		ListNode rs = null, pointer = null;
		while(l1 != null || l2 != null){
			if(rs == null){
				num1 = l1.val;
				num2 = l2.val;
				count = num1 + num2;
				rs = new ListNode(count % 10);
				pointer = rs;
				count /= 10;
				l1 = l1.next;
				l2 = l2.next;
			}else{
				if(l1 != null) {
					num1 = l1.val;
					l1 = l1.next;
				}else num1 = 0;
				if(l2 != null) {
					num2 = l2.val;
					l2 = l2.next;
				}else num2 = 0;
				count += (num1 + num2);
				pointer.next = new ListNode(count % 10);
				pointer = pointer.next;
				count /= 10;
			}
		}
		if(count != 0) pointer.next = new ListNode(count);
		return rs;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		int count = 0, num1, num2;
		ListNode rs = new ListNode(), pointer = rs;
		while(l1 != null || l2 != null){
				if(l1 != null) {
					num1 = l1.val;
					l1 = l1.next;
				}else num1 = 0;
				if(l2 != null) {
					num2 = l2.val;
					l2 = l2.next;
				}else num2 = 0;

				count += (num1 + num2);
				pointer.next = new ListNode(count % 10);
				pointer = pointer.next;
				count /= 10;
		}
		if(count != 0) pointer.next = new ListNode(count);
		return rs.next;
	}

	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		int count = 0;
		ListNode rs = new ListNode(), pointer = rs;
		while(l1 != null || l2 != null || count != 0){
				if(l1 != null) {
					count += l1.val;
					l1 = l1.next;
				}
				if(l2 != null) {
					count += l2.val;
					l2 = l2.next;
				}

				pointer.next = new ListNode(count % 10);
				pointer = pointer.next;
				count /= 10;
		}
		return rs.next;
	}

}
