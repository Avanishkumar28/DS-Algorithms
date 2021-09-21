package algo.trees;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUtil {

    public static Node<String> getBinaryTree1(){
        Node<String> n1 = new Node<>("A");
        Node<String> n2 = new Node<>("B");
        Node<String> n3 = new Node<>("C");
        Node<String> n4 = new Node<>("D");
        Node<String> n5 = new Node<>("E");
        Node<String> n6 = new Node<>("F");
        Node<String> n7 = new Node<>("G");
        Node<String> n8 = new Node<>("H");
        Node<String> n9 = new Node<>("I");
        Node<String> n10 = new Node<>("J");
        Node<String> n11 = new Node<>("K");
        Node<String> n12 = new Node<>("L");
        Node<String> n13 = new Node<>("M");
        Node<String> n14 = new Node<>("N");
        Node<String> n15 = new Node<>("O");
        Node<String> n16 = new Node<>("P");
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n8);
        n4.setRight(n9);
        n5.setRight(n10);
        n6.setRight(n11);
        n7.setRight(n12);
        n9.setLeft(n13);
        n9.setRight(n14);
        n12.setLeft(n15);
        n12.setRight(n16);

        Node<String> root = n1;
        return root;
    }
    public static Node<String> getBinaryTree2(){
        Node<String> n1 = new Node<>("A");
        Node<String> n2 = new Node<>("B");
        Node<String> n3 = new Node<>("C");
        Node<String> n4 = new Node<>("D");
        Node<String> n5 = new Node<>("E");
        Node<String> n6 = new Node<>("F");
        Node<String> n7 = new Node<>("G");
        Node<String> n8 = new Node<>("H");
        Node<String> n9 = new Node<>("I");
        Node<String> n10 = new Node<>("J");
        Node<String> n11 = new Node<>("K");
        Node<String> n12 = new Node<>("L");
        Node<String> n13 = new Node<>("M");
        Node<String> n14 = new Node<>("N");
        Node<String> n15 = new Node<>("O");
        Node<String> n16 = new Node<>("P");
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n8);
        n4.setRight(n9);
        n5.setRight(n10);
        n6.setRight(n11);
        n9.setLeft(n13);
        n9.setRight(n12);
        n12.setLeft(n15);
        n12.setRight(n16);
        n13.setLeft(n14);

        Node<String> root = n1;
        return root;
    }

    public static List<String> treeLeftToRight(Node root){
        if (root == null)
            return null;
        List<String> leftToRight = new ArrayList<>();
        Queue<Node<String>> qA = new LinkedList<>();
        Queue<Node<String>> qB = new LinkedList<>();
        qA.add(root);

        while (!qA.isEmpty() || !qB.isEmpty()){
            leftToRightHelper(qA, qB, leftToRight);
            leftToRightHelper(qB, qA, leftToRight);
        }
        return leftToRight;
    }
    private static void leftToRightHelper(@NotNull Queue<Node<String>> currentQ,
                                   @NotNull Queue<Node<String>> nextQ,
                                   @NotNull List<String> result){
        while (!currentQ.isEmpty()){
            Node<String> current = currentQ.remove();
            result.add(current.getData());
            if (current.getLeft() != null)
                nextQ.add(current.getLeft());
            if (current.getRight() != null)
                nextQ.add(current.getRight());
        }
    }

    public static List<String> treeRightToLeft(Node root){
        if (root == null)
            return null;
        List<String> leftToRight = new ArrayList<>();
        Queue<Node<String>> qA = new LinkedList<>();
        Queue<Node<String>> qB = new LinkedList<>();
        qA.add(root);

        while (!qA.isEmpty() || !qB.isEmpty()){
            rightToLeftHelper(qA, qB, leftToRight);
            rightToLeftHelper(qB, qA, leftToRight);
        }
        return leftToRight;
    }
    private static void rightToLeftHelper(@NotNull Queue<Node<String>> currentQ,
                                          @NotNull Queue<Node<String>> nextQ,
                                          @NotNull List<String> result){
        while (!currentQ.isEmpty()){
            Node<String> current = currentQ.remove();
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
        List<String> leftToRight = treeLeftToRight(root);
        System.out.println(leftToRight);
        System.out.println("****************Tree Node Right to Left***************");
        List<String> rightToLeft = treeRightToLeft(root);
        System.out.println(rightToLeft);

    }
}
