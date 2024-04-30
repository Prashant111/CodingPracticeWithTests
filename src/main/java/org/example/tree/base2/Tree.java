package org.example.tree.base2;

import java.util.Objects;

public class Tree {
    public int value;
    public Tree left;
    public Tree right;

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void printPreOrderTraversal() {
        printPreOrderTraversal(this);

    }
    private void printPreOrderTraversal(Tree tree) {
        if (Objects.isNull(tree))
            return;

        System.out.println(tree.value);
        printPreOrderTraversal(tree.left);
        printPreOrderTraversal(tree.right);
    }
}
