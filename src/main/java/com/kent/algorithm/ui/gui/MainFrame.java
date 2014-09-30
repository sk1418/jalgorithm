package com.kent.algorithm.ui.gui;

import com.kent.algorithm.ui.DemoType;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Kent
 * Created on 2014-09-30.
 */
public class MainFrame extends JFrame {

    private JList<DemoType> typeList;


    void init() {
        typeList = new JList<>(DemoType.values());
    }

    public MainFrame() throws HeadlessException {
        super("JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        pack();
        setSize(600, 400);
        setLocationRelativeTo(null);

        init();
        getContentPane().add(typeList, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);

    }

}

