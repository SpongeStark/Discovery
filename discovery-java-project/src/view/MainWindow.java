package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JLayeredPane layeredPane;
    public MainWindow() {
        setLayout(new GridLayout(1, 1));
        setTitle("Discovery");
        setBounds(50,50,720,480 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JLabel label = new JLabel("hello");
        label.setBounds(50,50,100,100);
        layeredPane.add(label);
        add(layeredPane);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
