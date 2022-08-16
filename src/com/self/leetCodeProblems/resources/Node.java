package com.self.leetCodeProblems.resources;

import java.util.List;

public class Node {
	public int val;
	public List<Node> children;
	
	// constructors
	public Node() {}
	
	public Node(int _val) {
		val = _val;
	}
	
	public Node (int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
