/**
 * 
 */
package com.abhi.binary;

/**
 * @author abhinav
 *
 */
public interface Queue {
	void create();

	void enQueue(final BinaryNode node);

	BinaryNode deQueue();

	BinaryNode peek();

	boolean isEmpty();
	
	void delete();
}
