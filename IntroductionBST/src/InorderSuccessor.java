import java.util.ArrayDeque;

/*
There are 2 approaches, the second one can work for case 1 too, but the first approach for case 1 is faster.
So the solution is using 2 methods for 2 cases.
 */
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if (p.right != null){ // case 1: there is right child, so the successor is somewhere lower in the right subtree
            p = p.right; // go one step right
            while (p.left != null) // loop through left as far as you can
                p = p.left;
            return p;
        }

        // case 2: the successor is somewhere upper in the tree
        ArrayDeque<TreeNode> stack = new ArrayDeque<>(); // guess linked list works too
        int inorder = Integer.MIN_VALUE;

        // inorder traversal
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (inorder == p.val) return root;
            inorder = root.val;

            root = root.right;
        }
        return null;
    }
}
