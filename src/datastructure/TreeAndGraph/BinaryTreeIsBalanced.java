package TreeAndGraph;

import Utils.TreeNode;

/* implement a function to check if a binary tree is balanced. For the purpose of this
 * question, a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one 
 * @author Kiran Jagtap
 * */

public class BinaryTreeIsBalanced {
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0; // base case
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) { // base case
			return true;
		}

		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else { // recurse
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public static void main(String[] args) {
		/*
		 * Construct Binary Tree from given Parent Array representation Given an
		 * array that represents a tree in such a way that array indexes are
		 * values in tree nodes and array values give the parent node of that
		 * particular index (or node). The value of the root node index would
		 * always be -1 as there is no parent for root. Construct the standard
		 * linked representation of given Binary Tree from this given
		 * representation.
		 * 
		 * Input: parent[] = {1, 5, 5, 2, 2, -1, 3} Output: root of below tree 5
		 * / \ 1 2 / / \ 0 3 4 / 6 Explanation: Index of -1 is 5. So 5 is root.
		 * 5 is present at indexes 1 and 2. So 1 and 2 are children of 5. 1 is
		 * present at index 0, so 0 is child of 1. 2 is present at indexes 3 and
		 * 4. So 3 and 4 are children of 2. 3 is present at index 6, so 6 is
		 * child of 3.
		 * 
		 * 
		 * Input: parent[] = {-1, 0, 0, 1, 1, 3, 5}; Output: root of below tree
		 * 0 / \ 1 2 / \ 3 4 / 5 / 6 Expected time complexity is O(n) where n is
		 * number of elements in given array.
		 */
		int arr[] = { 1, 5, 5, 2, 2, -1, 3 };
		int n = arr.length;
		TreeNode node = new TreeNode().createTree(arr, n);
		boolean flag = isBalanced(node);
		System.out.println(flag);
		node.print();
	}

}
