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
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// AssortedMethods.printIntArray(arr);
		TreeNode node = CreateMinimalBSTTree.createMinimalBST(arr);
		boolean flag = checkBST(node);
		System.out.println(flag);
		node.print();
	}

}
