/**
 * 
 */
package com.abhi.binary;

/**
 * @author abhinav
 *
 */
public class BinaryTree {
	private BinaryNode root;

	public void createBinaryTree() {
		this.root = null;
	}

	/**
	 * @return the root
	 */
	public BinaryNode getRoot() {
		return root;
	}

	public void preOrderTraversal(final BinaryNode root) {
		if (null != root) {
			displayValue(root.getValue());
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}

	public void inOrderTraversal(final BinaryNode root) {
		if (null != root) {
			inOrderTraversal(root.getLeft());
			displayValue(root.getValue());
			inOrderTraversal(root.getRight());
		}
	}

	public void postOrderTraversal(final BinaryNode root) {
		if (null != root) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			displayValue(root.getValue());
		}
	}

	public void levelOrderTraversal() {
		if (null != this.root) {
			Queue queue = new LinkedListQueue();
			queue.create();
			queue.enQueue(this.root);

			while (!queue.isEmpty()) {
				BinaryNode presentNode = queue.deQueue();
				System.out.print(" " + presentNode.getValue());
				if (null != presentNode.getLeft())
					queue.enQueue(presentNode.getLeft());
				if (null != presentNode.getRight())
					queue.enQueue(presentNode.getRight());
			}
			queue.delete();
		}
	}

	public void insertNodeInBinaryTree(final int value) {
		BinaryNode node = new BinaryNode(value);
		if (null != this.root) {
			Queue queue = new LinkedListQueue();
			queue.create();
			queue.enQueue(this.root);
			while (!queue.isEmpty()) {
				BinaryNode presentNode = queue.deQueue();
				if (null == presentNode.getLeft()) {
					presentNode.setLeft(node);
					break;
				} else if (null == presentNode.getRight()) {
					presentNode.setRight(node);
					break;
				} else {
					queue.enQueue(presentNode.getLeft());
					queue.enQueue(presentNode.getRight());
				}
			}
			queue.delete();
		} else {
			this.root = node;
		}
	}

	public boolean searchInBinaryTree(final int value) {
		if (null != this.root) {
			boolean isFound = false;
			Queue queue = new LinkedListQueue();
			queue.create();
			queue.enQueue(this.root);
			while (!queue.isEmpty()) {
				BinaryNode presentNode = queue.deQueue();
				if (presentNode.getValue() == value) {
					isFound = true;
					break;
				}
				if (null != presentNode.getLeft()) {
					queue.enQueue(presentNode.getLeft());
				}
				if (null != presentNode.getRight()) {
					queue.enQueue(presentNode.getRight());
				}
			}
			if (isFound) {
				System.out.println("Value found in the Binary Tree!!");
			} else {
				System.out.println("Value not found in the Binary Tree!!");
			}
			queue.delete();
			return isFound;
		} else {
			throw new RuntimeException("Tree is empty!!");
		}
	}

	public void deleteFromBinaryTree(final int value) {
		if (null != this.root) {
			Queue queue = new LinkedListQueue();
			queue.create();
			queue.enQueue(this.root);
			BinaryNode presentNode = null;
			while (!queue.isEmpty()) {
				presentNode = queue.deQueue();
				if (presentNode.getValue() == value) {
					presentNode.setValue(findTheDeepestNodeInBinaryTree(this.root).getValue());
					deleteTheDeepestNodeInBinaryTree(this.root);
					break;
				}
				if (null != presentNode.getLeft()) {
					queue.enQueue(presentNode.getLeft());
				}
				if (null != presentNode.getRight()) {
					queue.enQueue(presentNode.getRight());
				}
			}
			queue.delete();
		}else {
			throw new RuntimeException("Tree is empty!!");
		}
	}

	public BinaryNode findTheDeepestNodeInBinaryTree(final BinaryNode root) {
		if(null != root) {
			Queue queue = new LinkedListQueue();
			queue.create();
			queue.enQueue(root);
			BinaryNode higestDepthNode = null;
			while (!queue.isEmpty()) {
				higestDepthNode = queue.deQueue();
				if (null != higestDepthNode.getLeft())
					queue.enQueue(higestDepthNode.getLeft());
				if (null != higestDepthNode.getRight())
					queue.enQueue(higestDepthNode.getRight());
			}
			queue.delete();
			return higestDepthNode;
		}else {
			throw new RuntimeException("Tree is empty!!");
		}
	}
	
	public void deleteTheDeepestNodeInBinaryTree(final BinaryNode root) {
		if(null != root) {
			Queue queue = new LinkedListQueue();
			queue.create();
			queue.enQueue(root);
			BinaryNode previousNode,presentNode = null;
			while (!queue.isEmpty()) {
				previousNode = presentNode;
				presentNode = queue.deQueue();
				if (null == presentNode.getLeft()) {
					previousNode.setRight(null);
					break;
				}
				if (null == presentNode.getRight()) {
					presentNode.setLeft(null);
					break;
				}
				queue.enQueue(presentNode.getLeft());
				queue.enQueue(presentNode.getRight());
			}
			queue.delete();
		}else {
			throw new RuntimeException("Tree is empty!!");
		}		
	}
	
	public void deleteBinaryTree() {
		this.root = null;
	}
	
	private void displayValue(int value) {
		System.out.print(" " + value);
	}
}
