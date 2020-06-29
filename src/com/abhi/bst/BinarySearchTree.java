/**
 * 
 */
package com.abhi.bst;

import java.util.LinkedList;
import java.util.Queue;

import com.abhi.binary.BinaryNode;

/**
 * @author abhinav
 *
 */
public class BinarySearchTree {
	private BinaryNode root;
	
	public void createBST() {
		this.root = null;
	}

	/**
	 * @return the root
	 */
	public BinaryNode getRoot() {
		return this.root;
	}

	public void searchInBST(final BinaryNode parentNode, final int value) {
		if(null == parentNode) {
			System.out.println("Value not found!!");
			return;
		}else if(parentNode.getValue() == value){
			System.out.println("Value found!!");
			return;
		}else if(parentNode.getValue() > value) {
			searchInBST(parentNode.getLeft(), value);
		}else if(parentNode.getValue() < value){
			searchInBST(parentNode.getRight(), value);
		}
	}
	
	public void preOrderTraversal(final BinaryNode root) {
		if(null == root) {
			return;
		}else {
			System.out.print(" "+ root.getValue());
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}
	
	public void inOrderTraversal(final BinaryNode root) {
		if(null == root) {
			return;
		}else {
			inOrderTraversal(root.getLeft());
			System.out.print(" "+ root.getValue());
			inOrderTraversal(root.getRight());
		}
	}

	public void postOrderTraversal(final BinaryNode root) {
		if(null == root) {
			return;
		}else {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(" "+ root.getValue());
		}
	}

	public void levelOrderTraversal(final BinaryNode root) {
		if(null == root) {
			return;
		}else {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				System.out.print(" "+ presentNode.getValue());
				if(null != presentNode.getLeft())
					queue.add(presentNode.getLeft());
				if(null != presentNode.getRight())
					queue.add(presentNode.getRight());
			}
		}
	}

	public void insertInBST(final int value) {
		this.root = insertInBST(this.root, value);
	}
	
	private BinaryNode insertInBST(final BinaryNode currentNode, final int value) {
		if(null == currentNode) {
			return new BinaryNode(value);
		}else if(currentNode.getValue() >= value ) {
			currentNode.setLeft(insertInBST(currentNode.getLeft(), value));
		}else {
			currentNode.setRight(insertInBST(currentNode.getRight(), value));
		}
		return currentNode;
	}
	
	public void deleteFromBST(final int value) {
		deleteFromBST(this.root, value);
	}
	
	private BinaryNode deleteFromBST(BinaryNode root, final int value) {
		if(null == root) {
			return root;
		}
		if(root.getValue() > value) {
			root.setLeft(deleteFromBST(root.getLeft(), value));
		}else if(root.getValue() < value) {
			root.setRight(deleteFromBST(root.getRight(), value));
		}else {
			if(null != root.getLeft() && null != root.getRight()) {
				BinaryNode tempNode = root;
				BinaryNode successorNode = successorNode(tempNode.getRight());
				root.setValue(successorNode.getValue());
				root.setRight(deleteFromBST(root.getRight(), successorNode.getValue()));
			}else if(null != root.getLeft()) {
				root = root.getLeft();
			}else if(null != root.getRight()) {
				root = root.getRight();
			}else {
				root = null;
			}
		}
		return root;
	}

	private BinaryNode successorNode(final BinaryNode root) {
		if(null != root.getLeft()) {
			return successorNode(root.getLeft());
		}
		return root;
	}
	
	public void deleteBST() {
		this.root = null;
	}
}
