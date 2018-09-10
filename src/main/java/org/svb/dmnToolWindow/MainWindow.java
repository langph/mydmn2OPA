package org.svb.dmnToolWindow;


import org.svb.dmntools.opmWorkbook;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.awt.*;
import java.io.File;

public class MainWindow extends JPanel implements ActionListener {

    JButton selectDMNFile;
    JFileChooser chooser;
    String choosertitle;
    JLabel result;
    JLabel path;
    JTextField pathToDocumentsFolder;

    public MainWindow() {

        chooser = new JFileChooser();
        selectDMNFile = new JButton("Select DMN File");
        selectDMNFile.addActionListener(this);
        pathToDocumentsFolder = new JTextField(chooser.getFileSystemView().getDefaultDirectory().toString(),20);
        pathToDocumentsFolder.setEnabled(false);
        path = new JLabel("Path to dmn files");
        path.setLabelFor(pathToDocumentsFolder);
        result = new JLabel("Completed", JLabel.CENTER);
        setLayout(new SpringLayout());
        add(path);
        add(pathToDocumentsFolder);
        add(selectDMNFile);
        add(result);
        result.setVisible(false);

    }

    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());
        result.setVisible(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("DMN Files", "dmn");
        chooser.setCurrentDirectory(new java.io.File(pathToDocumentsFolder.getText()));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {


            File DMNfile = chooser.getSelectedFile();
            String SelectedDir = chooser.getCurrentDirectory().toString();
            File opaExcelTemplate = new File(SelectedDir + "/" + "dmn-opa.xlsx");
            File opaExcelfile = new File(SelectedDir + "/" + DMNfile.getName() + ".xlsx");
            File xmlFile = DMNfile;

            opmWorkbook.startConversion(opaExcelTemplate, opaExcelfile, xmlFile);
            result.setVisible(true);
        }
    }

    public Dimension getPreferredSize(){
            return new Dimension(200, 200);
        }
}


