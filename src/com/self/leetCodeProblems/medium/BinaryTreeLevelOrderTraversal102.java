package com.self.leetCodeProblems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given the root of a binary tree, return the level order traversal of its nodes' values. (left to right, level by level)

/* Level Order Traversal (breadth first algorithm):
 * How does this differ from Preorder?
 * Level by level instead of down all the way left and right
 */


// used solution on site to complete
public class BinaryTreeLevelOrderTraversal102 {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		// final list/result that we return
		List<List<Integer>> finalList = new ArrayList<>();
		
		if (root == null) { return finalList; }
		
		// what is going on here
		// we are creating a queue to store an ordered list of TreeNodes, pulling left and right
		// adding root to start off the queue
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) { // while queue has items(TreeNodes)
			
			int levelSize = queue.size(); // getting the size of the level we're on
			
			List<Integer> levelGroup = new ArrayList<>(); // list for storing the values of the nodes on the current level
			
			for (int i = 0; i < levelSize; i++) { // for each thing we've added
				
				TreeNode current = queue.poll(); // taking the top thing off the queue
				levelGroup.add(current.val);
				
				// adding left and right nodes, which will add up to the next levelSize
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
			finalList.add(levelGroup);
			
		}
		
		System.out.println("finalList: " + finalList.toString());
		return finalList;
	}
	
	// defining a TreeNode (taken OUT of TreeNode resource for this problem)
	public static class TreeNode {
		// fields
		int val;
		TreeNode left;
		TreeNode right;
		
		// constructors
		public TreeNode() {}
		
		public TreeNode(int val) {
			this.val = val;
		}
		
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static TreeNode createBinaryTree() {
		
//		TreeNode rootNode3 = new TreeNode(3);
//		TreeNode node9 = new TreeNode(9);
//		TreeNode node20 = new TreeNode(20);
//		TreeNode node15 = new TreeNode(15);
//		TreeNode node7 = new TreeNode(7);
//		
//		rootNode3.left = node9;
//		rootNode3.right = node20;
//		node20.left = node15;
//		node20.right = node7;
//		
//		return rootNode3;
		
		TreeNode rootNode1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		rootNode1.left = node2;
		rootNode1.right = node3;
		node2.left = node4;
		node3.right = node5;
		
		return rootNode1;
		
	}
	

	public static void main(String[] args) {
		
		TreeNode rootNode = createBinaryTree();
		
		BinaryTreeLevelOrderTraversal102 binary = new BinaryTreeLevelOrderTraversal102();
		binary.levelOrder(rootNode);
	}

}
