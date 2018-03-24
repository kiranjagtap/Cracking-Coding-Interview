package datastructure;

/*
 * @author Kiran Jagtap
 */
public class Node<T> {
	T data;
	Node next;
	public Node prev;
	public Node last;

	public void displayNode() {
		System.out.println("{ " + data + " }");
	}

	public Node() {
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	public Node(T d, Node n, Node p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}

	public void setNext(Node n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}

	public void setPrevious(Node p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}

	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
}
