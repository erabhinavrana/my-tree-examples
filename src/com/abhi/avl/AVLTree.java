/**
 * 
 */
package com.abhi.avl;

import java.util.LinkedList;
import java.util.Queue;

import com.abhi.binary.BinaryNode;

/**
 * @author abhinav
 *
 */
public class AVLTree {
	private BinaryNode root;
	
	public void createAVLTree() {
		this.root = null;
	}

	/**
	 * @return the root
	 */
	public BinaryNode getRoot() {
		return this.root;
	}

	public void searchInAVLTree(final int value) {
		if(null != this.root) {
			searchInAVLTree(this.root, value);
		}else {
			throw new RuntimeException("AVL tree is empty!!");
		}
	}
	
	private void searchInAVLTree(final BinaryNode currentNode, final int value) {
		if(null == currentNode) {
			System.out.println("Value not found!!");
		}else if(currentNode.getValue() == value){
			System.out.println("Value found in an AVL tree!!");
		}else if(currentNode.getValue() > value){
			searchInAVLTree(currentNode.getLeft(), value);
		}else {
			searchInAVLTree(currentNode.getRight(), value);
		}
	}
	
	public void traverseAVLTree(final TraversalOrder order) {
		if(null != this.root) {
			switch (order) {
			case PREORDER:
				preOrderTraversal(this.root);
				break;
			case INORDER:
				inOrderTraversal(this.root);				
				break;
			case POSTORDER:
				postOrderTraversal(this.root);				
				break;
			case LEVELORDER:
				levelOrderTraversal(this.root);				
				break;
			default:
				System.out.println("Invalid type of traversal order!!");
				break;
			}			
		}else {
			throw new RuntimeException("AVL tree is empty!!");
		}
	}

	private void preOrderTraversal(final BinaryNode currentNode) {
		if(null != currentNode) {
			System.out.print(" "+ currentNode.getValue());
			preOrderTraversal(currentNode.getLeft());
			preOrderTraversal(currentNode.getRight());
		}
	}

	private void inOrderTraversal(final BinaryNode currentNode) {
		if(null != currentNode) {
			inOrderTraversal(currentNode.getLeft());
			System.out.print(" "+ currentNode.getValue());
			inOrderTraversal(currentNode.getRight());
		}
	}

	private void postOrderTraversal(final BinaryNode currentNode) {
		if(null != currentNode) {
			postOrderTraversal(currentNode.getLeft());
			postOrderTraversal(currentNode.getRight());
			System.out.print(" "+ currentNode.getValue());
		}		
	}

	private void levelOrderTraversal(final BinaryNode currentNode) {
		if(null != currentNode) {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(currentNode);
			while(!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				System.out.print(" "+ presentNode.getValue()+"-"+presentNode.getHeight());
				if(null != presentNode.getLeft()) {
					queue.add(presentNode.getLeft());
				}
				if(null != presentNode.getRight()) {
					queue.add(presentNode.getRight());
				}
			}
			queue = null;
		}
	}
	
	
	public void insertInAVLTree(final int value) {
		this.root = insertInAVLTree(this.root, value);
	}
	
	private BinaryNode insertInAVLTree(BinaryNode currentNode, int value) {
		BinaryNode newNode = new BinaryNode(value);
		if(null != currentNode) {
			if(currentNode.getValue() >= value) {
				currentNode.setLeft(insertInAVLTree(currentNode.getLeft(), value));
			}else {
				currentNode.setRight(insertInAVLTree(currentNode.getRight(), value));
			}						
		}else {
			currentNode = newNode;
		}
		
		currentNode = maintainAVLBalance(currentNode);
		
		return currentNode;
	}

