package ru.vsu.cs;

import ru.vsu.cs.utils.BinaryTreeAlgorithms;

import java.awt.*;

public interface BinaryTree<T> {
    interface TreeNode<T> {
        T getValue();

        default TreeNode<T> getLeft() {
            return null;
        }

        default TreeNode<T> getRight() {
            return null;
        }

        default Color getColor() {
            return Color.BLACK;
        }

        default String toBracketStr() {
            return BinaryTreeAlgorithms.toBracketStr(this);
        }
    }

    TreeNode<T> getRoot();

    default String toBracketStr() {
        return this.getRoot().toBracketStr();
    }
}
