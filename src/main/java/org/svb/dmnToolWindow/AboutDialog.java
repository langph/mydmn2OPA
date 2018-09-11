package org.svb.dmnToolWindow;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class AboutDialog extends JDialog {


    public AboutDialog() {

        setTitle("About");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel name = new JLabel("DMN to OPA excel");
        name.setAlignmentX(0.5f);
        JLabel version = new JLabel("Version: 0.81");
        version.setAlignmentX(0.5f);
        JLabel author = new JLabel("By: Philip de Lang");
        author.setAlignmentX(0.5f);
        add(name);
        add(version);
        add(author);
        add(Box.createRigidArea(new Dimension(0, 60)));
        JButton close = new JButton("Close");
        close.setAlignmentX(0.5f);
        add(close);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
    }
}



