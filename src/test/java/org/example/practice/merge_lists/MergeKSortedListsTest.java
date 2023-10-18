package org.example.practice.merge_lists;

import org.example.data_structures.linked_list.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {

    private MergeKSortedLists mergeKSortedLists;

    @BeforeEach
    void setUp() {
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LinkedList<Integer> list3 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        mergeKSortedLists = new MergeKSortedLists(Arrays.asList(list1, list2, list3));

    }

    @Test
    void getOneSortedList() {
        LinkedList<Integer> oneSortedList = mergeKSortedLists.getOneSortedList();
        oneSortedList.print();
    }
}