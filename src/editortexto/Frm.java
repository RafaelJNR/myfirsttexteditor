/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author usuario
 */
public class Frm extends JFrame {

    private JTextPane label1 = new JTextPane();
    private JScrollPane sp = new JScrollPane(label1);

    //DEFINIMOS LA LAMINA QUE CONTENDRÁ LA LAMINA DEL MENÚ
    private JPanel laminamenu = new JPanel();

    //DEFINIMOS LA BARRA QUE CONTENDRÁ DEL MENÚ SUPERIOR
    private JMenuBar bar = new JMenuBar();

    //DEFINIMOS LAS OPCIONES QUE CONTENDRÁ LA BARRA DEL MENÚ
    private JMenu fount = new JMenu("Fuente");

    //DEFINIMOS LAS OPCIONES DENTRO DE FUENTE
    private JMenuItem arial = new JMenuItem("Arial");
    private JMenuItem courier = new JMenuItem("Courier");
    private JMenuItem verdana = new JMenuItem("Verdana");

    //----------------------------------------
    private JMenu style = new JMenu("Estilo");

    //DEFINIMOS LAS OPCIONES DENTRO DE ESTILO
    private JMenuItem negrita = new JMenuItem("Negrita");
    private JMenuItem cursiva = new JMenuItem("Cursiva");

    //---------------------------------------
    private JMenu size = new JMenu("Tamaño");

    //DEFINIMOS LAS OPCIONES DENTRO DE TAMAÑO
    private JMenuItem doce = new JMenuItem("12");
    private JMenuItem dieciseis = new JMenuItem("16");
    private JMenuItem veinticuatro = new JMenuItem("24");
    
    //----------------------------------------
    private JMenu system = new JMenu("Sistema");
    
    //DEFINIMOS LAS OPCIONES DENTRO DE SISTEMA
    private JMenuItem abrir = new JMenuItem("Abrir");
    private JMenuItem guardar = new JMenuItem("Guardar");
    private JMenuItem guardarcomo = new JMenuItem("Guardar Como");
    private JMenuItem salir = new JMenuItem("Salir");
    
    //----------------------------------------
    private JMenu file = new JMenu("Archivo");
    
    //DEFINIMOS LAS OPCIONES DENTRO DE SISTEMA
    private JMenuItem copy = new JMenuItem("Copiar");
    private JMenuItem cut = new JMenuItem("Cortar");
    private JMenuItem paste = new JMenuItem("Pegar");
    
    
    //----------------------------------------------
    //DEFINIMOS LA LAMINA QUE CONTENDRÁ LA LAMINA DEL MENÚ INFERIOR
    private JPanel laminamenuinf = new JPanel();
    //DEFINIMOS LA BARRA QUE CONTENDRÁ DEL MENÚ Inferior
    private JMenuBar barInf= new JMenuBar();
    private JTextPane nombreArchivo = new JTextPane();
    
    //----------------------------------------------
    

    public Frm() {
        
        this.setLayout(null);
        this.setExtendedState(ICONIFIED);       //establecemos que la apliaccion pueda maximizarse o minimizarse
        this.setResizable(true);                //establecemos que la aplicación sea redimencionable
        this.setSize(750, 750);                 //por defecto al usarla modo ventana tendrá estas medidas

        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(laminamenu, BorderLayout.NORTH);    //añadimos la lamina para el menu en el borde de arriba y sus botones
        laminamenu.add(bar);                    //añadimos la barra y sus opciones
        bar.add(system);                        //añadimos la opcion sistema y sus opciones
        system.add(abrir);
        system.add(guardar);
        system.add(guardarcomo);
        system.add(salir);
        bar.add(system);                        //añadimos la opcion sistema y sus opciones
        system.add(abrir);
        system.add(guardar);
        system.add(guardarcomo);
        system.add(salir);
        bar.add(file);                          //añadimos la opcion archivo y sus sistemas
        file.add(copy);
        file.add(cut);
        file.add(paste);
        bar.add(style);                         //añadimos la opcion estilo y sus opciones
        style.add(negrita);
        style.add(cursiva);
        bar.add(fount);                         //añadimos la opcion fuente y sus opciones
        fount.add(arial);
        fount.add(courier);
        fount.add(verdana);
        bar.add(size);                          //añadimos la opcion tamaño y sus opciones
        size.add(doce);
        size.add(dieciseis);
        size.add(veinticuatro);
        add(laminamenuinf, BorderLayout.SOUTH);
        laminamenuinf.add(barInf);
        barInf.add(nombreArchivo);
    }

    public JTextPane getNombreArchivo() {
        return nombreArchivo;
    }
    
    public JMenuItem getAbrir() {
        return abrir;
    }


    public JMenu getFile() {
        return file;
    }

    public JMenuItem getCopy() {
        return copy;
    }

    public JMenuItem getCut() {
        return cut;
    }

    public JMenuItem getPaste() {
        return paste;
    }

    
    
    public JMenuItem getGuardar() {
        return guardar;
    }

    public JMenuItem getGuardarcomo() {
        return guardarcomo;
    }

    public JMenuItem getSalir() {
        return salir;
    }

    public JTextPane getLabel1() {
        return label1;
    }

    public JScrollPane getSp() {
        return sp;
    }

    public JPanel getLaminamenu() {
        return laminamenu;
    }

    public JMenuBar getBar() {
        return bar;
    }

    public JMenu getFount() {
        return fount;
    }

    public JMenuItem getArial() {
        return arial;
    }

    public JMenuItem getCourier() {
        return courier;
    }

    public JMenuItem getVerdana() {
        return verdana;
    }

    public JMenu getStyle() {
        return style;
    }

    public JMenuItem getNegrita() {
        return negrita;
    }

    public JMenuItem getCursiva() {
        return cursiva;
    }

    public JMenuItem getDoce() {
        return doce;
    }

    public JMenuItem getDieciseis() {
        return dieciseis;
    }

    public JMenuItem getVeinticuatro() {
        return veinticuatro;
    }

    public JMenu getSystem() {
        return system;
        
    }

    public void setSp(JScrollPane sp) {
        this.sp = sp;
    }

    
    
}
