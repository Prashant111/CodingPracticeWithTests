package org.example.tree;

import org.example.tree.base.Tree;
import org.example.tree.base.TreeNode;

public class Client {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        Tree tree = new Tree(head);

        head.setLeft(new TreeNode(2));
        head.getLeft().setLeft(new TreeNode(4));
        head.getLeft().getLeft().setLeft(new TreeNode(8));
        head.getLeft().getLeft().setRight(new TreeNode(9));
        head.getLeft().setRight(new TreeNode(5));
        head.setRight(new TreeNode(3));
        head.getRight().setLeft(new TreeNode(6));
        head.getRight().setRight(new TreeNode(7));

        tree.leftOrderTraversal();

    }
}
