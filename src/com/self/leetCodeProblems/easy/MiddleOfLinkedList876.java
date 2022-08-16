package com.self.leetCodeProblems.easy;

// Given the head of a singly linked List, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.
// Ex. Input: head = [1, 2, 3, 4, 5] -----> Output: [3, 4, 5]
// Ex. Input: head = [1, 2, 3, 4, 5, 6] -----> Output: [4, 5, 6]

import java.util.HashMap;
import com.self.leetCodeProblems.resources.ListNode;

public class MiddleOfLinkedList876 {

	public static ListNode middleNode(ListNode head) {
		
		// create a hash map to store ints paired with nodes
		HashMap<Integer, ListNode> nodeMap = new HashMap<>();
		
		int count = 0;
		// loop through nodes
		while (head != null) {
			
			count++;
			nodeMap.put(count, head); // add to map
			head = head.next;
		}
		
		if (count % 2 == 0) { // if even
			// get the value with key of (count/2) + 1
			System.out.println(nodeMap.get((count/2) + 1).value);
			return nodeMap.get((count/2) + 1);
		} 
		else { // if odd
			// get the map item that has a key of (count+1) / 2
			System.out.println(nodeMap.get((count+1) / 2).value);
			return nodeMap.get((count+1) / 2);
		}

	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		middleNode(head);
	}
	
}
