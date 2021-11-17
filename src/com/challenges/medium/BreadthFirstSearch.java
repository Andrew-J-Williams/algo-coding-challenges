package com.challenges.medium;

import java.util.*;

public class BreadthFirstSearch {
	
	static class Node {
	    String name;
	    List<Node> children = new ArrayList<Node>();

	    public Node(String name) {
	      this.name = name;
	    }

	    public List<String> breadthFirstSearch(List<String> array) {
	      // Write your code here.
	      return array;
	    }

	    public Node addChild(String name) {
	      Node child = new Node(name);
	      children.add(child);
	      return this;
	    }
	  }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
