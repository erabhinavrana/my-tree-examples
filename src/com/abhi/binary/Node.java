/**
 * 
 */
package com.abhi.binary;

/**
 * @author abhinav
 *
 */
public class Node {
	private BinaryNode treeNode;
	private Node next;
	
	public Node(final BinaryNode treeNode) {
		this.treeNode = treeNode;
		this.next = null;
	}
	/**
	 * @return the value
	 */
	public BinaryNode getValue() {
		return this.treeNode;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(BinaryNode treeNode) {
		this.treeNode = treeNode;
	}
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
