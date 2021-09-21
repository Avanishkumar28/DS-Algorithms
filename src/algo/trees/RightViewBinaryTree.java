package algo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {

    public static List<String> rightView(Node<String> root){
        if (root == null)
            return null;
        List<String> result = new ArrayList<>();
        Queue<Node> qA = new LinkedList<>();
        Queue<Node> qB = new LinkedList<>();
        qA.add(root);

        while (!qA.isEmpty() || !qB.isEmpty()){
            rightViewHelper(qA, qB, result, true);
            rightViewHelper(qB, qA, result, true);
        }
        return result;
    }
    private static void rightViewHelper(Queue<Node> currentQ,
                                        Queue<Node> nextQ,
                                        List<String> result, boolean flag){
        while (!currentQ.isEmpty()){
            Node<String> current = currentQ.remove();
            if (flag)
                result.add(current.getData());
            flag = false;
            if (current.getRight() != null)
                nextQ.add(current.getRight());
            if (current.getLeft() != null)
                nextQ.add(current.getLeft());

        }
    }

    public static void main(String[] args) {
        Node<String> root = BinaryTreeUtil.getBinaryTree2();
        List<String> rightViewNodes = rightView(root);
        System.out.println(rightViewNodes);
    }
}
