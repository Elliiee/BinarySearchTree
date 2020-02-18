public class LowestCommonAncestorBSTIteration {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        int pVal = p.val;
        int qVal = q.val;

        TreeNode node = root;

        while (node != null){
            int curVal = node.val;
            if (pVal > curVal && qVal > curVal){
                node = node.right;
            }
            else if (pVal < curVal && qVal <curVal){
                node = node.left;
            }
            else {
                return node;
            }
        }

        return null;
    }
}
