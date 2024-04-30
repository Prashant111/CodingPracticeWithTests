package org.example.tree.base;

import java.util.Objects;

public class Tree {
    private final TreeNode head;

    public Tree(TreeNode head) {
        this.head = head;
    }

    public TreeNode getLeftNode() {
        return head.getLeft();
    }

    public TreeNode getRightNode() {
        return head.getRight();
    }

    public void setLeftNode(TreeNode treeNode) {
        head.setLeft(treeNode);
    }

    public void setRightNode(TreeNode treeNode) {
        head.setRight(treeNode);
    }

    public TreeNode getHead() {
        return head;
    }

    public void leftOrderTraversal(){
        leftOrderTraversal(head);
    }
    public void leftOrderTraversal(TreeNode treeNode){
        if (Objects.isNull(treeNode))
            return;
        System.out.println(treeNode.getValue());
        leftOrderTraversal(treeNode.getLeft());
        leftOrderTraversal(treeNode.getRight());
    }


}
