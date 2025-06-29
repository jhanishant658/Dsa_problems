class Solution {
    private TreeNode first;   // 1st node jiska value ulta mila
    private TreeNode middle;  // middle
    private TreeNode prev;    // previous node in in‑order
    private TreeNode last ;

    public void recoverTree(TreeNode root) {
        inorder(root);

       if (first != null && last != null) {
    int temp = first.val;
    first.val = last.val;
    last.val = temp;
} else if (first != null && middle != null) {
    int temp = first.val;
    first.val = middle.val;
    middle.val = temp;
}
    }

    // Standard DFS in‑order
    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Violation: prev ka value current se bada hona nahi chahiye
        if (prev != null && prev.val > node.val) {
            // pahli violation ⇒ first = prev
            if (first == null) {first = prev;
            middle = node ;}
            //aakhiri violation 
          else{last = node;}
        }
        prev = node;

        inorder(node.right);
    }
}
