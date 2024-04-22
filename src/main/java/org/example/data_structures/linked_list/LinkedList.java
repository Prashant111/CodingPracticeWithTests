package org.example.data_structures.linked_list;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LinkedList<T> {
    private Node<T> headNode;

    public LinkedList(T val) {
        this.headNode = new Node<>(val);
    }

    public LinkedList(List<T> values) {
        if (Objects.isNull(values) || values.isEmpty())
            return;
        headNode = new Node<>(values.getFirst());
        Iterator<T> iterator = values.iterator();
        Node<T> iter = headNode;
        while (iterator.hasNext()) {
            T next = iterator.next();
            iter.setNext(new Node<>(next));
            iter = iter.getNext();
        }
    }

    public void setHead(Node<T> node) {
        this.headNode = node;
    }

    public void setLastNode(Node<T> lastNode) {
        if (Objects.isNull(headNode))
            throw new RuntimeException("Can not set next to an empty node");

        Node<T> iter = headNode;
        while (Objects.nonNull(iter.getNext())) {
            iter = iter.getNext();
        }
        iter.setNext(lastNode);
    }

    public void setNextNode(Node<T> nextNode) {
        if (Objects.isNull(headNode))
            throw new RuntimeException("Can not set next to an empty node");

        headNode.setNext(nextNode);
    }

    public Node<T> getHeadNode() {
        return headNode;
    }

    public boolean isEmpty() {
        return Objects.isNull(headNode);
    }

    public void print() {
        System.out.println("headNode = " + headNode);
        Node<T> nodeIter = headNode;
        while (Objects.nonNull(nodeIter)) {
            System.out.print(nodeIter.getVal() + " -> ");
            nodeIter = nodeIter.getNext();
        }
        System.out.println("Null");
    }
}


