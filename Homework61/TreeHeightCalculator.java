package Homework61;
import Helpers.In;

public class TreeHeightCalculator {
    //given a input file that contains two lines
    //the first line is the number of nodes in the tree
    //the second line is the parent of each node, represented as an array of intergers
    //each index is the data of the node, and the value at that index is the parent of that node
    //the root node has a parent of -1

    //this method will return the height of the tree
    public int getHeight(int size, int[]tree){
        int maxHeight = 0;
        for(int i = 0; i < size; i++){
            int height = 1;
            int parent = tree[i];
            while(parent != -1){
                height++;
                parent = tree[parent];
            }
            if(height > maxHeight){
                maxHeight = height;
            }
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        In in = new In("tree3.txt");
        int size = in.readInt();
        int[] tree = new int[size];
        for(int i = 0; i < size; i++){
            tree[i] = in.readInt();
        }
        TreeHeightCalculator thc = new TreeHeightCalculator();
        System.out.println(thc.getHeight(size, tree));
    }
}
