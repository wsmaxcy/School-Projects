//Will Maxcy
package edu.olemiss.csci211;

import java.util.Iterator;

/**
 * A General Tree class. This class is well suited for bottom-up construction of
 * trees. It only supports adding child nodes and subtrees to the root node of
 * this tree, but that allows for arbitrarily complex trees to be built. We can
 * just build the subtrees first, and then add them to the parent node.
 * 
 * @author rhodes
 * 
 * @param <T>
 */
public class Tree<T> implements Iterable<T> {

	SinglyLinkedList<T> list1 = new SinglyLinkedList<T>();

	protected class Node {

		T data;
		UnorderedList<Node> children = new SinglyLinkedList<Node>();
	}

	Node root;

	/**
	 * Create an empty tree.
	 */
	public Tree() {

		root = new Node();
	}

	/**
	 * Create a tree with the given element contained by the root node.
	 * 
	 * @param element
	 */
	public Tree(T element) {

		root = new Node();
		root.data = element;
	}

	/**
	 * Add a new node containing the given element as a child of the root node
	 * of this tree.
	 * 
	 * @param element
	 *            value to be added.
	 */
	public void addLeaf(T element) {

		Node n = new Node();
		n.data = element;

		root.children.addToRear(n);
	}

	/**
	 * Add the root node of the given tree as a child of the root node of this
	 * tree. The argument tree becomes a subtree of this tree.
	 * 
	 * @param tree
	 *            the tree to be added.
	 */
	public void addSubtree(Tree<T> tree) {

		root.children.addToRear(tree.root);
	}

	/**
	 * Given a target to find in the tree, this method finds all occurrences of
	 * the target in the tree, and returns a list containing the paths leading
	 * from the root to each occurrence of the target. Each path is represented
	 * as a string that concatenates the nodes, using the specified separator
	 * between nodes. For example, /flim/flam/foo /flim/bam/boom/foo
	 * 
	 * @param target
	 * @param separator
	 * @return
	 */
	public List<String> locate(T target, String separator) {

		// Write me. 85% A helper method would be useful.
		// use singly linked list use <String> as data type. add strings to
		// that. the strings you add too that is what you iterate through to
		// find your nodes
		// use for loop(flim (flam bim 2 (foo bar 20 baz 10) bam 4) ole 10 foo
		// 12 )

		// recursively call
		// keep up with your path
		// add the path to your singly linked list
		
		/*This file creates an empty string and continues to add to that string
		 * as a prefix of spaces in order to properly indent the file area.
		 * create a list that will be returned that contains as many nodes that
		 * have a file name that matches what is being searched for in the list.
		 * Once the file name is input, the recursive method searches every element
		 * from the root node in the linked list for the file name and data to match.
		 * All the while, the path is being recursively being tracked by adding pieces
		 * of the file to the string named "path". If the data matches the file name that
		 * has been input by the user, the path is then saved as a string and entered in
		 * to the list of strings as a node. Once the method finishes searching through
		 * the list of children and adding all new paths as nodes to the new list, the
		 * new list is returned, which through some magic code that was provided prints
		 * out each node in the new list, which is a path that led to reac the file name
		 * that matched the data that was input by the user!
		 */
		String path = "";
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		helperLocate(target, root, separator, list, path);

		return list;
	}

	public List<String> helperLocate(T target, Node n, String separator,
			SinglyLinkedList<String> list, String path) {

		path += (separator + n.data.toString());
		if (n.data.equals(target)) {
			list.addToRear(path);
		}
		for (Node node : n.children) {

			helperLocate(target, node, separator, list, path);
		}
		return list;

	}

	/**
	 * Print a representation of the tree to standard output. Each node is
	 * printed on a separate line, and each level of the tree is indented by
	 * four spaces from the previous level.
	 * 
	 */
	
	/*
	 * These methods work together in order to print out the correct files
	 * in order with the correct spacing and level. This is done mostly using
	 * a helperPrint method and recursion. The helperPrint method is called
	 * in the print method using the root of the directory and the number 0.
	 * The number 0 is used here because I could not figure out how to keep
	 * track of a count while still updating it and passing it through multiple
	 * levels, so the 0 argument seemed like a much easier choice and actually
	 * worked! once in the helperPrint method, a blank string is created that
	 * is used for the basis of adding the spacing prefix to every line of code.
	 * The root is passed through and the c hits a for loop, which does nothing
	 * because i=0 and 0 is not less than 0, so nothing happens. This for loop
	 * determines how many sets of 4 spaces is added in front of the file names.
	 * Once past the for loop, an advance for loop is used in order to recursively
	 * iterate through all of the children of the root file, which would in
	 * turn print out every name of every file in the directory. When the
	 * iteration is finished, the loop stops and every file name has been
	 * printed! hooray!
	 */
	public void print() {
		helperPrint(root, 0);
	}

	public void helperPrint(Node n, int c) {

		String spaces = "";

		for (int i = 0; i < c; i++) {
			spaces += "    ";
		}
		System.out.println(spaces + n.data.toString());

		for (Node node : n.children) {
			helperPrint(node, c + 1);
		}

	}

	/**
	 * Print a string representation of the tree. The entire tree is represented
	 * in a single line of text, and square brackets are used to indicate
	 * nesting of subtrees.
	 */
	public String toString() {

		return toStringHelper(root);

	}

	protected String toStringHelper(Node n) {

		String r = "[" + n.data;

		for (Node node : n.children) {

			r = r + toStringHelper(node);
		}

		return r + "]";
	}

	/**
	 * Return a preorder iterator for this tree.
	 */
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 * 
	 * ^^^I dont know what that is, but it could be important!
	 * 
	 * These iterator methods are very complicated, but simple in coding.
	 * The Iterator<T> method only calls the preOrder method, which does
	 * all of the work. Once the root is passed in the preOrder method, the
	 * global variable that I created called list1 (which is a singly linked
	 * list) begins getting the root data (file names and size information)
	 * added into the rear of the list of generic type. Once this happens, 
	 * the roots children begin being iterated through and its information
	 * gets added to the end of list1. the list is recursively built through
	 * the children of the root node and all of the information is put into
	 * the list1. Once the list1 is filled with all info from root and the 
	 * roots children, the class returns the list1 iterator, which then is taken
	 * into some majestic code that was given to us in the assignment and from
	 * that the object size is printed out from each node. If the object is a
	 * directory, then a size 0 is printed. After all nodes and sizes are printed,
	 * all of the node sizes are added together and presented as the total space
	 * inside all of the nodes! Beautiful!
	 */
	
	public Iterator<T> iterator() {

		return preOrder(root);
	}

	/**
	 * Return a preorder iterator for this tree.
	 */
	public Iterator<T> preOrder(Node n) {

		list1.addToRear(n.data);
		for (Node node : n.children) {

			preOrder(node);
		}

		return list1.iterator();
	}

}
