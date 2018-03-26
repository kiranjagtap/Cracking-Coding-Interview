package StackAndQueue;

import java.util.EmptyStackException;

public class Stack<T> {
	public Node<T> top;
    public Node<T> bottom;
    public int size = 0;
    private int capacity;

    public Stack(){}
    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void join(Node<T> above, Node<T> below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(T v) {
        if (size >= capacity) return false;
        size++;
        Node<T> n = new Node<T>(v);
        if (size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        Node<T> t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeBottom() {
        Node<T> b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
