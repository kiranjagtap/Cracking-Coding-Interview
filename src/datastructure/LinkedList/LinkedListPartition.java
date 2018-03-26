package LinkedList;


/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x. If x is
 * contained within the list, the values of x only need to be after the elements
 * less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right
 * partitions.
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
public class LinkedListPartition {

	public static void main(String args[]) {
		Node hA = partition(createLinkedList(), 5);
		System.out.println("hA--->" + hA.printForward());

	}

	public static Node<Integer> partition(Node<Integer> node, int x) {
		Node<Integer> smaller = node;
		Node<Integer> gretter = node;

		while (node != null) {
			Node<Integer> nextNode = node.next;
			if (node.data < x) {
				node.next = smaller;
				smaller = node;

			} else {
				gretter.next = node;
				gretter = node;

			}

			node = nextNode;
		}
		gretter.next = null;

		return smaller;
	}

	public static Node createLinkedList() {
		/* Create linked list */
		int[] vals = { 3, 5, 8, 5, 10, 2, 1 };
		Node<Integer> head = new Node<Integer>(vals[0], null, null);
		Node<Integer> current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new Node<Integer>(vals[i], null, current);
		}
		return head;
	}

}
