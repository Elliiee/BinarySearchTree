import java.util.ArrayList;

public class BSTIteratorFlattern {
    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIteratorFlattern(TreeNode root){
        this.nodesSorted = new ArrayList<>();
        this.index = -1;
        this._inorder(root);
    }

    private void _inorder(TreeNode root){
        if (root == null) return;
        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }

    // return the next smallest number
    // return the largest number if it's the last time call the method.
    public int next(){
        return this.nodesSorted.get(++this.index);
    }

    // return whether we have a next smallest number
    public boolean hasNext(){
        return this.index + 1 < this.nodesSorted.size();
    }

    /*
    !! inorder traversal of a BST gives us the elements in a sorted order
     */
}
