/**
 * 
 */
package com.abhi.heap;

/**
 * @author abhinav
 *
 */
public class BinaryHeapTree {
	private int[] minHeap;
	private int sizeOfHeap;
	
	public void createMinHeap(final int size) {
		this.minHeap = new int[size+1];
		this.sizeOfHeap = 0;
	}

	public int peekMinHeap() {
		return this.minHeap[1];
	}
	
	public int sizeOfHeap() {
		return this.sizeOfHeap;
	}
	
	public void deleteMinHeap() {
		this.minHeap = null;
	}
	
	public void insertInMinHeap(final int value) {
		if(null != this.minHeap) {
			if(this.sizeOfHeap < this.minHeap.length) {
				this.minHeap[++sizeOfHeap] = value;
				performBottomToUpMinHeapify(this.sizeOfHeap);
			}else {
				throw new RuntimeException("Min-Heap tree is full!!");
			}
		}else {
			throw new RuntimeException("Min-Heap tree not initialized!!");
		}
	}

	private void performBottomToUpMinHeapify(final int sizeOfHeap) {
		int parentIndex = sizeOfHeap/2;
		if(parentIndex > 0 && this.minHeap[sizeOfHeap] < this.minHeap[parentIndex]) {
			int temp = this.minHeap[parentIndex];
			this.minHeap[parentIndex] = this.minHeap[sizeOfHeap];
			this.minHeap[sizeOfHeap] = temp;
			performBottomToUpMinHeapify(parentIndex);
		}
	}
	
	public int extractMin() {
		if(null != this.minHeap) {
			if(this.sizeOfHeap != 0) {
				int minValue = this.minHeap[1];
				this.minHeap[1] = this.minHeap[sizeOfHeap--];
				performTopToBottomMinHeapify(1);
				return minValue;
			}else {
				throw new RuntimeException("Min-heap tree is empty!!");
			}
		}else {
			throw new RuntimeException("Min-Heap tree is not initialized!!");
		}
	}
	
	private void performTopToBottomMinHeapify(final int parentIndex) {
		int leftIndex = parentIndex*2;
		int rightChildIndex = (parentIndex * 2) +1;
		if(leftIndex <= this.sizeOfHeap) {
			if(this.minHeap[parentIndex] > this.minHeap[leftIndex]) {
				int temp = this.minHeap[parentIndex];
				this.minHeap[parentIndex] = this.minHeap[leftIndex];
				this.minHeap[leftIndex] = temp;
				performTopToBottomMinHeapify(leftIndex);				
			}			
		}
		if (rightChildIndex <= this.sizeOfHeap) {
			if (this.minHeap[rightChildIndex] < this.minHeap[parentIndex]) {
				int temp = this.minHeap[rightChildIndex];
				this.minHeap[rightChildIndex] = this.minHeap[parentIndex];
				this.minHeap[parentIndex] = temp;
				performTopToBottomMinHeapify(rightChildIndex);
			}
		}

	}
	
	public void levelOrderTraverse() {
		if(null != this.minHeap) {
			if(this.sizeOfHeap != 0) {
				for (int i = 1; i <= this.sizeOfHeap; i++) {
					System.out.print(" "+ this.minHeap[i]);
				}
			}else {
				throw new RuntimeException("Min-heap tree is empty!!");
			}

		}else {
			throw new RuntimeException("Min-Heap tree is not initialized!!");
		}
	}

}
