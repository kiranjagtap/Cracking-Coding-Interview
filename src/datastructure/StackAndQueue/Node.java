package StackAndQueue;

class Node<T> {
	public Node<T> above;
	public Node<T> below;
	T value;

	public Node(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node{" + "above=" + above + ", below=" + below + ", value="
				+ value + '}';
	}
}
