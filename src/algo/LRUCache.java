package algo;

import java.util.Map;

public class LRUCache<T> {

    private final int capacity;
    private int size;
    private Map<String, Node> map;
    private DoublyLinkedList nodeList;

    public LRUCache(final int capacity){
        this.capacity = capacity;
    }

    public T get(final String key){
        if (map.containsKey(key)){
            Node node = map.get(key);
            //make this node head
            nodeList.moveNodeToHead(node);
            return node.value;
        }else
            return null;

    }
    public void put(final String key, final T value){
        Node currentNode = map.get(key);
        if (currentNode != null){
            currentNode.value = value;
            //make this node head
            nodeList.moveNodeToHead(currentNode);
            return;
        }
        if (size == capacity){
            //remove least recently used node (tail)
            String tailNodeKey = nodeList.getTailNodeKey();
            nodeList.removeNodeFromTail();
            map.remove(tailNodeKey);
            size--;
        }
        Node node = new Node(key, value);
        //add new node to head
        nodeList.addNodeToHead(node);
        map.put(key, node);
        size++;
    }

    private class DoublyLinkedList {
        private Node head, tail;
        DoublyLinkedList(){
            head = tail = null;
        }

        public void addNodeToHead(final Node node) {
            if (head == null){
                head = tail = node;
                return;
            }
            node.next = head;
            head.prev = node;
            head = node;
        }
        public void moveNodeToHead(final Node node){
            if (head == node)
                return;
            if (node == tail){
                tail = tail.prev;
                tail.next = null;
            }else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        public void removeNodeFromTail(){
            if (tail == null)
                return;
            if (head == tail){
                head = tail = null;
            }else {
                tail = tail.prev;
                tail.next = null;
            }

        }

        public String getTailNodeKey() {
            return tail.key;
        }

    }

    private class Node{
        String key;
        T value;
        Node prev, next;

        Node(String key, T value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
