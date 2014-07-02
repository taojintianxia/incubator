package test;

import java.util.Map;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Feb 19, 2014 3:22:54 PM
 * 
 */

public class HashTrieTree<Char extends Character> {

	HashTrieTree root = null;

	private static class Node {
		Node next;
		Map<Character, Long> counter;
	}

}
