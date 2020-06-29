/**
 * 
 */
package com.abhi.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author abhinav
 *
 */
public class TrieNode {
	private char endOfString;
	private Map<Character, TrieNode> trieMap;
	
	public TrieNode() {
		this.endOfString = 'N';
		this.trieMap = new HashMap<Character, TrieNode>();
	}
	
	/**
	 * @return the endOfString
	 */
	public char getEndOfString() {
		return endOfString;
	}
	/**
	 * @param endOfString the endOfString to set
	 */
	public void setEndOfString(char endOfString) {
		this.endOfString = endOfString;
	}
	/**
	 * @return the trieMap
	 */
	public Map<Character, TrieNode> getTrieMap() {
		return trieMap;
	}
	/**
	 * @param trieMap the trieMap to set
	 */
	public void setTrieMap(Map<Character, TrieNode> trieMap) {
		this.trieMap = trieMap;
	}
}
