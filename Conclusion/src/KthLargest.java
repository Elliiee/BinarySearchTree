public class KthLargest {
    private Node insertNode(Node root, int num){
        if (root == null) return new Node(num, 1);

        if (num < root.val)
            root.left = insertNode(root.left, num);
        else
            root.right = insertNode(root.right, num);

        root.cnt++;
        return root;
    }

    private int searchKth(Node root, int k){
        int m = root.right != null ? root.right.cnt : 0;
        if (k == m + 1) return root.val;
        if (k <= m)
            return searchKth(root.right, k);
        else
            return searchKth(root.left, k - (m + 1));
    }

    private Node root;
    private int m_k;

    public KthLargest(int k, int[] nums){
        root = null;
        for (int i = 0; i < nums.length; i++)
            root = insertNode(root, nums[i]);
        m_k = k;
    }

    public int add(int val){
        root = insertNode(root, val);
        return searchKth(root, m_k);
    }
}
