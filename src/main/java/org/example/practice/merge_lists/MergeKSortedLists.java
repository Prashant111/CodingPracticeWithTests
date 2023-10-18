package org.example.practice.merge_lists;


import org.example.data_structures.linked_list.LinkedList;
import org.example.data_structures.linked_list.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MergeKSortedLists {
    private final List<LinkedList<Integer>> linkedLists;

    public MergeKSortedLists(List<LinkedList<Integer>> linkedLists) {
        this.linkedLists = linkedLists;
    }

    public LinkedList<Integer> getOneSortedList() {
        return Optional.ofNullable(linkedLists)
                       .filter(lists -> !lists.isEmpty())
                       .map(this::mergeKLists)
                       .orElse(null);
    }

    private LinkedList<Integer> mergeKLists(List<LinkedList<Integer>> lists) {
        if (lists.size() == 1) {
            return lists.get(0);
        }

        int mid = lists.size() / 2;
        List<LinkedList<Integer>> leftLists = lists.subList(0, mid);
        List<LinkedList<Integer>> rightLists = lists.subList(mid, lists.size());

        LinkedList<Integer> mergedLeft = mergeKLists(leftLists);
        LinkedList<Integer> mergedRight = mergeKLists(rightLists);

        return mergeTwoSortedLists(mergedLeft, mergedRight);
    }

    private LinkedList<Integer> mergeTwoSortedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> mergeList = new LinkedList<>(-1);
        Node<Integer> firstListCurrentNode = list1.getHeadNode();
        Node<Integer> secondListCurrentNode = list2.getHeadNode();

        Node<Integer> mergeListIter = mergeList.getHeadNode();

        int sum = 0;
        int carry = 0;

        while (!allNodesEmpty(firstListCurrentNode, firstListCurrentNode) || carry > 0) {
            int n1 = getNumberFromList(firstListCurrentNode);
            int n2 = getNumberFromList(secondListCurrentNode);
            sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;

            mergeListIter.setNext(new Node<>(sum));
            mergeListIter = mergeListIter.getNext();

            firstListCurrentNode = getNextNode(firstListCurrentNode).orElse(null);
            secondListCurrentNode = getNextNode(secondListCurrentNode).orElse(null);

        }

        mergeList.setHead(mergeList.getHeadNode()
                                   .getNext());
        return mergeList;
    }

    private boolean allNodesEmpty(Node<?>... lists) {
        return Arrays.stream(lists)
                     .allMatch(Objects::isNull);
    }

    private int getNumberFromList(Node<Integer> node) {
        return Objects.nonNull(node) && Objects.nonNull(node.getVal()) ? node.getVal() : 0;
    }

    private Optional<Node<Integer>> getNextNode(Node<Integer> currentNode) {
        return Objects.nonNull(currentNode) ? Optional.ofNullable(currentNode.getNext()) : Optional.empty();
    }
}
