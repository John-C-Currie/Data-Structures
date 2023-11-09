import java.util.Arrays;

public class TestSquash{
    public static void main(String[] args) {
        Squash squash = new Squash();
        int[] nums = {2, 2, 2, 3, 3, 4, 5, 5, 4, 4};
        int[] squashed = squash.squash(nums);
        System.out.println(Arrays.toString(squashed)); // [2, 3, 4, 5, 4, -1, -1, -1, -1, -1]
    }
}