package LinkedList;


/*
 * Implementation of Singly linked list in Java 
 * 
 * @author Kiran Jagtap
 */
public class SinglyLinkedList<T> {

	Node<T> head;

	public void addOrAppend(T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		if (head == null) {
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}

			temp.next = newNode;
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int length() {
		int length = 0;
		Node<T> temp = head;
		while (temp.next != null) {
			length++;
			temp = temp.next;

		}
		return length;
	}

	public boolean insert_at_first(T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		newNode.next = head;
		head = newNode;
		return true;
	}

	public boolean insert_at_nth(int index, T data) {

		Node<T> temp = head;
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		int i = 0;
		while (i < index - 2) { // note that I changed the end condition
			temp = temp.next;
			i++;
		}
		// the new node is placed between temp and temp.next
		newNode.next = temp.next;
		temp.next = newNode;
		return true;

	}

	public void deleteNth(int position) {
		if (head == null) {
			return;
		}
		if (position == 0) {
			head = head.next;
		}
		Node<T> current = head;
		int i = 0;
		while (current != null && i < position - 1) {
			current = current.next;
			i++;
		}
		if (current == null && current.next == null)
			return;

		Node<T> next = current.next.next;
		current.next = next;
	}

	public void display() {
		System.out.println("List (first --> last)");
		Node<T> current = head;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
	}

	public static void main(String arg[]) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addOrAppend(2);
		list.addOrAppend(3);
		list.addOrAppend(4);
		list.addOrAppend(5);
		list.addOrAppend(6);
		list.insert_at_first(1);
		// list.insert_at_nth(2, 8);
		list.deleteNth(1);
		// list.display();
		System.out.println("is empty SinglyLinkedList " + list.isEmpty());
		System.out.println("Length of SinglyLinkedList " + list.length());
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
