package algo.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopView<T> {

    public List<T> topViewOfBinaryTree(Node<T> root){
        if (root == null)
            return null;
        List<T> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        topViewOfBinaryTree(root, result, 0, seen);
        return result;
    }

    private void topViewOfBinaryTree(Node<T> root, List<T> result,
                                            int i, Set<Integer> seen) {
        if ( root == null)
            return;
        if (seen.add(i))
            result.add(root.getData());
        topViewOfBinaryTree(root.getLeft(), result, i-1, seen);
        topViewOfBinaryTree(root.getRight(), result, i+1, seen);
    }


    public static void main(String[] args) {
        TopView tv = new TopView<Integer>();
        List<Integer> topView = tv.topViewOfBinaryTree(getBinaryTree());
        System.out.println(topView);

        TopView tv2 = new TopView<String>();
        Node<String> root = BinaryTreeUtil.getBinaryTree2();
        List<String> topView2 = tv2.topViewOfBinaryTree(root);
        System.out.println(topView2);

    }

    private static Node<Integer> getBinaryTree(){
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(8);
        Node<Integer> n9 = new Node<>(9);
        Node<Integer> n10 = new Node<>(10);
        Node<Integer> n11 = new Node<>(11);
        Node<Integer> n12 = new Node<>(12);
        Node<Integer> n13 = new Node<>(13);
        Node<Integer> n14 = new Node<>(14);
        Node<Integer> n15 = new Node<>(15);
        Node<Integer> n16 = new Node<>(17);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n14);
        n4.setRight(n13);
        n5.setLeft(n11);
        n6.setLeft(n12);
        n6.setRight(n10);
        n7.setLeft(n8);
        n7.setRight(n9);
        n8.setLeft(n15);
        n8.setRight(n16);
        n10.setLeft(n14);

        Node<Integer> root = n1;
        return root;
    }

}
