package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {
    private JLayeredPane layeredPane;
    public MainWindow() {
//        setLayout(new GridLayout(1, 1));
        setLayout(null);
        setTitle("Discovery");
        setBounds(50,50,720,480 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        layeredPane = new JLayeredPane() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon("resources/WorldMap_Small.png");
                //设置图片大小跟随面板大小
                image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
                g.drawImage(image.getImage(), 0, 0, this);
            }
        };
        ImageIcon icon = new ImageIcon("resources/NodeOrange.png");
        JButton nodeOrange = new JButton(icon);
        nodeOrange.setBounds(10,10,10,10);
        nodeOrange.setFocusPainted(false);
        nodeOrange.setBorder(null);
        nodeOrange.setIcon(icon);
        this.add(nodeOrange);
//        JLabel label = new JLabel("hello");
//        label.setBounds(50,50,100,100);
////        layeredPane.add(nodeOrange, Integer.valueOf(10));
//        layeredPane.add(label, Integer.valueOf(20));
//        this.getContentPane().add(layeredPane);

    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
