package algo.leetcode;

/**
 * 226. Invert Binary Tree (https://leetcode.com/problems/invert-binary-tree/)
        Given the root of a binary tree, invert the tree, and return its root.
* Example:
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]

        Input: root = [2,1,3]
        Output: [2,3,1]
 **/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;

        TreeNode newRoot = new TreeNode(root.val);
        if(root.left != null){
            newRoot.right = invertTree(root.left);
        }
        if(root.right != null){
            newRoot.left = invertTree(root.right);
        }
        return newRoot;
    }

    public static void main(String[] args) {
        int[] tree1Nodes = new int[]{4,2,7,1,3,6,9};
        BinaryTree bt = new BinaryTree();
        TreeNode tree1Root = bt.createTree(tree1Nodes);
        bt.printTree(tree1Root);
        TreeNode invertTree1 = invertTree(tree1Root); //[4,7,2,9,6,3,1]
        bt.printTree(invertTree1);
    }
}
