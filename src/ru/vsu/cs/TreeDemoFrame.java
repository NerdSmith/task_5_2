package ru.vsu.cs;

import javax.swing.*;

public class TreeDemoFrame extends JFrame{
    private JTextField BracketNotationTextField;
    private JButton buildATreeButton;
    private JPanel panelMain;
    private JPanel paintAreaPanel;

    public TreeDemoFrame() {
        super("Colored Tree Demonstration");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 400);
    }
}
