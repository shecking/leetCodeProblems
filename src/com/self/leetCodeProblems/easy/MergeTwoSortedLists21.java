package com.self.leetCodeProblems.easy;

import com.self.leetCodeProblems.resources.ListNode;

/* You are given the heads of two sorted linked lists, list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list. */
	
public class MergeTwoSortedLists21 {
	
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		ListNode placeholder = new ListNode(-1);
		ListNode mergedList = placeholder;
		// placeholder is just a dummy for the final mergedList
		
// 		// ORIGINALLY HAD THIS
//		// while we still have items in either list
//		while (head1 != null && head2 != null) {
//			
//			if (head1.value >= head2.value) {
//				mergedList.value = head1.value;
//				head1 = head1.next;
//			} else {
//				mergedList.value = head2.value;
//				head2 = head2.next;
//			}
//		}
		
		// BUT THIS IS RIGHT
		while (list1 != null && list2 != null) {
			// if the value in list 1 is smaller or equal
			if (list1.value <= list2.value) {
				// make the next thing in the big list the value of head1
				placeholder.next = new ListNode(list1.value);
				// move the head forward
				list1 = list1.next;
			} 
			// if the value in list 2 is smaller
			else {
				placeholder.next = new ListNode(list2.value);
				list2 = list2.next;
			}
			// move the merged list forward
			placeholder = placeholder.next;
		}
		// make the final head of the merged list
		placeholder.next = (list1 == null) ? list2 : list1;
		return mergedList.next;
	}

	// driver
	public static void main(String[] args) {
		
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		
		mergeTwoLists(list1, list2);

	}
}
