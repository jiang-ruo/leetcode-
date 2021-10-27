package leetcode._19RemoveNthFromEnd;

/**
 * @author XiaoLOrange
 * @time 2021.10.02
 * @title
 */

public class Solution {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 距离当前正在遍历的节点距离为n的节点
		ListNode pointer = null;
		ListNode ln = head;
		int i = 0;
		while (ln != null){
			ln = ln.next;
			if(i++ >= n) pointer = pointer == null ? head : pointer.next;
		}
		// 删除第一个节点
		if(i == n) return head.next;
		// 删除最后一个节点
		if(n == 1) {
			pointer.next = null;
		}else{
			pointer.next = pointer.next.next;
		}
		return head;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		// 距离当前正在遍历的节点距离为n的节点
		ListNode pointer = null;
		ListNode ln = head;
		int i = 0;
		while (ln != null){
			ln = ln.next;
			if(i++ >= n) pointer = pointer == null ? head : pointer.next;
		}

		// 删除第一个节点
		if(i == n) return head.next;
		// 删除最后一个节点
		if(n == 1) {
			pointer.next = null;
		}else{
			pointer.next = pointer.next.next;
		}
		return head;
	}

}
