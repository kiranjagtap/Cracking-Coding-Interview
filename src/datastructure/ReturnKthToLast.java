package datastructure;

import Utils.AssortedMethods;

/**
 * Implement an algorithm to find the kth to last element of a singly linked
 * list.
 * 
 * @author Kiran Jagtap
 */
public class ReturnKthToLast {

	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6 };
		Node<Integer> head = AssortedMethods.createLinkedListFromArray(array);
		System.out.println(head.printForward());

		for (int i = 0; i <= array.length + 1; i++) {
			printKthToLast(head, i);
		}
		System.out.println();
		System.out.println("-----Approach C: Create a Wrapper Class.----");
		// Approach C: Create a Wrapper Class.
		for (int i = 0; i <= array.length + 1; i++) {
			Node<Integer> node = kthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
		System.out.println();
		System.out.println("-----Solution #3: Iterative----");
		// Solution #3: Iterative
		for (int i = 0; i <= array.length + 1; i++) {
			Node<Integer> node = nthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
	}

	/*
	 * For this solution, we have defined k such that passing in k = 1 would
	 * return the last element, k = 2 would return to the second to last
	 * element, and so on.It is equally acceptable to define k such that k = 0
	 * would return the last element.
	 */
	public static int printKthToLast(Node<Integer> head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}

	// Approach C: Create a Wrapper Class.
	public static class Index {
		public int value = 0;
	}

	public static Node<Integer> kthToLast(Node<Integer> head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	public static Node<Integer> kthToLast(Node<Integer> head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		Node<Integer> node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		}
		return node;
	}

	// Solution #3: Iterative
	public static Node<Integer> nthToLast(Node<Integer> head, int k) {
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;

		/* Move p1 k nodes into the list. */
		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return null; // Out of bounds
			p1 = p1.next;
		}

		/*
		 * Move them at the same pace. When p1 hits the end, p2 will be at the
		 * right element.
		 */
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}
