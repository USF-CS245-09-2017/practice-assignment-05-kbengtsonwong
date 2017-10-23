
public class BSTree {
	
	// The tree designates a node as the root.
	private BSTNode root;
	class BSTNode {
		
		// Data members for each node.
		private String data;
		private BSTNode left;
		private BSTNode right;
		
		// Constructor
		public BSTNode(String value) {
			data = value;
			left = null;
			right = null;
		}
	}

	// Public signature to insert a new value into the tree.
	public void insert(String value) {
		insert(value, root);
	}
		
	// Private helper function to carry out insert task.
	private BSTNode insert(String value, BSTNode node) {
		// Base Case: Assume we found the right place to stick the value.
		// If the root is null, make a new node with value as the root.
		if (root == null) {
			root = new BSTNode(value);
		}
		if (node == null) {
			return new BSTNode(value); 
		}
			
		// Recursive Case: Need to traverse down the tree to find the right spot.
		if (value.compareTo(node.data) < 0) {
			node.left = insert(value, node.left);
			return node;
		} else {
			node.right = insert(value, node.right);
			return node;
		}
	}
	
	
	// Public boolean function that returns true if a value is in the tree; false otherwise.
	public boolean find(String value) {
		return find(value, root);
	}
	
	// Helper function for find, which utilizes the recursive nature of a tree.
	private boolean find(String value, BSTNode node) {
		// Base Case: Exhausted search down the tree, and the value is either found or not found.
		if (node == null) {
			return false;
		} if (value.compareTo(node.data) == 0) {
			return true;
		} 
		
		// Recursive Case: The searched value is greater or less than the current node's data, so traverse down the tree.
		else if (value.compareTo(node.data) < 0) {
			return find(value, node.left);
		} else {
			return find(value, node.right);
		}
		
	}
	
	
	// Public function to delete a node from the tree based on String value.
	public void delete(String value) {
		delete(value, root);
	}

	// Helper recursive function for delete.
	private BSTNode delete(String value, BSTNode node) {
		
		// Designate a boolean flag to allow modification of the root variable.
		boolean flag = false;
		if (node == root) {
			flag = true;
		}
		 // If the node doesn't exist return null.
        if (node == null) 
            return node;
        
        // If the value is greater than the current node's data.
        if (node.data.compareTo(value) < 0) 
        	node.right = delete(value, node.right);
        
        // If the value is lesser than the current node's data.
        else if (node.data.compareTo(value) > 0)
        		node.left = delete(value, node.left);
        
        // At this point, the node with value is found.
        
        // Node has no children.
        else if (node.left == null && node.right == null) {
        		node = null;
        }
        // Node has two children.
        else if (node.left != null && node.right != null) {
        		node.data = findMin(node.right).data;
        		node.right = delete(node.data, node.right);
        }
        // Node has one child.
        else {
        		if (node.left != null) {
        			node = node.left;
        		}
        		else if (node.right != null){   
        			node = node.right;
        		}
        }
        
        // Modify the root if the node in question is the root.
        if (flag)
        		root = node;
        
        return node;
	}

	// Helper function to the minimum value Node of a subtree.
	private BSTNode findMin(BSTNode node) {
		if (node == null) 
			return null;
		else if (node.left == null) 
			return node;
		return findMin(node.left);
	}

	// Public function returning a string of in-order traversal values of the tree.
	public String toStringInOrder() {
		 String inOrder = toStringInOrder(root);
		 return	inOrder.trim();
	}

	// Private helper function for in-order traversal.
	private String toStringInOrder(BSTNode node) {
		if (node == null)
			return "";
		return toStringInOrder(node.left) + node.data + " " + toStringInOrder(node.right);
	}
	
	// Public function returning a string of pre-order traversal values of the tree.
	public String toStringPreOrder() {
		String preOrder = toStringPreOrder(root);
		return preOrder.trim();
	}
	
	// Private helper function for pre-order traversal.
	private String toStringPreOrder(BSTNode node) {
		if (node == null)
			return "";
		return node.data + " " + toStringPreOrder(node.left) + toStringPreOrder(node.right);
	}
}