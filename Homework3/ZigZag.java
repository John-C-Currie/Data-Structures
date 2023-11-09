package Homework3;

public class ZigZag {
    //take a two dimensional array and print it out in a zig zag pattern
    //Start by declaring a sum variable and setting it to 0
    //Increment row by 1, then decrement row and increment column while it is still equal to the sum
    //If a value becomes less than 0 then it is time to switch incrementing and decrementing the other way around
    //If a value becomes greater than the length of the array then it is time to switch incrementing and decrementing the other way around
    //Repeat until the sum is equal to the length of the array
    
    public int[] zigZag(int[][] arr) {
        int[] result = new int[arr.length * arr[0].length];
        int row = 0; // Start with the first row
        int col = 0; // Start with the first column
        boolean up = false; // Start with incrementing row and decrementing column
        for (int i = 0; i < arr.length * arr[0].length; i++) {
            result[i] = arr[row][col];
            if (up) {
                row--;
                col++;
                if (row < 0 && col < arr[0].length) {
                    row = 0;
                    up = false;
                } else if (col >= arr[0].length) {
                    col = arr[0].length - 1;
                    row += 2;
                    up = false;
                }
            } else {
                row++;
                col--;
                if (col < 0 && row < arr.length) {
                    col = 0;
                    up = true;
                } else if (row >= arr.length) {
                    row = arr.length - 1;
                    col += 2;
                    up = true;
                }
            }
        }
        return result;
    }
    

    public static void main(String[] args) {
        ZigZag ex = new ZigZag();
        int[][] arr = {{1, 3, 4, 10}, {2, 5, 9, 11}, {6, 8, 12, 15}, {7, 13, 14, 16}};
        //This creates a 2D array that looks like this:
        //1  3  4  10
        //2  5  9  11
        //6  8  12 15
        //7  13 14 16
        int[] result = ex.zigZag(arr);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
