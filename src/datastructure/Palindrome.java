package datastructure;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome.
 * 
 * @author Kiran Jagtap
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		int length = 9;
		Node[] nodes = new Node[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new Node<Integer>(i >= length / 2 ? length - i - 1 : i,
					null, null);
		}

		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}

		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome

		Node<Integer> head = nodes[0];
		System.out.println(head.printForward());
		// System.out.println(isPalindrome1(head));
		// System.out.println(isPalindrome2(head));
		System.out.println(isPalindrome3(head));
	}

	/**
	 * Solution #1: Reverse and Compare:Our first solution is to reverse the
	 * linked list and compare the reversed list to the original list. If
	 * they're the same, the lists are identical.
	 */
	public static boolean isPalindrome1(Node<Integer> head) {
		Node<Integer> reversed = reverseAndClone(head);
		System.out.println("reversed-->" + reversed.printForward());
		return isEqual(head, reversed);
	}

	public static Node<Integer> reverseAndClone(Node<Integer> node) {
		Node<Integer> head = null;
		while (node != null) {
			Node<Integer> n = new Node<Integer>(node.data); // Clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	public static boolean isEqual(Node<Integer> one, Node<Integer> two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	// Solution #2: Iterative Approach
	public static boolean isPalindrome2(Node<Integer> head) {
		Node<Integer> fast = head;
		Node<Integer> slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		/*
		 * Push elements from first half of linked list onto stack. When fast
		 * runner (which is moving at 2x speed) reaches the end of the linked
		 * list, then we know we're at the middle
		 */
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
			System.out.println("fast-->" + fast.printForward());
			// System.out.println("fast.next-->"+fast.next.printForward());
		}
		System.out.println("stack-->" + stack);
		/* Has odd number of elements, so skip the middle */
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	// Solution #3: Recursive Approach
	public static class Result {
		public Node<Integer> node;
		public boolean result;

		public Result(Node<Integer> n, boolean res) {
			node = n;
			result = res;
		}
	}

	public static Result isPalindromeRecurse(Node<Integer> head, int length) {
		System.out.println("---Starting isPalindromeRecurse ---");
		if (head == null || length <= 0) { // Even number of nodes
			return new Result(head, true);
		} else if (length == 1) { // Odd number of nodes
			return new Result(head.next, true);
		}

		/* Recurse on sublist. */
		Result res = isPalindromeRecurse(head.next, length - 2);

		/* If child calls are not a palindrome, pass back up a failure. */
		if (!res.result || res.node == null) {
			return res;
		}

		/* Check if matches corresponding node on other side. */
		res.result = (head.data == res.node.data);

		/* Return corresponding node. */
		res.node = res.node.next;
		System.out.println("---Ending isPalindromeRecurse ---");
		return res;
	}

	public static int lengthOfList(Node<Integer> n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}

	public static boolean isPalindrome3(Node<Integer> head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}
}
