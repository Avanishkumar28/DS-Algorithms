package algo.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data){
        this.data = data;
    }
    public Node(T data, T left, T right){
        this.data = data;
        this.left = new Node<T>(left);
        this.right = new Node<T>(right);
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
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
