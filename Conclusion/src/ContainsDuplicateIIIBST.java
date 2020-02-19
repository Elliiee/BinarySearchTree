import java.util.TreeSet;

public class ContainsDuplicateIIIBST {
    /*
    dynamic data structure
    self-balanced binary search tree
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++){
            // find the Tth successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }

        return false;
    }
}
