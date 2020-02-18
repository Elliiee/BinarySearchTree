import java.util.Stack;

public class BSTIteratorRecursion {
    Stack<TreeNode> stack;

    public BSTIteratorRecursion(TreeNode root){
        this.stack = new Stack<>();
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root){
        while (root != null){
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next(){
        TreeNode topmostNode = this.stack.pop();

        if (topmostNode.right != null){
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    public boolean hasNext(){
        return this.stack.size() > 0;
    }
}
