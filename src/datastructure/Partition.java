package datastructure;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x. If x is
 * contained within the list, the values of x only need to be after the elements
 * less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right
 * partitions.
 * 
 * <p>
 * EXAMPLE:
 * </p>
 * <blockquote>
 * 
 * <pre>
 * Input: 3 -> 5 -> 8 -> 5 -> 113 -> 2 -> 1 [partition = 5]
 * Output: 3 -> 1 -> 2 -> 113 -> 5 -> 5 -> 8
 * </blockquote>
 * </pre>
 * 
 * @author Kiran Jagtap
 */
public class Partition {

	public static void main(String[] args) {
		System.out.println("printForward--->"
				+ createLinkedList().printForward());

		/* Partition */
		Node<Integer> hA = partition1(createLinkedList(), 5);
		Node<Integer> hB = partition2(createLinkedList(), 5);
		Node<Integer> hC = partition3(createLinkedList(), 5);

		/* Print Result */
		System.out.println("hA--->" + hA.printForward());
		System.out.println("hB--->" + hB.printForward());
		System.out.println("hC--->" + hC.printForward());
	}

	public static Node<Integer> createLinkedList() {
		/* Create linked list */
		int[] vals = { 3, 5, 8, 5, 10, 2, 1 };
		Node<Integer> head = new Node<Integer>(vals[0], null, null);
		Node<Integer> current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new Node<Integer>(vals[i], null, current);
		}
		return head;
	}

	/* Pass in the head of the linked list and the value to partition around */
	public static Node<Integer> partition1(Node<Integer> node, int x) {
		Node<Integer> beforeStart = null;
		Node<Integer> beforeEnd = null;
		Node<Integer> afterStart = null;
		Node<Integer> afterEnd = null;

		/* Partition list */
		while (node != null) {
			Node<Integer> next = node.next;
			node.next = null;
			if (node.data < x) {
				/* Insert node into end of before list */
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				/* Insert node into end of after list */
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}

		beforeEnd.next = afterStart;
		return beforeStart;
	}

	public static Node<Integer> partition2(Node<Integer> node, int x) {
		Node<Integer> beforeStart = null;
		Node<Integer> afterStart = null;

		/* Partition list */
		while (node != null) {
			Node<Integer> next = node.next;
			if (node.data < x) {
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;
			} else {
				/* Insert node into front of after list */
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}

		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}

		Node<Integer> head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}

	public static Node<Integer> partition3(Node<Integer> node, int x) {
		Node<Integer> head = node;
		Node<Integer> tail = node;

		/* Partition list */
		while (node != null) {
			Node<Integer> next = node.next;
			if (node.data < x) {
				/* Insert node at head. */
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail. */
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		return head;
	}
}
