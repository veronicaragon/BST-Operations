class Operations {
  public static void main(String[] args) {
    System.out.println("---------------------------");

    BinarySearchTree bst = new BinarySearchTree();

    bst.insertBST(41);
    bst.insertBST(20);
    bst.insertBST(11);
    bst.insertBST(29);
    bst.insertBST(32);
    bst.insertBST(65);
    bst.insertBST(50);
    bst.insertBST(91);
    bst.insertBST(72);
    bst.insertBST(99);

    System.out.println("--------Printing BST: Inorder---------");
    bst.printInorder();
    System.out.println();

    System.out.println("--------Printing BST: Preorder-------");
    bst.printPreorder();
    System.out.println();

    System.out.println("--------Printing BST: Postorder-------");
    bst.printPostorder();
    System.out.println();

    int[] searchKeys = { 20, 11, 29, 32, 65, 50, 91, 41 };
    System.out.println("\n-----------Search Level----------------");
    for (int i = 0; i < searchKeys.length; i++)
      System.out.println("The search item: " + searchKeys[i] + " is in level: " + bst.searchLevel(searchKeys[i]));

    System.out.println("-----------Leaf Nodes----------------");
    System.out.println("\nThe number of leaf nodes: " + bst.numberOfLeaf());

    System.out.println("-----------Full Nodes----------------");
    System.out.println("\nThe number of nodes with both child: " + bst.countNodeWithLeftRight());

    System.out.println("-----------Tree Height----------------");
    System.out.println("The height of the tree is: " + bst.treeHeight());

    System.out.println("-----------Sum of values----------------");
    int sum1 = bst.sumBT();
    System.out.println("Sum of values in the binary tree: " + sum1);

    bst.insertBST(70);
    bst.insertBST(42);
    bst.insertBST(58);

    System.out.println("\n\n---Changes after adding more numbers ---\n\n");

    System.out.println("--------Printing BST: Inorder---------");
    bst.printInorder();
    System.out.println();

    System.out.println("--------Printing BST: Preorder-------");
    bst.printPreorder();
    System.out.println();

    System.out.println("--------Printing BST: Postorder-------");
    bst.printPostorder();
    System.out.println();

    int[] searchKey = { 70, 42 };
    System.out.println("\n-----------Search Level----------------");
    for (int i = 0; i < searchKey.length; i++)
      System.out.println("The search item: " + searchKey[i] + " is in level: " + bst.searchLevel(searchKey[i]));

    System.out.println("-----------Leaf Nodes----------------");
    System.out.println("\nThe number of leaf nodes: " + bst.numberOfLeaf());

    System.out.println("-----------Full Nodes----------------");
    System.out.println("\nThe number of nodes with both child: " + bst.countNodeWithLeftRight());

    System.out.println("-----------Tree Height----------------");
    System.out.println("The height of the tree is: " + bst.treeHeight());

    System.out.println("-----------Sum of values----------------");
    int sum2 = bst.sumBT();
    System.out.println("Sum of values in the binary tree: " + sum2);

    System.out.println("\n\n---Changes after deleteing some numbers ---\n\n");

    bst.delete(20);
    bst.delete(99);

    System.out.println("--------Printing BST: Inorder---------");
    bst.printInorder();
    System.out.println();

    System.out.println("--------Printing BST: Preorder-------");
    bst.printPreorder();
    System.out.println();

    System.out.println("--------Printing BST: Postorder-------");
    bst.printPostorder();
    System.out.println();

    int[] searchKey3 = { 20, 99 };
    System.out.println("\n-----------Search Level----------------");
    for (int i = 0; i < searchKey3.length; i++)
      System.out.println("The search item: " + searchKey3[i] + " is in level: " + bst.searchLevel(searchKey3[i]));

    System.out.println("-----------Leaf Nodes----------------");
    System.out.println("\nThe number of leaf nodes: " + bst.numberOfLeaf());

    System.out.println("-----------Full Nodes----------------");
    System.out.println("\nThe number of nodes with both child: " + bst.countNodeWithLeftRight());

    System.out.println("-----------Tree Height----------------");
    System.out.println("The height of the tree is: " + bst.treeHeight());

    System.out.println("-----------Sum of values----------------");
    int sum3 = bst.sumBT();
    System.out.println("Sum of values in the binary tree: " + sum3);

  }
}
