package com.self.leetCodeProblems.easy;

import com.self.leetCodeProblems.resources.ListNode;

// Given the head of a singly linked list, reverse the list and return the reversed list

// definition of a node
// already defined in MergeTwoSortedLists

// thoughts: 
// we iterate through the linked list from the head
// we need a dummy to hold the previous node so we can reference to it
// go to node 1, hold node 1 in dummy, go to node 2, set node 2 next to dummy, hold node 2 in dummy...

// used this site to help:
// https://www.interviewbit.com/blog/reverse-a-linked-list/#:~:text=The%20recursive%20approach%20to%20reverse,part%20by%20maintaining%20the%20connection.
public class ReverseLinkedList206 {

	public static ListNode reverseList(ListNode head) {
		
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
	
		// while we still have nodes
		// this is all one big cycle (next = current.next = prev = current ->-> v
		//                              ^                                       v
		//                              ^-(evaluate while condition)<-<-<-<-<-<-
		while (current != null) {
									// on first loop, current is the first node
			next = current.next;    // next becomes the second node
			current.next = prev;	// current POINTS to prev (initially null)
			prev = current;			// prev becomes the first node (current)
			current = next;			// current becomes next, e.g. the second node that is now POINTING to the first node (see step 1)
									// repeat until we are out of nodes
		}
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		reverseList(head);
	}

}
