package org.example.tree.base2;

public class Client {
    public static void main(String[] args) {
        Tree tree = new Tree(1);

        tree.left = new Tree(2);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.left.left.left = new Tree(8);
        tree.left.right.right = new Tree(9);

        tree.right = new Tree(3);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        tree.printPreOrderTraversal();
    }
}
