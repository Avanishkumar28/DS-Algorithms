package algo.trees;

import java.util.*;

public class SpiralTravelBinaryTree {

    public static List<String> spiralTravel(String root, Map<String, List<String>> tree){
        if (root == null)
            return null;
        List<String> result = new ArrayList<>();
        Stack<String> a = new Stack<>();
        Stack<String> b = new Stack<>();
        a.push(root);
        while (!a.isEmpty() || !b.isEmpty()){
            while (!a.isEmpty()){
                String current = a.pop();
                result.add(current);
                if (tree.get(current) != null){
                    if(tree.get(current).size() == 2){
                        //left
                        b.push(tree.get(current).get(0));
                        //right
                        b.push(tree.get(current).get(1));
                    }else {
                        //left
                        b.push(tree.get(current).get(0));
                    }
                }
            }
            while (!b.isEmpty()){
                String current = b.pop();
                result.add(current);
                if (tree.get(current) != null){
                    if(tree.get(current).size() == 2){
                        //right
                        a.push(tree.get(current).get(1));
                        //left
                        a.push(tree.get(current).get(0));
                    }else{
                        //left
                        a.push(tree.get(current).get(0));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> binaryTree  = new HashMap<>();
        binaryTree.put("A", Arrays.asList("B", "C"));
        binaryTree.put("B", Arrays.asList("D", "E"));
        binaryTree.put("C", Arrays.asList("F", "G"));
        binaryTree.put("D", null);
        binaryTree.put("E", Arrays.asList("H"));
        binaryTree.put("F", null);
        binaryTree.put("G", Arrays.asList("I"));
        binaryTree.put("H", null);
        binaryTree.put("I", null);

        System.out.println(spiralTravel("A", binaryTree));
    }
}
