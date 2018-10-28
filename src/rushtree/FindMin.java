package rushtree;

public class FindMin {


    public int findMin(int[] nums) {


        int lowIndex = 0;
        int highIndex = nums.length - 1;
        for (; highIndex > lowIndex && nums[lowIndex] >= nums[highIndex]; ) {

            if (nums[lowIndex] == nums[highIndex]) {
                highIndex--;
                continue;
            }

            int midIndex = (lowIndex + highIndex) / 2;


            if (nums[midIndex] > nums[highIndex]) {
                lowIndex = midIndex + 1;
            } else
                highIndex = midIndex;
        }
        return nums[lowIndex];
    }

    public static void main(String[] args) {

        FindMin findMin = new FindMin();
        int nums[] = {0, 1, 1, 0};
        int nums1[] = {1, 0, 0, 1};
        int nums2[] = {1, 1, 0, 1, 1};
        System.out.println(findMin.findMin(nums));
        System.out.println(findMin.findMin(nums1));
        System.out.println(findMin.findMin(nums2));
        ;

    }


}
