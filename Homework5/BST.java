package Homework5;

import java.util.Queue;

public class BST<Key extends Comparable> {
    private Node root;

    private class Node {
        Key key; // this node's data
        Node left, right; // this node's children

        // Constructor: initializes data and makes this a leaf node
        public Node(Key key) {
            this(key, null, null);
        }

        // Constructor: initializes node data and sets its subtrees
        public Node(Key key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    // Constructor: initializes an empty binary search tree
    public BST() {
    }

    // inserts a new node in the binary search tree (BST)
    public void add(Key key) {
        root = add(root, key);
    }

    // recursively adds a new node, preserving the BST property
    private Node add(Node node, Key key) {
        if (node == null)
            return new Node(key);
        int cmp = key.compareTo(node.key);
        if (cmp <= 0)
            node.left = add(node.left, key);
        else
            node.right = add(node.right, key);
        return node;
    }

    public Key contains(Key key) {
        return contains(root, key);
    }

    private Key contains(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node.key;
        else if (cmp < 0)
            return contains(node.left, key);
        else
            return contains(node.right, key);
    }

    // begin inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
    }

    // perform inorder traversal recursively
    private void inorderHelper(Node node) {
        if (node == null)
            return;
        inorderHelper(node.left); // traverse left subtree
        System.out.printf("%s ", node.key); // output node data
        inorderHelper(node.right); // traverse left subtree
    }

    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(Node node) {
        if (node == null)
            return;
        System.out.printf("%s ", node.key);
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    public void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(Node node) {
        if (node == null)
            return;
        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.printf("%s ", node.key);
    }

    public void levelorderTraversal() {
        Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.printf("%s ", node.key);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}
