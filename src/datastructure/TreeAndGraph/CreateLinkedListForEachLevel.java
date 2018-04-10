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
		int arr[] = {1,2,3,4,5,6,7,8,9};
		AssortedMethods.printIntArray(arr);
		TreeNode node = CreateMinimalBSTTree.createMinimalBST(arr);
		ArrayList<LinkedList<TreeNode>> list = createLinkedList(node);
		for(LinkedList<TreeNode> tree : list){
			for(TreeNode n:tree){
				n.print();
			}
		}
	}

}
