package TreeAndGraph;

import Utils.TreeNode;

/* implement a function to check if a binary tree is a binary search tree 
 * 
 * @author Kiran Jagtap
 * */

public class ValidBinarySearchTree {
	static boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}

	static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}

		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
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
		boolean flag = checkBST(node);
		System.out.println(flag);
		node.print();
	}

}
