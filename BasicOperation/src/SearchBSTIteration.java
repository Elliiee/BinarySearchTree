public class SearchBSTIteration {
    public TreeNode searchBST(TreeNode root, int target){
        TreeNode cur = root;
        while (cur != null && cur.val != target){
            if (target < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return cur;
    }
}
