//Will Maxcy
package edu.olemiss.csci211;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {

	
	@Test
	public void exampleTest0() {
		
		Tree<String> tree = new Tree<String>();

		System.out.println(tree);
		
		assertEquals("[null]", tree.toString());
	}

	@Test
	public void exampleTest1() {
		
		Tree<String> tree = new Tree<String>("root");
		
		tree.addLeaf("foo");
		tree.addLeaf("bar");
		tree.addLeaf("baz");
		
		System.out.println(tree);
		
		assertEquals("[root[foo][bar][baz]]", tree.toString());
	}

	@Test
	public void exampleTest2() {
		
		Tree<String> tree = new Tree<String>("root");
		Tree<String> tree2 = new Tree<String>("boom");
		tree2.addLeaf("ping");
		tree2.addLeaf("pong");
		
		
		
		tree.addLeaf("foo");
		tree.addLeaf("bar");
		tree.addLeaf("baz");
		
		tree.addSubtree(tree2);
		
		System.out.println(tree);
		
		assertEquals("[root[foo][bar][baz][boom[ping][pong]]]", tree.toString());
	}

	

	
}
