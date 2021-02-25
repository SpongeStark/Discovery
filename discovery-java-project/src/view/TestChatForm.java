package view;

import tools.JSON;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
        btn_refresh.addActionListener(this::btn_refresh_Click);
    }

    public void btn_refresh_Click(ActionEvent e) {
        String[] jsonArray = JSON.getStringArrayFromJSON("http://107.191.63.25/discovery/demo/get");
        for (String line : jsonArray){
            textArea.append(line+"\n");
        }
    }

}
