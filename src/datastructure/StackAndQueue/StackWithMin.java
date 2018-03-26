package StackAndQueue;

import java.util.Stack;
public class StackWithMin extends Stack<NodeWithMin> {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		int[] array = { 2, 1, 3, 1 };
		for (int value : array) {
			stack.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack.pop().value);
			System.out.println("New min is " + stack.min());
		}
	}

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}

}

class NodeWithMin {
	public int value;
	public int min;

	public NodeWithMin(int v, int min) {
		value = v;
		this.min = min;
	}
}