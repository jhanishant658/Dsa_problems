class Solution {
    private TreeNode first;   // 1st node jiska value ulta mila
    private TreeNode second;  // 2nd node
    private TreeNode prev;    // previous node in in‑order

    public void recoverTree(TreeNode root) {
        inorder(root);

        // do value swap
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    // Standard DFS in‑order
    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Violation: prev ka value current se bada hona nahi chahiye
        if (prev != null && prev.val > node.val) {
            // pahli violation ⇒ first = prev
            if (first == null) first = prev;
            // har violation par second = current
            second = node;
        }
        prev = node;

        inorder(node.right);
    }
}
