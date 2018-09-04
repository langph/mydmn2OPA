package org.svb.dmntools;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import org.svb.dmnToolWindow.*;


class TestDmn2{

    public static void main(String[] args) {


        JFrame frame = new JFrame("DMN to OPA Excel");
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TestWindow panel = new TestWindow();
        panel.setLayout(new SpringLayout());

        SpringUtilities.makeCompactGrid(panel,
                2, 2,  //rows, cols
                6, 6,  //initX, initY
                6, 6); //xPad, yPad
        frame.setSize(panel.getPreferredSize());
        frame.setSize(400, 100);
        frame.setLocation(150, 100);
        frame.getContentPane().add(panel,"Center");
        frame.setVisible(true);
    }

}
