package com.test.application.designPatten.creationalPattern.factoryMethodPattern.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsButton implements Button {

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;

    @Override
    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World");
        label.setOpaque(Boolean.TRUE);
        label.setBackground(new Color(235,233,126));
        label.setFont(new Font("Dialog",Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320,200);
        frame.setVisible(Boolean.TRUE);
        onClick();
    }

    @Override
    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(Boolean.FALSE);
                System.exit(0);
            }
        });
    }
}
