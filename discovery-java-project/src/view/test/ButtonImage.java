package view.test;

import javax.swing.*;
import java.awt.*;

public class ButtonImage {
    public ButtonImage() {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        button.setSize(10,10);
        ImageIcon icon = new ImageIcon("resources/NodeOrange.png");
        button.setIcon(icon);
        frame.add(button);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonImage();
    }
}