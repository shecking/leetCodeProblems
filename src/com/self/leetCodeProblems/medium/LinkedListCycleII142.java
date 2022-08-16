package com.self.leetCodeProblems.medium;

import java.util.HashSet;
import java.util.Set;

import com.self.leetCodeProblems.resources.ListNode;

/* Given the head of a linked list, return the node where the cycle begins.
/* If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * 		Internally, pos is used to denote the index of the node that tail's next pointer is 		connected to (0-indexed).
 * 		It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * DO NOT modify the linked list.
 */

public class LinkedListCycleII142 {
	// how can we track if we hit the same node/if we've visited it before?
	// remember to return the node where the cycle begins or -1
	// can this be solved with O(1) memory? not using an additional data structure?
	
	public static ListNode detectCycle(ListNode head) {
		
		Set<ListNode> nodes = new HashSet<>();
		
		while (head != null) {
			if (!nodes.add(head)) {
				System.out.println(head.value);
				return head;
			}
			else {
				nodes.add(head);
				head = head.next;
			}
		}
		System.out.println(-1);
		return null;
	}
	
	
	public static ListNode detectCycleBetter(ListNode head) {
		
		if (head == null || head.next == null) {
			System.out.println("null");
			return null; // automatic no cycle detected
		}
		
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		
		// while fast and fast.next not null AND slow is not fast
		// this loops until the end is found OR fast catches slow (meaning a cycle exists)
		while (fast != null && fast.next != null && slow != fast) {
			// move the fast pointer twice as fast as the slow pointer
			// if there is a loop they'll eventually meet
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast==null || fast.next==null) { // this means fast reached the end, no cycle
			System.out.println("null");
			return null; 
		}
		slow = head; // reset slow to head
		
		while (slow != fast) { 
			// increment both pointers to find the node where the cycle begins
			slow = slow.next;
			fast = fast.next;
			// they will meet eventually due to the nature of the first while loop
			// not entirely clear WHY this works/adds up exactly every time
		}
		
		System.out.println(slow.value);
		return slow;
	}
	

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

		// detectCycle(head);
		detectCycleBetter(head);
	}

}
