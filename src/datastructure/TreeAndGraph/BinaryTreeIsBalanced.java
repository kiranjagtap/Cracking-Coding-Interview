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
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// AssortedMethods.printIntArray(arr);
		TreeNode node = CreateMinimalBSTTree.createMinimalBST(arr);
		boolean flag = isBalanced(node);
		System.out.println(flag);
		node.print();
	}

}
