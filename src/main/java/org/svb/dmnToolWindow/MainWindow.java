package org.svb.dmnToolWindow;


import org.svb.dmntools.FunctionTranslator;
import org.svb.dmntools.opmWorkbookDmn11;
import org.svb.dmntools.opmWorkbookDmn12;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MainWindow extends JPanel implements ActionListener {

    JButton selectDMNFile;
    JFileChooser chooser;
    String choosertitle;
    JLabel result;
    JLabel path;
    JTextField pathToDocumentsFolder;
    ButtonGroup group;
    JRadioButton dmn11;
    JRadioButton dmn12;



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
        dmn11 = new JRadioButton("DMN 1.1");
        dmn12 = new JRadioButton("DMN 1.2");
        dmn12.setSelected(true);
        group = new ButtonGroup();
        group.add(dmn11);
        group.add(dmn12);
        add(dmn11);
        add(dmn12);
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

            FunctionTranslator ft = new FunctionTranslator();
            ft.createFunctionInstances();

           try {
            if (dmn11.isSelected()) {
                opmWorkbookDmn11.startConversion(opaExcelTemplate, opaExcelfile, xmlFile, ft);
            } else {
                opmWorkbookDmn12.startConversion(opaExcelTemplate, opaExcelfile, xmlFile, ft);
            }


        } catch (Exception ex) {
            result.setText("Error occurred");
            try {
                FileHandler handler = new FileHandler("default.log", true);
                Logger logger = Logger.getLogger("org.svb.dmnToolWindow");
                logger.addHandler(handler);
                logger.severe(ex.getMessage());

               } catch (IOException exc) {
                   exc.printStackTrace();
               }
            }
            result.setVisible(true);
        }
    }

    public Dimension getPreferredSize(){
            return new Dimension(200, 300);
        }
}


