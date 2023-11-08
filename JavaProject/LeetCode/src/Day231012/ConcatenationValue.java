package Day231012;

public class ConcatenationValue {
    public static final int[] nums = {7,52,3,2,4};

    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(nums));

    }

    public static long findTheArrayConcVal(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        long  concVal = 0;

        while(i<j){
            String  conc = String.valueOf(nums[i]) + String.valueOf(nums[j]);
            concVal += Long.parseLong(conc);
            i++;
            j--;
        }
        if(i == j) concVal+=nums[i];
        return concVal;
    }
}
