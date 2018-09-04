package org.svb.dmnToolWindow;

import org.svb.dmn11.TDRGElement;
import org.svb.dmn11.TDefinitions;
import org.svb.dmntools.opmWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class TestWindow extends JPanel implements ActionListener {

    JButton selectDMNFile;
    JFileChooser chooser;
    String choosertitle;
    JLabel result;
    JLabel path;
    JTextField pathToDocumentsFolder;

    public TestWindow() {

        selectDMNFile = new JButton("Select DMN File");
        pathToDocumentsFolder = new JTextField("/Users/philipdelang/Documents",20);
        path = new JLabel("Path to Excel template");
        path.setLabelFor(pathToDocumentsFolder);
        result = new JLabel("Completed", JLabel.CENTER);
        setLayout(new SpringLayout());
        add(path);
        add(pathToDocumentsFolder);
        selectDMNFile.addActionListener(this);
        add(selectDMNFile);
        add(result);
        result.setVisible(false);


    }

        public void actionPerformed(ActionEvent e) {

            result.setVisible(false);
            chooser = new JFileChooser();
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

                opmWorkbook work = new opmWorkbook();
                File DMNfile = chooser.getSelectedFile();
                String SelectedDir = chooser.getCurrentDirectory().toString();
                File opaExcelTemplate = new File(SelectedDir + "/" + "dmn-opa.xlsx");
                File opaExcelfile = new File(SelectedDir + "/" + DMNfile.getName() + ".xlsx");
                File xmlFile = DMNfile;


                try {
                    JAXBContext jc = JAXBContext.newInstance("org.svb.dmn11");
                    Unmarshaller u = jc.createUnmarshaller();
                    JAXBElement je = (JAXBElement) u.unmarshal(xmlFile);
                    TDefinitions dmndef = (TDefinitions) je.getValue();
                    List<JAXBElement<? extends TDRGElement>> jes;
                    jes = dmndef.getDrgElement();
                    work.createOpmWorkbook(opaExcelTemplate, opaExcelfile, jes);
                    result.setVisible(true);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        }

        public Dimension getPreferredSize(){
            return new Dimension(200, 200);
        }
}


