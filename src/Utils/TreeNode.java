package Utils;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int size = 0;

	public TreeNode(int data) {
		this.data = data;
		size = 1;
	}

	public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

	public void insertInOrder(int value) {
		if (value <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(value));
			} else {
				left.insertInOrder(value);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(value));
			} else {
				right.insertInOrder(value);
			}
		}
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isBST() {
		if (left != null) {
			if (data <= left.data || !left.isBST()) {
				return false;
			}
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}
		return true;
	}

	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d >= data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public void print() {
		BTreePrinter.printNode(this);
	}
}
