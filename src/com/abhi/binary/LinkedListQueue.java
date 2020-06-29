/**
 * 
 */
package com.abhi.binary;

/**
 * @author abhinav
 *
 */
public class LinkedListQueue implements Queue{

	private Node head;
	private Node tail;
	
	@Override
	public void create() {
		this.head = null;
		this.tail = null;
	}

	@Override
	public void enQueue(final BinaryNode treeNode) {
		Node node = new Node(treeNode);
		if(null != this.head) {
			this.tail.setNext(node);
			this.tail = node;
		}else {
			this.head = this.tail = node;
		}
	}

	@Override
	public BinaryNode deQueue() {
		if(!isEmpty()) {
			Node node = this.head;
			this.head = this.head.getNext();
			return node.getValue();
		}else {
			throw new RuntimeException("Queue is empty!!");
		}
	}

	@Override
	public BinaryNode peek() {
		if(!isEmpty()) {
			return this.head.getValue();
		}else {
			throw new RuntimeException("Queue is empty!!");
		}
	}

	@Override
	public boolean isEmpty() {
		if(null == this.head) {
			return true;
		}
		return false;
	}

	@Override
	public void delete() {
		this.head = this.tail = null;
	}

}
