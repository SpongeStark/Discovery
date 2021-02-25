package view.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TestWindow extends JFrame {

    JPanel mainPanel;
    JButton btn_showChat;


    public TestWindow(){
        super();
        initialize();
    }

    private void initialize(){
        // 设置窗口大小
        this.setSize(400,300);

        // 初始化mainPanel
        mainPanel = new JPanel();
        // 将mainPanel加入到window
        this.add(mainPanel);

        //初始化btn_showChat按钮
        btn_showChat = new JButton();
        btn_showChat.setText("show the chat window");
        btn_showChat.addActionListener(this::btn_SHowChat_Click);
        // 将btn_showChat加入到window
        mainPanel.add(btn_showChat);


    }

    public void showWindow(int x, int y){
        this.setLocation(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showWindow(Point p){
        showWindow(p.x, p.y);
    }

    public void btn_SHowChat_Click(ActionEvent e){
        TestChatForm testChatForm = new TestChatForm();
    }

}
