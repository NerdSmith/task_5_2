package ru.vsu.cs.utils;

import ru.vsu.cs.BinaryTree;

import java.awt.*;
import java.util.ArrayList;

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

    /**
     * МОжно было бл*ть просто сразу сказать!?!?!?!?!?
     */

    public static ArrayList<Color> getColorsList(int height) {
        ArrayList<Color> colors = new ArrayList<>();
        double cof = 255. / height;
        for (int i = height; i >= 0; i--) {
            colors.add(new Color(255, (int) cof * i, 0));
        }
        return colors;
    }

    @FunctionalInterface
    public interface Visitor<T> {
        void visit(BinaryTree.TreeNode<T> node, int level);
    }

    public static <T> void setColors(BinaryTree.TreeNode<T> treeNode, ArrayList<Color> colors) {
        class SetColorVisitor implements Visitor<T> {
            private ArrayList<Color> colors;

            public SetColorVisitor(ArrayList<Color> colors) {
                this.colors = colors;
            }

            @Override
            public void visit(BinaryTree.TreeNode<T> node, int level) {
                node.setColor(colors.get(level));
            }
        }

        class Inner {
            void setColors(BinaryTree.TreeNode<T> node, Visitor<T> visitor, int level) {
                if (node == null) {
                    return;
                }
                visitor.visit(node, level);
                setColors(node.getLeft(), visitor, level + 1);
                setColors(node.getRight(), visitor, level + 1);
            }
        }
        new Inner().setColors(treeNode, new SetColorVisitor(colors), 0);
    }
}
