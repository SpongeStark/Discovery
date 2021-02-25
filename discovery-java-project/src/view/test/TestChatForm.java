package view.test;

import tools.JSON;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TestChatForm {
    private JTextArea textArea;
    private JButton btn_refresh;
    private JButton btn_send;
    private JPanel mainPanel;
    private JTextField text;

    public TestChatForm(){
        JFrame frame = new JFrame("Test Chat Form");
        frame.setContentPane( mainPanel);
        frame.pack();
        frame.setVisible(true);
        btn_refresh.addActionListener((e) -> {refreshMessages();});
        btn_send.addActionListener((e) -> {send();});
        // 默认焦点指定到输入框
        text.requestFocus();
        // 创建多线程，并指定run函数
        Thread thread = new Thread(this::refreshWithThread);
        // 开启多线程
        thread.start();
        // 设置回车发送信息
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == '\n') {
                    send();
                }
            }
        });
    }

    public void refreshMessages(){
        // 从服务器获得消息
        String[] jsonArray = JSON.getStringArrayFromJSON("http://107.191.63.25/discovery/demo/get");
        // 清空消息列表
        textArea.setText("");
        // 重新写入消息
        for (String line : jsonArray){
            textArea.append(line+"\n");
        }
    }

    public void refreshWithThread(){
        while (true){
            refreshMessages();
            // 间隔1秒，刷新一次
            try { Thread.sleep(1000); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    public void send(){
        // 获得输入的字符串
        String message = text.getText().trim();
        // 查空
        if(!message.equals("")){
            try {
                // 发送http请求
                JSON.requestURL("http://107.191.63.25/discovery/demo?message="+message);
                // 清空输入框
                text.setText("");
                // 刷新消息列表
                refreshMessages();
            } catch (IOException | InterruptedException x) {
                x.printStackTrace();
            }
        }
    }
}
