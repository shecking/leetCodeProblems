package com.self.leetCodeProblems.easy;

/* Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: 
 * 	“The lowest common ancestor is defined 
 * 		1. between two nodes p and q 
 * 		2. as the lowest node in T (the tree)
 * 		3. that has both p and q as descendants, 
 * 		4. where we allow a node to be a descendant of itself.”
 * All TreeNode.val values are unique
 * p != q, p and q guaranteed to exist in the tree, unknown/doesn't matter if p or q is greater
 */

public class LCABinarySearchTree235 {
	// defining node
	static class TreeNode {
		
		// fields
		int val;
		TreeNode left;
		TreeNode right;
		
		// constructors
		public TreeNode(int x) {
			val = x;
		}
		
		public TreeNode(int x, TreeNode l, TreeNode r) {
			this.val = x;
			this.left = l;
			this.right = r;
		}
	}
	
	/* first try thinking: 
	 * search tree for both nodes (by definition, root is guaranteed to eventually lead to both p and q) 
	 * if we find one, record what level it's on, then find the other
	 * walk up the deeper level until levels match (can we even do this?)
	 * check for equivalence; if the same return that node, if not go up a level
	 * if root, return root
	*/
	
	/* second try:
	 * if we can't reaccess parent nodes, how will we determine where to go?
	 * storing the nodes in a list seems redundant, but what other way is there?
	 * inorder traversal: 
	 * 		left, root, right (depth first algorithm)
	 * 		recursion is necessary
	 * 		it prints nodes in the sorted order
	 */
	
	/* third try:
	 * why can't we use level order traversal we made earlier
	 * how we know what parents match up with what children?
	 * some sort of while loop to look for the nodes
	 * do the recursive steps do the storing for us?
	 */
	
	/* fourth try with help:
	 * the definition of a binary search tree: 
	 * 		The tree is already sorted
	 * 		The value of every node is greater than every node in its left subtree AND smaller than every node in its right subtree
	 * 		By definition, all nodes in a BST have a distinct value from the others
	 * we are given two nodes and have to return the first node they both lead back to
	 * a while loop is the iterative version of recursion
	 * turns out no tree traversal in any order was needed
	 */
	
	public TreeNode lcaRecursive(TreeNode root, TreeNode p, TreeNode q) {
		
		if (root.val > p.val && root.val > q.val) {
			return lcaRecursive(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lcaRecursive(root.right, p, q);
		} else {
			System.out.println(root.val);
			return root;
		}
	}
	
	public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {
		// we aren't reassigning root, it will return to its original value once the loop is complete
		while (true) {
			if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				System.out.println(root.val);
				return root;
			}
		}
	}
	

	// driver
	public static void main(String[] args) {
		
		LCABinarySearchTree235 lcabst = new LCABinarySearchTree235();
		
		//
		// building tree
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node8 = new TreeNode(8);
		TreeNode node0 = new TreeNode(0);
		TreeNode node4 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		
		node6.left = node2;
		node6.right = node8;
		node2.left = node0;
		node2.right = node4;
		node4.left = node3;
		node4.right = node5;
		node8.left = node7;
		node8.right = node9;
		//
		//
		
		lcabst.lcaRecursive(node6, node7, node9); // returns 8
		lcabst.lcaIterative(node6, node2, node4); // returns 2
		
		
	}

}
