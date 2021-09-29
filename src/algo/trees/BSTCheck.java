package algo.trees;

public class BSTCheck {

    public static boolean checkIfBST(Node<Integer> root){
        if (root == null) {
            return false;
        }
        if (root.getLeft() == null && root.getLeft() == null)
            return true;
        boolean left = true, right = true;
        if(root.getLeft() != null) {
            left = root.getLeft().getData() <= root.getData()
                    && checkIfBST(root.getLeft());
        }
        if(root.getRight() != null){
            right = root.getRight().getData() > root.getData()
                    && checkIfBST(root.getRight());
        }
        return left && right;
    }

    public static void main(String[] args) {
        Node<Integer> root = BSTUtil.getBinaryTree1();
        System.out.println(BSTUtil.treeLeftToRight(root));
        System.out.println(checkIfBST(root)); //true

        Node<Integer> root2 = BSTUtil.getBinaryTree2();
        System.out.println(BSTUtil.treeLeftToRight(root2));
        System.out.println(checkIfBST(root2)); //true

        Node<Integer> root3 = BSTUtil.getBinaryTree3();
        System.out.println(BSTUtil.treeLeftToRight(root3));
        System.out.println(checkIfBST(root3)); //true

    }
}
