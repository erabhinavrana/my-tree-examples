/**
 * 
 */
package com.abhi.binary;

/**
 * @author abhinav
 *
 */
public class BinaryTreeArrayImpl {
	private int[] tree;
	private int lastUsedIndex;

	public BinaryTreeArrayImpl() {
		this.tree = null;
		this.lastUsedIndex = -1;
	}

	public void createBinaryTree(final int size) {
		this.tree = new int[size];
		this.lastUsedIndex = 0;
	}

	public void insertInBinaryTree(final int value) {
		if (null != this.tree) {
			if (!isTreeFull()) {
				this.tree[++this.lastUsedIndex] = value;
			} else {
				throw new RuntimeException("Tree is full!!");
			}
		} else {
			throw new RuntimeException("Tree is not initialized!!");
		}
	}

	public void searchInBinaryTree(final int value) {
		if (null != this.tree) {
			if (!isEmptyTree()) {
				for (int i = 1; i <= this.lastUsedIndex; i++) {
					if (this.tree[i] == value) {
						System.out.println("Value found in the tree");
						return;
					}
				}
				System.out.println("Value not found in the tree!!");
			} else {
				throw new RuntimeException("Tree is empty!!");
			}
		} else {
			throw new RuntimeException("Tree is not initialized!!");
		}
	}

	public void inOrderTraversal(final int rootIndex) {
		if (null != this.tree) {
			if (!isEmptyTree()) {
				if (rootIndex > this.lastUsedIndex) {
					return;
				} else {
					inOrderTraversal(2 * rootIndex);
					System.out.print(" " + this.tree[rootIndex]);
					inOrderTraversal(2 * rootIndex + 1);
				}
			} else {
				throw new RuntimeException("Tree is empty!!");
			}
		} else {
			throw new RuntimeException("Tree is not initialized!!");
		}
	}

	public void preOrderTraversal(final int rootIndex) {
		if (null != this.tree) {
			if (!isEmptyTree()) {
				if (rootIndex > this.lastUsedIndex) {
					return;
				} else {
					System.out.print(" " + this.tree[rootIndex]);
					preOrderTraversal(2 * rootIndex);
					preOrderTraversal(2 * rootIndex + 1);
				}
			} else {
				throw new RuntimeException("Tree is empty!!");
			}
		} else {
			throw new RuntimeException("Tree is not initialized!!");
		}
	}

	public void postOrderTraversal(final int rootIndex) {
		if (null != this.tree) {
			if (!isEmptyTree()) {
				if (rootIndex > this.lastUsedIndex) {
					return;
				} else {
					postOrderTraversal(2 * rootIndex);
					postOrderTraversal(2 * rootIndex + 1);
					System.out.print(" " + this.tree[rootIndex]);
				}
			} else {
				throw new RuntimeException("Tree is empty!!");
			}
		} else {
			throw new RuntimeException("Tree is not initialized!!");
		}
	}

	public void levelOrderTraversal() {
		if (null != this.tree) {
			if (!isEmptyTree()) {
				for (int i = 1; i <= this.lastUsedIndex; i++) {
					System.out.print(" " + this.tree[i]);
				}
			} else {
				throw new RuntimeException("Tree is empty!!");
			}
		} else {
			throw new RuntimeException("Tree is not initialized!!");
		}
	}

	public void deleteFromBinaryTree(final int value) {
		if(null != this.tree) {
			if(!isEmptyTree()) {
				for (int i = 1; i <= this.lastUsedIndex; i++) {
					if(this.tree[i] == value) {
						this.tree[i] = this.tree[this.lastUsedIndex--];
						System.out.println("Deleted the value!!");
						return;
					}
				}
			} else {
				throw new RuntimeException("Tree is empty!!");
			}
		} else {
			throw new RuntimeException("Tree is not initialized!!");
		}
	}

	public void deleteBinaryTree() {
		this.tree = null;
	}

	private boolean isEmptyTree() {
		if (null != this.tree && this.lastUsedIndex == 0) {
			return true;
		}
		return false;
	}

	private boolean isTreeFull() {
		if (null != this.tree && this.lastUsedIndex == this.tree.length) {
			return true;
		}
		return false;
	}
}
