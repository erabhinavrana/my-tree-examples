/**
 * 
 */
package com.abhi.binary;

/**
 * @author abhinav
 *
 */
public class BinaryNode {
	private BinaryNode left;
	private BinaryNode right;
	private int value;
	private int height;
	
	public BinaryNode(final int value) {
		this.left = null;
		this.right = null;
		this.value = value;
		this.height = 0;
	}
	/**
	 * @return the left
	 */
	public BinaryNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BinaryNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryNode right) {
		this.right = right;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
}