	private BinaryNode maintainAVLBalance(BinaryNode currentNode) {
		if(null != currentNode) {
			int balance = calculateNodeBalance(currentNode.getLeft(), currentNode.getRight());
			
			if(balance > 1) {
				if(calculateNodeBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
					currentNode = rotateRight(currentNode);
				}else {
					currentNode.setLeft(rotateLeft(currentNode.getLeft()));
					currentNode = rotateRight(currentNode);
				}
			}else if(balance < -1) {
				if(calculateNodeBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
					currentNode = rotateLeft(currentNode);
				}else {
					currentNode.setRight(rotateRight(currentNode.getRight()));
					currentNode = rotateLeft(currentNode);
				}
				
			}
			
			if(currentNode.getLeft() != null) {
				currentNode.getLeft().setHeight(calculateNodeHeight(currentNode.getLeft()));
			}
			if(currentNode.getRight() != null) {
				currentNode.getRight().setHeight(calculateNodeHeight(currentNode.getRight()));
			}
			currentNode.setHeight(calculateNodeHeight(currentNode));			
		}
		return currentNode;
	}

	private BinaryNode rotateLeft(BinaryNode currentNode) {
		BinaryNode updatedNode = currentNode.getRight();
		currentNode.setRight(currentNode.getRight().getLeft());
		updatedNode.setLeft(currentNode);
		return updatedNode;
	}

	private BinaryNode rotateRight(BinaryNode currentNode) {
		BinaryNode updateNode = currentNode.getLeft();
		currentNode.setLeft(currentNode.getLeft().getRight());
		updateNode.setRight(currentNode);
		return updateNode;
	}

	private int calculateNodeBalance(BinaryNode left, BinaryNode right) {
		if(left != null && right != null) {
			return left.getHeight() - right.getHeight();
		}else if(left != null) {
			return left.getHeight() + 1;
		}else if(right != null){
			return -(right.getHeight()+1);
		}else {
			return 0;			
		}
	}

	public void deleteInAVLTree(final int value) {
		if(null != this.root) {
			deleteInAVLTree(this.root, value);
		}else {
			throw new RuntimeException("AVL tree is empty!!");
		}
	}
	
	private BinaryNode deleteInAVLTree(BinaryNode currentNode, int value) {
		if(null !=currentNode) {
			if(currentNode.getValue() > value) {
				currentNode.setLeft(deleteInAVLTree(currentNode.getLeft(), value));
			}else if(currentNode.getValue() < value) {
				currentNode.setRight(deleteInAVLTree(currentNode.getRight(), value));
			}else {
				if(null != currentNode.getLeft() && null != currentNode.getRight()) {
					BinaryNode temp = currentNode;
					BinaryNode successorNode = findSuccessorNode(temp.getRight());
					currentNode.setValue(successorNode.getValue());
					currentNode.setRight(deleteInAVLTree(currentNode.getRight(), successorNode.getValue()));	
				}else if(null != currentNode.getLeft()) {
					currentNode = currentNode.getLeft();
				}else if(null != currentNode.getRight()) {
					currentNode = currentNode.getRight();
				}else {
					currentNode = null;					
				}
			}			
		}else {
			throw new RuntimeException("Value = "+value+" not found!!");
		}
		
		currentNode = maintainAVLBalance(currentNode);

		return currentNode;
	}

	private BinaryNode findSuccessorNode(BinaryNode node) {
		if(null != node.getLeft()) {
			return findSuccessorNode(node.getLeft());
		}
		return node;
	}

	public void deleteAVLTree() {
		this.root = null;
	}

	public int calculateNodeHeight(final BinaryNode currentNode) {
		int left = 0,right = 0;
		if(currentNode.getLeft() != null && currentNode.getRight() != null) {
			left += calculateNodeHeight(currentNode.getLeft());
			left++;
			right += calculateNodeHeight(currentNode.getRight());
			right++;
		}else if(currentNode.getLeft() != null) {
			left += calculateNodeHeight(currentNode.getLeft());
			left++;
		}else if(currentNode.getRight() != null) {
			right += calculateNodeHeight(currentNode.getRight());
			right++;
		}else {
			left = 0;right = 0;
		}
		return left > right? left : right;
	}
	
	public enum TraversalOrder{
		PREORDER,
		INORDER,
		POSTORDER,
		LEVELORDER
	}
}
