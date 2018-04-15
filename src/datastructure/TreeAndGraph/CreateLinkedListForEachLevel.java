package TreeAndGraph;

import java.util.*;

import Utils.AssortedMethods;
import Utils.TreeNode;

/* given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists) 
 * 
 * @author Kiran Jagtap
 * */

public class CreateLinkedListForEachLevel {
	public  static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		/* "visit" the root */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null) {
			current.add(root);
		}

		while(current.size() > 0) {
			result.add(current); //add previous level
			LinkedList<TreeNode> parents = current; //go to next level
			current = new LinkedList<TreeNode>();
			for(TreeNode parent : parents) {
				/* visit the children */
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
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
		int length = arr.length;
		TreeNode node = new TreeNode().createTree(arr, length);
		ArrayList<LinkedList<TreeNode>> list = createLinkedList(node);
		for(LinkedList<TreeNode> tree : list){
			for(TreeNode n:tree){
				n.print();
			}
		}
	}

}
