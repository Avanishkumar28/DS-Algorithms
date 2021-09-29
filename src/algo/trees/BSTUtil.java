package algo.trees;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTUtil {

    public static Node<Integer> getBinaryTree1(){
        Node<Integer> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(7);
        Node<Integer> n4 = new Node<>(1);
        Node<Integer> n5 = new Node<>(4);
        Node<Integer> n6 = new Node<>(9);
        Node<Integer> n7 = new Node<>(3);
        Node<Integer> n8 = new Node<>(12);
        Node<Integer> n9 = new Node<>(15);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setRight(n6);
        n5.setLeft(n7);
        n6.setRight(n8);
        n8.setRight(n9);

        Node<Integer> root = n1;
        return root;
    }

    public static Node<Integer> getBinaryTree2(){
        Node<Integer> n1 = new Node<>(7);
        Node<Integer> n2 = new Node<>(4);
        Node<Integer> n3 = new Node<>(12);
        Node<Integer> n4 = new Node<>(2);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(9);
        Node<Integer> n7 = new Node<>(15);
        Node<Integer> n8 = new Node<>(1);
        Node<Integer> n9 = new Node<>(3);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n8);
        n4.setRight(n9);

        Node<Integer> root = n1;
        return root;
    }
    public static Node<Integer> getBinaryTree3(){
        Node<Integer> n1 = new Node<>(7);
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n3 = new Node<>(12);
        Node<Integer> n4 = new Node<>(2);
        Node<Integer> n5 = new Node<>(4);
        Node<Integer> n6 = new Node<>(9);
        Node<Integer> n7 = new Node<>(15);
        Node<Integer> n8 = new Node<>(1);
        Node<Integer> n9 = new Node<>(3);
        Node<Integer> n10 = new Node<>(2);
        Node<Integer> n11 = new Node<>(3);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n8);
        n4.setRight(n9);
        n5.setLeft(n10);
        n5.setRight(n11);

        Node<Integer> root = n1;
        return root;
    }

    public static List<Integer> treeLeftToRight(Node root){
        if (root == null)
            return null;
        List<Integer> leftToRight = new ArrayList<>();
        Queue<Node<Integer>> qA = new LinkedList<>();
        Queue<Node<Integer>> qB = new LinkedList<>();
        qA.add(root);

        while (!qA.isEmpty() || !qB.isEmpty()){
            leftToRightHelper(qA, qB, leftToRight);
            leftToRightHelper(qB, qA, leftToRight);
        }
        return leftToRight;
    }
    private static void leftToRightHelper(@NotNull Queue<Node<Integer>> currentQ,
                                          @NotNull Queue<Node<Integer>> nextQ,
                                          @NotNull List<Integer> result){
        while (!currentQ.isEmpty()){
            Node<Integer> current = currentQ.remove();
            result.add(current.getData());
            if (current.getLeft() != null)
                nextQ.add(current.getLeft());
            if (current.getRight() != null)
                nextQ.add(current.getRight());
        }
    }

    public static List<Integer> treeRightToLeft(Node root){
        if (root == null)
            return null;
        List<Integer> leftToRight = new ArrayList<>();
        Queue<Node<Integer>> qA = new LinkedList<>();
        Queue<Node<Integer>> qB = new LinkedList<>();
        qA.add(root);

        while (!qA.isEmpty() || !qB.isEmpty()){
            rightToLeftHelper(qA, qB, leftToRight);
            rightToLeftHelper(qB, qA, leftToRight);
        }
        return leftToRight;
    }
    private static void rightToLeftHelper(@NotNull Queue<Node<Integer>> currentQ,
                                          @NotNull Queue<Node<Integer>> nextQ,
                                          @NotNull List<Integer> result){
        while (!currentQ.isEmpty()){
            Node<Integer> current = currentQ.remove();
            result.add(current.getData());
            if (current.getRight() != null)
                nextQ.add(current.getRight());
            if (current.getLeft() != null)
                nextQ.add(current.getLeft());
        }
    }

    public static void main(String[] args) {
        Node root = getBinaryTree1();
        System.out.println("****************Tree Node Left to Right***************");
        List<Integer> leftToRight = treeLeftToRight(root);
        System.out.println(leftToRight);
        System.out.println("****************Tree Node Right to Left***************");
        Node root2 = getBinaryTree2();
        List<Integer> rightToLeft = treeRightToLeft(root2);
        System.out.println(rightToLeft);

    }
}
