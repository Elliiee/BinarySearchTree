public class ContainsDuplicateIIIBruteF {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        for (int i = 0; i < nums.length; i++){
            // compare each element with the previous k elements and see if their difference is at most t
            for (int j = Math.max(i - k, 0); j < i; i++){
                if (Math.abs(nums[i] - nums[j]) <= t) return true;
            }
        }
        return false;
    }
}
