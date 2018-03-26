package LinkedList;

import Utils.AssortedMethods;

/**
 * Given two (singly) linked lists, determine if the two lists intersect. Return
 * the intersecting node. Note that the intersection is defined based on
 * reference, not value. That is, if the kth node of the first linked list is
 * the exact same node (by reference) as the jth node of the second linked list,
 * then they are intersecting
 * 
 * @Time: O(A + B)
 * @Space: O(1)
 * 
 * @author Kiran Jagtap
 */
public class Intersection {

	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = { -1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		Node<Integer> list1 = AssortedMethods.createLinkedListFromArray(vals);
		System.out.println("list1--->" + list1.printForward());

		int[] vals2 = { 12, 14, 15 };
		Node<Integer> list2 = AssortedMethods.createLinkedListFromArray(vals2);
		// System.out.println("list2---->"+list2.printForward());

		list2.next.next = list1.next.next.next.next;

		// System.out.println(list1.printForward());
		System.out.println(list2.printForward());

		Node<Integer> intersection = findIntersection(list1, list2);

		System.out.println(intersection.printForward());
	}

	public static class Result {
		public Node<Integer> tail;
		public int size;

		public Result(Node<Integer> tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	public static Result getTailAndSize(Node<Integer> list) {
		if (list == null)
			return null;

		int size = 1;
		Node<Integer> current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}

	public static Node<Integer> getKthNode(Node<Integer> head, int k) {
		Node<Integer> current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}

	public static Node<Integer> findIntersection(Node<Integer> list1,
			Node<Integer> list2) {
		if (list1 == null || list2 == null)
			return null;

		/* Get tail and sizes. */
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);

		/* If different tail nodes, then there's no intersection. */
		if (result1.tail != result2.tail) {
			return null;
		}

		/* Set pointers to the start of each linked list. */
		Node<Integer> shorter = result1.size < result2.size ? list1 : list2;
		Node<Integer> longer = result1.size < result2.size ? list2 : list1;

		/*
		 * Advance the pointer for the longer linked list by the difference in
		 * lengths.
		 */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		System.out.println("longer1--->" + longer.printForward());

		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		System.out.println("shorter--->" + shorter.printForward());
		System.out.println("longer2--->" + longer.printForward());

		/* Return either one. */
		return longer;
	}

}
