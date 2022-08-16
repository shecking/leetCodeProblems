package com.self.leetCodeProblems.easy;

import java.util.ArrayList;
import java.util.List;

import com.self.leetCodeProblems.resources.Node;

// Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
// Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value. (used for submission)

/* Preorder traversal (depth first algorithm):
 * 		Visit root first
 * 		Then left subtree
 * 		Then right subtree
 */

public class NaryTreePreOrder589 {
	
	static List<Integer> nodeList = new ArrayList<>(); // removed static for submission
	
	public static List<Integer> preorder(Node root) { // removed static for submission
		
		if (root == null) { return nodeList; }
		
		nodeList.add(root.val);
		
		for (Node n : root.children) {
			preorder(n);
		}
		
		return nodeList;
	}

	// driver/creating data
	public static void main(String[] args) {
		
		Node node1 = new Node(1, new ArrayList<>());
		Node node2 = new Node(2, new ArrayList<>());
		Node node3 = new Node(3, new ArrayList<>());
		Node node4 = new Node(4, new ArrayList<>());
		Node node5 = new Node(5, new ArrayList<>());
		Node node6 = new Node(6, new ArrayList<>());
		Node node7 = new Node(7, new ArrayList<>());
		Node node8 = new Node(8, new ArrayList<>());
		Node node9 = new Node(9, new ArrayList<>());
		Node node10 = new Node(10, new ArrayList<>());
		Node node11 = new Node(11, new ArrayList<>());
		Node node12 = new Node(12, new ArrayList<>());
		Node node13 = new Node(13, new ArrayList<>());
		Node node14 = new Node(14, new ArrayList<>());
		
		node1.children.add(node2); node1.children.add(node3); node1.children.add(node4); node1.children.add(node5);
		node3.children.add(node6); node3.children.add(node7);
		node4.children.add(node8);
		node5.children.add(node9); node5.children.add(node10);
		node7.children.add(node11);
		node8.children.add(node12);
		node9.children.add(node13);
		node11.children.add(node14);
		
		preorder(node1);
		System.out.println(nodeList);
		
	}

}
