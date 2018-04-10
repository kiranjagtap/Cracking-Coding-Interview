package TreeAndGraph;

import Utils.AssortedMethods;
import Utils.TreeNode;

/*
 * @author Kiran Jagtap
 */
public class CreateMinimalBSTTree {

	private static TreeNode createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		} else {
			int mid = (start + end) / 2;
			TreeNode node = new TreeNode(arr[mid]);
			node.setLeftChild(createMinimalBST(arr, start, mid - 1));
			node.setRightChild(createMinimalBST(arr, mid + 1, end));
			return node;
		}

	}

	public static TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		// int arr[] = AssortedMethods.randomArray(10, 0, 9);
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		AssortedMethods.printIntArray(arr);
		TreeNode node = CreateMinimalBSTTree.createMinimalBST(arr);
		node.print();
	}

}
