package Utils;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int size = 0;

	public TreeNode(){}
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

	/*
	 * Creates tree from parent[0..n-1] and returns root of the created tree
	 */
	public TreeNode createTree(int arr[], int n) {
		// Create an array created[] to keep track
		// of created nodes, initialize all entries
		// as NULL
		TreeNode[] created = new TreeNode[n];
		for (int i = 0; i < n; i++)
			created[i] = null;

		for (int i = 0; i < n; i++)
			createNode(arr, i, created);

		return parent;
	}

	private void createNode(int[] arr, int i, TreeNode[] created) {

		// If this node is already created
		if (created[i] != null)
			return;

		// Create a new node and set created[i]
		created[i] = new TreeNode(i);

		// If 'i' is root, change root pointer and return
		if (arr[i] == -1) {
			parent = created[i];
			return;
		}

		// If parent is not created, then create parent first
		if (created[arr[i]] == null)
			createNode(arr, arr[i], created);

		// Find parent pointer
		TreeNode p = created[arr[i]];

		// If this is first child of parent
		if (p.left == null)
			p.left = created[i];
		else
			// If second child

			p.right = created[i];

	}

	void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	public void print() {
		BTreePrinter.printNode(this);
	}
}
