package Homework5;

import java.util.logging.Level;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        Integer[] keys = { 49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99 };
        System.out.println("Inserting the following keys: ");
        for (Integer key : keys) {
            System.out.printf("%d ", key);
            tree.add(key);
        }

        System.out.print("\n\nPreorder traversal\n");
        tree.preorderTraversal();

        System.out.print("\n\nInorder traversal\n");
        tree.inorderTraversal();

        System.out.print("\n\nPostorder traversal\n");
        tree.postorderTraversal();

        System.out.print("\n\nTree contains: " + tree.contains(11));

        System.out.print("\n\nLevelorder traversal\n");
        tree.levelorderTraversal();
    }
}

//10.10 written responses
//1. a. preorder traversal: 49 28 18 11 19 40 32 44 83 71 69 72 97 92 99
//   b. inorder traversal: 11 18 19 28 32 40 44 49 69 71 72 83 92 97 99
//   c. postorder traversal: 11 19 18 32 44 40 28 69 72 71 92 99 97 83 49

//2. Changing the array order can change the traversal output
//   This is because the tree is build in the order of the array
//   The tree can only correct order locally (left subtree < root < right subtree)
//   For instance swapping 28 and 83 will produce the same output
//   But swapping 28 and 18 will produce different output as their roots are different