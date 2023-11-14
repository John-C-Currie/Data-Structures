package Homework5;

public class BSTValidator {
    static class BST {
        Integer value; // this node's data
        BST left, right; // this node's children
        // Constructor: initializes data and makes this a leaf node

        public BST(Integer data) {
            this(data, null, null);
        }

        // Constructor: initializes node data and sets its subtrees
        public BST(Integer key, BST left, BST right) {
            this.value = key;
            this.left = left;
            this.right = right;
        }
    }

    // determines if tree is a valid BST
    public boolean validate(BST tree) {
        return validateHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateHelper(BST tree, Integer min, Integer max) {
        if (tree == null) return true;
        if (tree.value < min || tree.value > max) return false;
        return validateHelper(tree.left, min, tree.value) && validateHelper(tree.right, tree.value, max);
    }

    // Use the validate method to find the largest subtree that is a valid BST
    private int largestSubtree(BST tree){
        if (validate(tree)) {
            int size = size(tree);
            int leftSize = tree.left != null ? largestSubtree(tree.left) : 0;
            int rightSize = tree.right != null ? largestSubtree(tree.right) : 0;
            return Math.max(size, Math.max(leftSize, rightSize));
        } else {
            int leftSize = tree.left != null ? largestSubtree(tree.left) : 0;
            int rightSize = tree.right != null ? largestSubtree(tree.right) : 0;
            return Math.max(leftSize, rightSize);
        }
    }

    // helper method to calculate the size of a subtree
    private int size(BST tree) {
        if (tree == null) return 0;
        return 1 + size(tree.left) + size(tree.right);
    }
}

