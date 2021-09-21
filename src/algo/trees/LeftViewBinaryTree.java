package algo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBinaryTree {

    public static List<String> leftView(Node<String> root){
        if (root == null)
            return null;
        List<String> result = new ArrayList<>();
        Queue<Node<String>> qA = new LinkedList<>();
        Queue<Node<String>> qB = new LinkedList<>();
        qA.add(root);

        while (!qA.isEmpty() || !qB.isEmpty()){
            helper(qA, qB, result, true);
            helper(qB, qA, result, true);
        }
        return  result;
    }
    private static void helper(Queue<Node<String>> currentQ, Queue<Node<String>> nextQ, List<String> result, boolean flag){
        while (!currentQ.isEmpty()){
            Node<String> current = currentQ.remove();
            if(flag){
                result.add(current.getData());
                flag = false;
            }
            if (current.getLeft() != null)
                nextQ.add(current.getLeft());
            if (current.getRight() != null)
                nextQ.add(current.getRight());
        }
    }

    public static void main(String[] args) {

        Node root = BinaryTreeUtil.getBinaryTree1();
        List<String> leftToRight = BinaryTreeUtil.treeLeftToRight(root);
        System.out.println(leftToRight);
        System.out.println("*****************");

        List<String> leftView = leftView(root);
        System.out.println(leftView);
    }
}
