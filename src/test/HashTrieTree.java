package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Feb 19, 2014 3:22:54 PM
 * 
 */

public class HashTrieTree<Char extends Character> {

	Node root = null;
	Node currentIndex = root;

	public HashTrieTree() {
		root = new Node();
	}

	private static class Node<Char> {
		Node next;
		Map<Char, Long> counterMap;
	}

	private Node addCharacter(char key) {
		currentIndex.counterMap = new HashMap<>();
		currentIndex.counterMap.put(key, 0);
		currentIndex.next = new Node();
		currentIndex = currentIndex.next;
		return currentIndex;
	}

	public Node addCharacter(String str) {

		char[] chars = Objects.requireNonNull(str).toCharArray();
		int charLength = chars.length;
		for (int i = 0; i < charLength; i++) {
			addCharacter(chars[i]);
			// index is at the end of the tree
			if (i == (charLength - 1)) {
				if (currentIndex.counterMap.get(chars[i]) == null) {
					currentIndex.counterMap.put(chars[i], 1);
				} else {
					currentIndex.counterMap.put(chars[i], Long.valueOf(currentIndex.counterMap.get(chars[i]).toString()) + 1);
				}
			}
		}

		currentIndex = root;

		return currentIndex;
	}
}
