public class DeleteInBSTRecursion {
    /*
    Find Successor
    In BST, successor of the root is the leftmost child in root's right subtree
     */
    private TreeNode findSuccessor(TreeNode root){
        TreeNode cur = root.right;
        while (cur != null && cur.left != null)
            cur = cur.left;

        return cur;
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return root;

        if (root.val == key){
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            TreeNode p = findSuccessor(root);
            root.val = p.val;
            root.right = deleteNode(root.right, p.val);

            return root;
        }

        if (key < root.val)
            root.right = deleteNode(root.right, key);
        else
            root.left = deleteNode(root.left, key);

        return root;
    }
}
