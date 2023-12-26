class BinarySearchTree {
  BTNode root; // The root of the Binary tree
  int count; // # of elements currently in the Binary tree

  //Constructors of the BT class
  BinarySearchTree() {
  }

  BinarySearchTree(int value) {
    root = new BTNode(value);
  }

  //@return # of nodes in the BT.
  public int size() {
    return countNodes(root);
  }
  private int countNodes(BTNode node) {
  	if (node == null) {
    	return 0;
    } //recrusively count nodes on left & right side(root already included)
    else { 
    	return 1 + countNodes(node.left) + countNodes(node.right);
    }
  }

  /* Insert the value in the BST & increase the count of nodes after insertion.
  @param value @return true if insertion is successful.*/
  public boolean insertBST(int value) {
  	root = insert(root, value);
    count++;
    return true;
  }
  private BTNode insert(BTNode root, int value) {
  	if (root == null) {    //insert into empty node
    	root = new BTNode(value);
      return root;
    }
    if (value < root.data) {		//insert into left side of parent
    	root.left = insert(root.left, value);
    }
    else if (value > root.data) {	//insert into right side of parent
    	root.right = insert(root.right, value);
    }
    return root;
  }

  /* Delete node in the BST for the given value. @param key
  @return level of the key, -1 if the key is not in the tree
  level starts at 0, that is, the root is at level 0*/
  public void delete(int key) {
  	root = deleteNode(root, key);
  }
	private BTNode deleteNode(BTNode root, int key) {
  	if (root == null) {	//base case
    	return root;
    }
    if (key < root.data) {	//deleted key is less than node
    	root.left = deleteNode(root.left, key); //recursively delete in the left subtree
    }
    else if (key > root.data) { //deleted key is more than node
    	root.right = deleteNode(root.right, key); //recursively delete in the right subtree
    }
    //if key is found, perform deletion
    else {	//node with only one child or no child
    	if (root.left == null) { 
      	return root.right;
      }
      else if (root.right == null) {	
      	return root.left;
      }
      //node with two children; find & delete node w smallest value from right
      root.data = minValue(root.right);
      root.right = deleteNode(root.right, root.data);
    }
    return root;
  }
	private int minValue(BTNode root) {
  	int minValue = root.data;
    while (root.left != null) {		//find smallest data from parent
    	minValue = root.left.data;
      root = root.left;
    }
    return minValue;
  }

  /*Print the BT using inorder traversal */
  public void printInorder() {
    inOrder(root);
    System.out.println();
  }
  private void inOrder(BTNode node) {
    if (node != null) {
    	inOrder(node.left);
    	System.out.print(node.data + " ");
    	inOrder(node.right);
    }
  }

  /*Print the BT using preorder traversal*/
  public void printPreorder() {
     preOrder(root);
    System.out.println();
  }
  private void preOrder(BTNode node) {
    if (node != null) {
      System.out.print(node.data + " ");
    	preOrder(node.left);
    	preOrder(node.right);
    }
  }

  /*Print the BT using postorder traversal*/
  public void printPostorder() {
    postOrder(root);
    System.out.println();
  }
  private void postOrder(BTNode node) {
    if (node != null) {
    	postOrder(node.left);
    	postOrder(node.right);
      System.out.print(node.data + " ");
    }
  }

  /*Search the BST for the given value. @param key
  @return level of the key, -1 if the key is not in the tree.
  Level starts at 0, that is, the root is at level 0.*/
  public int searchLevel(int key) {
    return searchLevel(root, key, 0);
  }
	private int searchLevel(BTNode root, int key, int level) {
  	if (root == null) {
    	return -1;	//key isn't in tree
    }
    if (root.data == key) {
    	return level;	//node and key are equal, return the current level
    }
    if (key < root.data) {  //key is less than node's data, search left subtree
    	return searchLevel(root.left, key, level + 1);
    }
    else { //key is more than node's data, search right subtree
    	return searchLevel(root.right, key, level + 1);
    }
  }

  /*Return # of leafs of the BT. A leaf node has no children
  @return number of leaf nodes in the tree (BT or BST).*/
  public int numberOfLeaf() {
    return countLeafNodes(root);
  }
	private int countLeafNodes(BTNode node) {
  	if (node == null) {	//base case
    	return 0;
    }
    if (node.left == null && node.right == null) { //no children
    	return 1;	//add one 
    }
    else {	//search left & right
    	return countLeafNodes(node.left) + countLeafNodes(node.right);
    }
  }

  /*Return count of all the nodes that have exactly two children in the BT.
  @return # of nodes with 2 child in the tree (BT or BST).*/
  public int countNodeWithLeftRight() {
    return twoChildren(root);
  }
  private int twoChildren(BTNode node) {
  	if (node == null) { 	//base case
    	return 0;
    }
    int count = 0;
    if (node.left != null && node.right != null) { //has 2 children
    	count++;		//add 1
    }
    //search left & right
    count += twoChildren(node.left) + twoChildren(node.right);
    return count;
  }

  /*Return the height of the (BT or BST).
  The furthest leaf node from the root has a height of 0.
  Every level before that has increasing heights, with the root
  having the most height.*/
  public int treeHeight() {
		return height(root);
  }
  
  private int height(BTNode node){
  	if (node == null) {
    	return -1;
  	}
  	int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    return 1 + Math.max(leftHeight, rightHeight);
  }

  /*Compute sum of all the data fields of all the nodes in the BST.
  @return the sum of all the values in the binary search tree.*/
  public int sumBT() {
    return sum(root);
  }
  private int sum(BTNode node){
  	if (node == null) {
      return 0;
    } //recursively add all the nodes
  	return node.data + sum(node.left) + sum(node.right);
  }
}