package algo.graph;

import java.util.Arrays;

public class GraphUtils {

    public static Node<String> graphBuilder(){
        Node<String> n1 = new Node<>("A");
        Node<String> n2 = new Node<>("B");
        Node<String> n3 = new Node<>("C");
        Node<String> n4 = new Node<>("D");
        Node<String> n5 = new Node<>("E");
        Node<String> n6 = new Node<>("F");
        Node<String> n7 = new Node<>("G");
        Node<String> n8 = new Node<>("H");
        Node<String> n9 = new Node<>("I");
        Node[] n1Neighbours = new Node[]{n2,n3,n5};
        n1.setNeighbours(Arrays.asList(n1Neighbours));
        Node[] n2Neighbours = new Node[]{n4,n5};
        n2.setNeighbours(Arrays.asList(n2Neighbours));
        Node[] n3Neighbours = new Node[]{n5,n6,n7};
        n3.setNeighbours(Arrays.asList(n3Neighbours));
        Node[] n4Neighbours = new Node[]{n8,n9};
        n4.setNeighbours(Arrays.asList(n4Neighbours));
        Node[] n6Neighbours = new Node[]{n4,n7,n8};
        n6.setNeighbours(Arrays.asList(n6Neighbours));
        Node[] n9Neighbours = new Node[]{n6};
        n9.setNeighbours(Arrays.asList(n9Neighbours));

        return n1;
    }
}
