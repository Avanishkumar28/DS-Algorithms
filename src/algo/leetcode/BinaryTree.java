package algo.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class BinaryTree {
    private static TreeNode root;

    public TreeNode createTree(int[] nodeValues){
        if (nodeValues == null || nodeValues.length == 0)
            return root;

        for (int index = 0; index < nodeValues.length; index++){
            root = addNode(root, nodeValues[index]);
        }
        return root;
    }
    private TreeNode addNode(TreeNode current , int val){
        if (current == null) {
            current = new TreeNode(val);
            return current;
        }

        if(val <= current.val)
            current.left = addNode(current.left , val);
        else
            current.right = addNode(current.right , val);

        return current;
    }

    public void printTree(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        System.out.println("*******Binary Tree******");
        while (!q.isEmpty()){
            TreeNode current = q.poll();
            System.out.print(current.val +" ");
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
        }
        System.out.println();
    }
}
