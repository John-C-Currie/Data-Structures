public class Squash {

    public int[] squash(int nums[]){
        int flag = -1;
        int count = 0;
        int [] squashed = new int[nums.length];
        for(int i = 0; i < squashed.length; i++){
            squashed[i] = -1;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != flag){
                squashed[count] = nums[i];
                count++;
                flag = nums[i];
            }
        }
        return squashed;
    }
}
