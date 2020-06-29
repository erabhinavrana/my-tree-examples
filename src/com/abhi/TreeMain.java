/**
 * 
 */
package com.abhi;

import com.abhi.avl.AVLTree;
import com.abhi.avl.AVLTree.TraversalOrder;
import com.abhi.binary.BinaryTree;
import com.abhi.binary.BinaryTreeArrayImpl;
import com.abhi.bst.BinarySearchTree;
import com.abhi.heap.BinaryHeapTree;
import com.abhi.trie.TrieTree;

/**
 * @author abhinav
 *
 */
public class TreeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		performBinaryTreeLinkedListImplOperations();
//		performBinaryTreeArrayImplOperations();
//		perfomBSTOperations();
//		perfomAVLOperations();
//		perfomAVLBalancedOperations();
		performMinHeapOperations();
//		performTrieTreeOperations();
	}

	private static void performBinaryTreeLinkedListImplOperations() {
		System.out.println("\n\nBinaryTree LinkedList Implementation ::");
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree();
		tree.insertNodeInBinaryTree(20);
		tree.insertNodeInBinaryTree(100);
		tree.insertNodeInBinaryTree(3);
		tree.insertNodeInBinaryTree(50);
		tree.insertNodeInBinaryTree(15);
		tree.insertNodeInBinaryTree(250);
		tree.insertNodeInBinaryTree(35);
		tree.insertNodeInBinaryTree(222);

		System.out.println("\nLevel-Order Traversal ::");
		tree.levelOrderTraversal();
		System.out.println("\nPre-Order Traversal ::");
		tree.preOrderTraversal(tree.getRoot());
		System.out.println("\nIn-Order Traversal ::");
		tree.inOrderTraversal(tree.getRoot());
		System.out.println("\nPost-Order Traversal ::");
		tree.postOrderTraversal(tree.getRoot());

		System.out.println("\n");
		tree.searchInBinaryTree(35);
		tree.searchInBinaryTree(23);
		tree.deleteFromBinaryTree(20);
		tree.levelOrderTraversal();
	}

	private static void performBinaryTreeArrayImplOperations() {
		System.out.println("\n\nBinaryTree Array Implementation ::");
		BinaryTreeArrayImpl tree = new BinaryTreeArrayImpl();
		tree.createBinaryTree(9);
		tree.insertInBinaryTree(20);
		tree.insertInBinaryTree(100);
		tree.insertInBinaryTree(3);
		tree.insertInBinaryTree(50);
		tree.insertInBinaryTree(15);
		tree.insertInBinaryTree(250);
		tree.insertInBinaryTree(35);
		tree.insertInBinaryTree(222);
		System.out.println("\nLevel-Order Traversal ::");
		tree.levelOrderTraversal();
		System.out.println("\nPre-Order Traversal ::");
		tree.preOrderTraversal(1);
		System.out.println("\nIn-Order Traversal ::");
		tree.inOrderTraversal(1);
		System.out.println("\nPost-Order Traversal ::");
		tree.postOrderTraversal(1);

		System.out.println("\n");
		tree.searchInBinaryTree(35);
		tree.searchInBinaryTree(23);

		tree.deleteFromBinaryTree(20);
		tree.deleteFromBinaryTree(35);
		tree.levelOrderTraversal();

	}

	private static void perfomBSTOperations() {
		System.out.println("\n\nBinarySearchTree Operations ::");
		BinarySearchTree tree = new BinarySearchTree();
		tree.createBST();
		tree.insertInBST(100);
		tree.insertInBST(80);
		tree.insertInBST(200);
		tree.insertInBST(70);
		tree.insertInBST(90);
		tree.insertInBST(150);
		tree.insertInBST(300);
		tree.insertInBST(50);
		tree.insertInBST(250);
		tree.insertInBST(400);
		tree.insertInBST(40);
		tree.insertInBST(60);

		System.out.println("\nLevel-Order Traversal ::");
		tree.levelOrderTraversal(tree.getRoot());
		System.out.println("\nPre-Order Traversal ::");
		tree.preOrderTraversal(tree.getRoot());
		System.out.println("\nIn-Order Traversal ::");
		tree.inOrderTraversal(tree.getRoot());
		System.out.println("\nPost-Order Traversal ::");
		tree.postOrderTraversal(tree.getRoot());

		System.out.println("\n");
		tree.searchInBST(tree.getRoot(), 95);

		System.out.println("\n");
		tree.deleteFromBST(100);
		tree.deleteFromBST(35);
		tree.levelOrderTraversal(tree.getRoot());
	}

	private static void perfomAVLOperations() {
		System.out.println("\n\nAVLTree Operations ::");
		AVLTree tree = new AVLTree();
		tree.createAVLTree();
		tree.insertInAVLTree(100);
		tree.insertInAVLTree(80);
		tree.insertInAVLTree(200);
		tree.insertInAVLTree(70);
		tree.insertInAVLTree(90);
		tree.insertInAVLTree(150);
		tree.insertInAVLTree(300);
		tree.insertInAVLTree(50);
		tree.insertInAVLTree(250);
		tree.insertInAVLTree(400);
		tree.insertInAVLTree(40);
		tree.insertInAVLTree(60);

		System.out.println("\nLevel-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.LEVELORDER);
		System.out.println("\nPre-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.PREORDER);
		System.out.println("\nIn-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.INORDER);
		System.out.println("\nPost-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.POSTORDER);

		System.out.println("\n");
		tree.searchInAVLTree(90);

		System.out.println("\n");
		tree.deleteInAVLTree(100);
		// tree.deleteInAVLTree(35);
		tree.traverseAVLTree(TraversalOrder.LEVELORDER);
	}

	/**
	 * 
	 */
	private static void perfomAVLBalancedOperations() {
		System.out.println("\n\nAVLTree Operations ::");
		AVLTree tree = new AVLTree();
		tree.createAVLTree();
		tree.insertInAVLTree(30);
		tree.insertInAVLTree(20);
		tree.insertInAVLTree(40);
		tree.insertInAVLTree(10);
		tree.insertInAVLTree(5);
		tree.insertInAVLTree(3);
		tree.insertInAVLTree(4);
		tree.insertInAVLTree(50);
		tree.insertInAVLTree(60);
		tree.insertInAVLTree(70);
		tree.insertInAVLTree(65);

		System.out.println("\nLevel-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.LEVELORDER);
		System.out.println("\nPre-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.PREORDER);
		System.out.println("\nIn-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.INORDER);
		System.out.println("\nPost-Order Traversal ::");
		tree.traverseAVLTree(TraversalOrder.POSTORDER);

		System.out.println("\n");
		tree.searchInAVLTree(70);
//		
		System.out.println("\n");
		tree.deleteInAVLTree(10);
//		//tree.deleteInAVLTree(35);
		tree.traverseAVLTree(TraversalOrder.LEVELORDER);
	}

	private static void performMinHeapOperations() {
		System.out.println("Min-Heap tree operations::::::::");
		BinaryHeapTree tree = new BinaryHeapTree();
//		tree.createMinHeap(16);
//		tree.insertInMinHeap(3);
//		tree.insertInMinHeap(5);
//		tree.insertInMinHeap(8);
//		tree.insertInMinHeap(17);
//		tree.insertInMinHeap(19);
//		tree.insertInMinHeap(36);
//		tree.insertInMinHeap(40);
//		tree.insertInMinHeap(25);
//		tree.insertInMinHeap(100);

		tree.createMinHeap(16);
		tree.insertInMinHeap(9);
		tree.insertInMinHeap(8);
		tree.insertInMinHeap(7);
		tree.insertInMinHeap(6);
		tree.insertInMinHeap(5);
		tree.insertInMinHeap(4);
		tree.insertInMinHeap(3);
		tree.insertInMinHeap(2);
		tree.insertInMinHeap(1);

		System.out.println("\n");
		tree.levelOrderTraverse();

		System.out.println("\n");
		tree.extractMin();

		System.out.println("\n");
		tree.levelOrderTraverse();

	}

	private static void performTrieTreeOperations() {
		System.out.println("Trie tree operations::::::::");
		TrieTree tree = new TrieTree();
		tree.createTrieTree();
		tree.insertInTrieTree("air");
		tree.insertInTrieTree("aim");
		tree.insertInTrieTree("are");

		tree.searchInTrie("aim");
		tree.searchInTrie("air");
		tree.deleteInTrie("are");

		tree.searchInTrie("are");

	}
}
