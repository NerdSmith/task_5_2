package ru.vsu.cs;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                JFrame frameMain = new TreeDemoFrame();
                frameMain.setVisible(true);
        });
    }
}
