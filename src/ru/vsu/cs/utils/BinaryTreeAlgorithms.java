package ru.vsu.cs.utils;

import ru.vsu.cs.BinaryTree;

public class BinaryTreeAlgorithms {
    public static <T> String toBracketStr(BinaryTree.TreeNode<T> treeNode) {
        class Inner {
            void printTo(BinaryTree.TreeNode<T> node, StringBuilder sb) {
                if (node == null) {
                    return;
                }
                sb.append(node.getValue());
                if (node.getLeft() != null || node.getRight() != null) {
                    sb.append(" (");
                    printTo(node.getLeft(), sb);
                    if (node.getRight() != null) {
                        sb.append(", ");
                        printTo(node.getRight(), sb);
                    }
                    sb.append(")");
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        new Inner().printTo(treeNode, sb);

        return sb.toString();
    }
}
