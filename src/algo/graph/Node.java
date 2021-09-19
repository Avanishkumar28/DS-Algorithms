package algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<T> {
    private T data;
    private List<Node<T>> neighbours;

    public Node(T data){
        this.data = data;
    }
    public Node(T data, List<Node<T>> neighbors){
        this.data = data;
        this.neighbours = new ArrayList<Node<T>>(neighbors);
    }

    public T getData() {
        return data;
    }

    public List<Node<T>> getNeighbours() {
        if (neighbours == null)
            return new ArrayList<Node<T>>();
        return new ArrayList<Node<T>>(neighbours);
    }

    public void setNeighbours(List<Node<T>> neighbours) {
        if (neighbours == null)
            this.neighbours = null;
        this.neighbours = new ArrayList<Node<T>>(neighbours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Node["+ data +"]";
    }
}
