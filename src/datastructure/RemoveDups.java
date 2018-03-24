package datastructure;

import java.util.HashSet;

import datastructure.Node;
import Utils.AssortedMethods;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP
 * </p>
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author Kiran Jagtap
 */
public class RemoveDups {

	public static void main(String[] args) {
		// Node<Integer> first = new Node<Integer>(0, null, null);
		Node<Integer> first = AssortedMethods.randomLinkedList(1000, 0, 2);

		Node<Integer> head = first;
		Node<Integer> second = first;
		for (int i = 1; i < 8; i++) {
			second = new Node<Integer>(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println("LinkedList =>  " + head.printForward());
		// deleteDups1(head);
		// deleteDups2(head);
		deleteDups3(head);
		System.out.println("After Removal of duplicate values => "
				+ head.printForward());
	}

	/*
	 * We simply iterate through the linked list, adding each element to a hash
	 * table.When we discover a duplicate element, we remove the element and
	 * continue iterating. We can do this all in one pass since we are using a
	 * linked list. Time: o(n) Space: o(n)
	 */
	public static void deleteDups1(Node<Integer> n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node<Integer> previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}

	/*
	 * If we don't have a buffer, we can iterate with two pointers: current
	 * which iterates through the linked list,and runner which checks all
	 * subsequent nodes for duplicates. Time: o(n^2) Space: o(1)
	 */
	public static void deleteDups2(Node<Integer> head) {
		Node<Integer> current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			Node<Integer> runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void deleteDups3(Node<Integer> head) {
		if (head == null)
			return;
		Node<Integer> previous = head;
		Node<Integer> current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			Node<Integer> runner = head;
			while (runner != current) {
				if (runner.data == current.data) {
					Node<Integer> tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/*
					 * We know we can't have more than one dup preceding our
					 * element since it would have been removed earlier.
					 */
					break;
				}
				runner = runner.next;
			}

			/*
			 * If runner == current, then we didn't find any duplicate elements
			 * in the previous for loop. We then need to increment current. If
			 * runner != current, then we must have hit the break condition, in
			 * which case we found a dup and current has already been
			 * incremented.
			 */
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
	}

}