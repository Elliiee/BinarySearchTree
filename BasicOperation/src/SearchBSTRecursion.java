
public class SearchBSTRecursion {
    public TreeNode searchBST(TreeNode root, int target){
        if (root == null || root.val == target)
            return root;

        if (target < root.val)
            return searchBST(root.left, target);

        return searchBST(root.right, target);
    }
}
