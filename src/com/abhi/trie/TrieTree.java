/**
 * 
 */
package com.abhi.trie;

/**
 * @author abhinav
 *
 */
public class TrieTree {
	private TrieNode root;

	public TrieTree() {
		this.root = null;
	}

	public void createTrieTree() {
		this.root = new TrieNode();
	}

	public void insertInTrieTree(final String value) {
		if (this.root != null) {
			this.root = insertInTrie(value.toCharArray(), 0, this.root);
		} else {
			throw new RuntimeException("Trie tree not initialized !!");
		}
	}

	private TrieNode insertInTrie(char[] charArray, int counter, TrieNode root) {
		if (counter < charArray.length) {
			if (root.getTrieMap().keySet().contains(charArray[counter])) {
				insertInTrie(charArray, counter + 1, root.getTrieMap().get(charArray[counter]));
			} else {
				root.getTrieMap().put(charArray[counter], insertInTrie(charArray, counter + 1, new TrieNode()));
			}
		} else {
			root.setEndOfString('Y');
		}
		return root;
	}

	public void searchInTrie(final String value) {
		if (this.root != null) {
			searchInTrie(value.toCharArray(), 0, this.root);
		} else {
			throw new RuntimeException("Trie tree not initialized !!");
		}
	}

	private void searchInTrie(char[] charArray, int counter, TrieNode root) {
		if (counter < charArray.length) {
			if (root.getTrieMap().keySet().contains(charArray[counter])) {
				searchInTrie(charArray, counter + 1, root.getTrieMap().get(charArray[counter]));
			} else {
				System.out.println("String not found !!");
			}
		} else {
			if(root.getEndOfString() == 'Y') {
				System.out.println("String found !!");
			}else {
				System.out.println("String not found !!");
			}
		}		
	}
	
	public void deleteInTrie(final String value) {
		if (this.root != null) {
			this.root = deleteInTrie(value.toCharArray(), 0, this.root);
		} else {
			throw new RuntimeException("Trie tree not initialized !!");
		}		
	}
	
	private TrieNode deleteInTrie(char[] charArray, int counter, TrieNode root) {
		if (counter < charArray.length) {
			if (root.getTrieMap().keySet().contains(charArray[counter])) {
				deleteInTrie(charArray, counter + 1, root.getTrieMap().get(charArray[counter]));
				if(root.getTrieMap().get(charArray[counter]).getTrieMap().size() == 0) {
					root.getTrieMap().remove(charArray[counter]);
				}								
			} else {
				throw new RuntimeException("String not found !!");
			}
		} else {
			if(root.getEndOfString() == 'Y') {
				root.setEndOfString('N');
				System.out.println("String deleted!!!");
			}else {
				throw new RuntimeException("String not found !!");
			}
		}		
		return root;
	}

	public void deleteTrieTree() {
		this.root = null;
	}
}
