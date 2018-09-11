package org.svb.dmntools;

import javax.swing.*;
import java.awt.event.*;
import org.svb.dmnToolWindow.*;


class DMNToOPA {

    public static void main(String[] args) {

        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AboutDialog ad = new AboutDialog();
                ad.setVisible(true);
            }
        });

        menubar.add(file);
        menubar.add(help);

        JFrame frame = new JFrame("DMN to OPA Excel");
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menubar);

        MainWindow panel = new MainWindow();
        panel.setLayout(new SpringLayout());

       SpringUtilities.makeCompactGrid(panel,
                2, 2,  //rows, cols
                6, 6,  //initX, initY
                6, 6); //xPad, yPad
        frame.setSize(panel.getPreferredSize());
        frame.setSize(400, 130);
        frame.setLocation(150, 100);
        frame.getContentPane().add(panel,"Center");
        frame.setVisible(true);
    }

}
