import java.util.Random;

public class ConvertSortedArrayBSTRandom {
    int[] nums;
    Random rand = new Random();

    public TreeNode helper(int left, int right){
        if (left > right) return null;
        int p = (left + right) / 2;
        if ((left + right) % 2 == 1) p += rand.nextInt(2);

        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums){
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
}
