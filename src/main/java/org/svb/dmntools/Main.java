package org.svb.dmntools;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import org.svb.dmnToolWindow.*;


class TestDmn2{

    public static void main(String[] args) {

        JFrame frame = new JFrame("");
        TestWindow panel = new TestWindow();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        frame.getContentPane().add(panel,"Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }

}
