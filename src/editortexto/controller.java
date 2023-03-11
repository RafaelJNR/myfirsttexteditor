/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author usuario
 */
public class controller implements ActionListener {

    Frm frm = new Frm();
    int size = 12, style = 0;
    String fount = "Arial";
    
     

    String actualFile, actualFilePath;

    public controller() {
        frm.getBar().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        frm.getAbrir().addActionListener(this);
        frm.getGuardar().addActionListener(this);
        frm.getGuardarcomo().addActionListener(this);
        frm.getSalir().addActionListener(this);
        frm.getSalir().setBackground(Color.red);
        frm.getArial().addActionListener(new StyledEditorKit.FontFamilyAction(null, "Arial"));
        frm.getCourier().addActionListener(new StyledEditorKit.FontFamilyAction(null, "Courier"));
        frm.getVerdana().addActionListener(new StyledEditorKit.FontFamilyAction(null, "Verdana"));
        frm.getDoce().addActionListener(new StyledEditorKit.FontSizeAction(null, 12));
        frm.getDieciseis().addActionListener(new StyledEditorKit.FontSizeAction(null, 16));
        frm.getVeinticuatro().addActionListener(new StyledEditorKit.FontSizeAction(null, 24));
        frm.getCursiva().addActionListener(new StyledEditorKit.ItalicAction());
        frm.getNegrita().addActionListener(new StyledEditorKit.BoldAction());
        frm.getCopy().addActionListener(new StyledEditorKit.CopyAction());
        frm.getPaste().addActionListener(new StyledEditorKit.PasteAction());
        frm.getCut().addActionListener(new StyledEditorKit.CutAction());
        frm.getNombreArchivo().setEnabled(false);
        frm.getNombreArchivo().setBackground(Color.gray);
        frm.getNombreArchivo().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        frm.getLabel1().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        frm.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //BOTON SALIR
        if (e.getSource().equals(frm.getSalir())) {

            System.exit(0);

        }

        //BOTON ABRIR
        if (e.getSource().equals(frm.getAbrir())) {

            File file;
            JFileChooser fc = new JFileChooser();

            int opcion;
            String linea = "", texto = "";

            try {

                opcion = fc.showOpenDialog(frm);

                if (opcion == JFileChooser.APPROVE_OPTION) {

                    file = fc.getSelectedFile();
                    actualFile = file.getName();
                    actualFilePath = file.getAbsolutePath();
                    frm.getNombreArchivo().setText("Archivo: " + actualFilePath);
                    frm.getNombreArchivo().setEnabled(false);
                    frm.getNombreArchivo().setBackground(Color.GRAY);
                    FileReader flujo = new FileReader(file);
                    Scanner lector = new Scanner(flujo);
                    BufferedReader br = new BufferedReader(flujo);

                    while (lector.hasNext()) {
                        linea = lector.nextLine();
                        if (br.readLine() == null) {

                            linea += "\n";

                        }

                        texto += linea;

                        frm.getLabel1().setText(texto);

                    }

                    frm.getLabel1().setText(texto);

                    JOptionPane.showMessageDialog(null, "Archivo abierto correctamente");

                    br.close();
                    lector.close();
                    flujo.close();
                    System.gc();

                } else {

                    fc.cancelSelection();

                }

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(frm, "No se ha encontrado el archivo.");
            }

        }

        //BOTON GUARDAR
        if (e.getSource().equals(frm.getGuardar())) {

            File file;

            String linea = "";

            try {

                if (actualFilePath == null) {

                    int opcion;
                    JFileChooser fc = new JFileChooser();
                    opcion = fc.showSaveDialog(frm);

                    try {

                        if (opcion == JFileChooser.APPROVE_OPTION) {

                            file = fc.getSelectedFile();
                            actualFilePath = file.getAbsolutePath();
                            frm.getNombreArchivo().setText("Archivo: " + actualFilePath);
                            frm.getNombreArchivo().setEnabled(false);
                            if (!file.exists()) {
                                file.createNewFile();
                            }

                            FileWriter flujo = new FileWriter(file, true);
                            PrintWriter escritor = new PrintWriter(flujo);

                            linea = frm.getLabel1().getText();

                            escritor.print(linea);

                            escritor.close();
                            flujo.close();
                            System.gc();

                        }

                        if (opcion == JFileChooser.CANCEL_OPTION) {

                            fc.cancelSelection();

                        }

                    } catch (IOException ex) {

                        JOptionPane.showMessageDialog(frm, "No se ha encontrado el archivo.");

                    } catch (NullPointerException ee) {

                        JOptionPane.showMessageDialog(frm, "Guardado cancelado.");
                    }

                }
                file = new File(actualFilePath);
                frm.getNombreArchivo().setText("Archivo: " + actualFilePath);
                frm.getNombreArchivo().setEnabled(false);
                FileWriter flujo = new FileWriter(file, false);
                PrintWriter escritor = new PrintWriter(flujo);

                linea = frm.getLabel1().getText();

                escritor.print(linea);

                JOptionPane.showMessageDialog(frm, "Archivo guardado correctamente");

                escritor.close();
                flujo.close();
                System.gc();

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(frm, "No se ha encontrado el archivo.");
            }

        }

        //BOTON GUARDARCOMO
        if (e.getSource().equals(frm.getGuardarcomo())) {

            File file;
            int opcion;
            String linea = "";
            JFileChooser fc = new JFileChooser();
            opcion = fc.showSaveDialog(frm);

            try {

                if (opcion == JFileChooser.APPROVE_OPTION) {

                    file = fc.getSelectedFile();
                    actualFilePath = file.getAbsolutePath();

                    frm.getNombreArchivo().setText("Archivo: " + actualFilePath);
                    frm.getNombreArchivo().setEnabled(false);

                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter flujo = new FileWriter(file, true);
                    PrintWriter escritor = new PrintWriter(flujo);

                    linea = frm.getLabel1().getText();

                    escritor.print(linea);

                    JOptionPane.showMessageDialog(frm, "Archivo guardado correctamente");

                    escritor.close();
                    flujo.close();
                    System.gc();

                } else {

                    fc.cancelSelection();
                }

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(frm, "No se ha encontrado el archivo.");
            }

        }

    }
}
