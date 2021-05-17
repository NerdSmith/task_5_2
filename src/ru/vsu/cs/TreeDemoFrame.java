package ru.vsu.cs;

import ru.vsu.cs.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeDemoFrame extends JFrame{
    private JTextField bracketNotationTextField;
    private JButton buildATreeButton;
    private JPanel panelMain;
    private JPanel paintAreaPanel;
    private JButton loadFromFileButton;

    private JPanel paintPanel;
    private SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>();

    public TreeDemoFrame() {
        super("Colored Tree Demonstration");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1200, 800);

        paintPanel = new JPanel() {
            private Dimension paintSize = new Dimension(0, 0);

            @Override
            public void paintComponent(Graphics gr) {
                super.paintComponent(gr);
                paintSize = BinaryTreePainter.paint(tree, gr);
                if (!paintSize.equals(this.getPreferredSize())) {
                    SwingUtils.setFixedSize(this, paintSize.width, paintSize.height);
                }
            }
        };
        JScrollPane paintJScrollPane = new JScrollPane(paintPanel);
        paintAreaPanel.add(paintJScrollPane);

        buildATreeButton.addActionListener(actionEvent -> {
            try {
                SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>(Integer::parseInt);
                tree.fromBracketNotation(bracketNotationTextField.getText());
                this.tree = tree;
                this.tree.setNodeColors();
                repaintTree();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        loadFromFileButton.addActionListener(actionEvent -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("./files"));
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                Scanner scanner;
                try {
                    scanner = new Scanner(new File(name));
                } catch (FileNotFoundException fileNotFoundException) {
                    return;
                }
                bracketNotationTextField.setText(scanner.nextLine());
            }
        });
    }
    public void repaintTree() {
        paintPanel.repaint();
    }
}
