/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Javier de la Llave
 *
 * Clase que extiende JFrame donde creamos la interfaz de nuestra aplicación y
 * damos funcionalidad a los botones
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Archivo abierto en nuestro editor
    private File archivoAbierto;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        colocarInterfaz();

    }

    /*
      Ajustamos algunos elementos de la interfaz
     */
    private void colocarInterfaz() {
        //Centramos el texto del label con el nombre del archivo
        label_nombre.setHorizontalAlignment(JLabel.CENTER);

        //Para que aparezca centrada la aplicación al abrirla
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        //Ponemos título y logo a la aplicación
        setTitle("Editor de texto");
        setIconImage(new ImageIcon(getClass().getResource("./img/logo.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaPrincipal = new javax.swing.JTextArea();
        btn_abrir = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_guardar_como = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        label_nombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaPrincipal.setColumns(20);
        jTextAreaPrincipal.setRows(5);
        jScrollPane1.setViewportView(jTextAreaPrincipal);

        btn_abrir.setText("Abrir");
        btn_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_guardar_como.setText("Guardar como");
        btn_guardar_como.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_comoActionPerformed(evt);
            }
        });

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        label_nombre.setText("Sin título");
        label_nombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_guardar_como, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_abrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guardar_como, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Al pulsar el botón de abrir, se abre un jFileChooser y al elegir un archivo 
    //Se pinta en el jTextAreaPrincipal
    private void btn_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirActionPerformed

        try {
            
            JFileChooser chooser = new JFileChooser();

            //Establecemos un filtro para que muestre archivos xml y txt
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "xml", "txt");
            chooser.setFileFilter(filter);

            chooser.setMultiSelectionEnabled(false);

            chooser.setDialogType(JFileChooser.OPEN_DIALOG);           

            int returnVal = chooser.showOpenDialog(null);
            
            guardarCambios();

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                //pongo el archivo en pantalla
                pintarArchivo(chooser);
                //Pongo el nombre del archivo en la interfaz
                archivoAbierto = chooser.getSelectedFile();
                ponerNombre();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_btn_abrirActionPerformed

    //Guarda el texto que haya en pantalla y te deja elegir dónde guardarlo y con qué nombre
    private void btn_guardar_comoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_comoActionPerformed

        try {

            JFileChooser chooser = new JFileChooser();

            int retrival = chooser.showSaveDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {

                //Para asegurarnos de que tiene una extensión txt o xml
                String nombre = chooser.getSelectedFile().getName();
                String extension = nombre.substring(nombre.lastIndexOf('.') + 1, nombre.length());
                if (extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("xml")) {//Si la extensión es válida 

                    if (sustituirArchivo(chooser.getSelectedFile())) {

                        archivoAbierto = chooser.getSelectedFile();
                        ponerNombre();
                        escribirArchivo();

                    }

                } else {//Si la extensión no es valida sale un aviso
                    JOptionPane.showMessageDialog(null, "Introduce una extensión válida", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


    }//GEN-LAST:event_btn_guardar_comoActionPerformed

    //Si se está trabajando con un archivo previamente guardado, te lo guarda en ese archivo,
    //si no, te redirije a guardar como
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        if (archivoAbierto != null) {//Si hay algún archivo abierto

            escribirArchivo();

        } else {
            btn_guardar_comoActionPerformed(evt);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    //Al pulsar nuevo pueden pasar varias cosas:
    //Si no había ningún archivo abierto y la pantalla esta en blanco no hace nada
    //si hay un archivo abierto te da la posibilidad de guardar los cambios en ese archivo o no
    //si no hay un archivo abierto, pero hay algo escrito en la pantalla te da la posibilidad de guardar como
    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        int opcionElegida;//Guardar la opción elegida en el cuadro de dialogo.

        if (archivoAbierto != null) {//Si hay un archivo abierto
            opcionElegida = JOptionPane.showConfirmDialog(null, "¿Guardar los cambios realizados?", "Aviso", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            //0=yes, 1=no, 2=cancel
            if (opcionElegida == 0) {
                escribirArchivo();

            }
            if (opcionElegida == 1 || opcionElegida == 0) {
                //Ponemos la pantalla blanca y no hay ningún archivo abierto
                jTextAreaPrincipal.setText("");
                archivoAbierto = null;
                ponerNombre();
            }
        } else if (jTextAreaPrincipal.getText().length() > 0) {//En caso de que no haya un archivo abierto pero se haya escrito algo
            opcionElegida = JOptionPane.showConfirmDialog(null, "¿Guardar archivo creado?", "Aviso", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            //0=yes, 1=no, 2=cancel
            if (opcionElegida == 0) {
                btn_guardar_comoActionPerformed(evt);

            }
            if (opcionElegida == 1 || opcionElegida == 0) {
                //Ponemos la pantalla blanca y no hay ningún archivo abierto
                jTextAreaPrincipal.setText("");
                archivoAbierto = null;
                ponerNombre();
            }
        }
    }//GEN-LAST:event_btn_nuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    //Escribe en el jTextAreaPrincipal el documento que hemos abierto
    //Recibe un JFileChooser que llamamos "c" como argumento con el
    //archivo que hay que pintar
    private void pintarArchivo(JFileChooser c) {

        try {
            File selectedFile = c.getSelectedFile();

            BufferedReader br = new BufferedReader(new FileReader(selectedFile));

            String texto = "";//Va a guardar todo el texto del archivo que abramos
            String valor = "";//Va guardando línea a línea los valores del archivo que hemos abierto

            while ((valor = br.readLine()) != null) {
                texto += valor + '\n';

            }

            jTextAreaPrincipal.setText(texto);
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    //Crea un archivo con el texto que hay en el editor
    private void escribirArchivo() {
        //Guardamos lo que hay escrito en pantalla
        String[] sb = jTextAreaPrincipal.getText().split("\\r?\\n");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoAbierto));
            for (String l : sb) {
                bw.write(l);
                bw.newLine();

            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    //Comprueba si ya existe un archivo con el nombre que se quiere guardar
    //y en caso de que sí ofrece la posibilidad de sobreescribirlo
    private boolean sustituirArchivo(File f) {

        boolean existe = false; //Indica si existe un archivo con el mismo nombre se vuelve true
        try {

            File fPadre = new File(f.getParent());//Creamos un File con la carpeta en la que se encuentra el archivo que vamos a crear
            File[] listOfFiles = fPadre.listFiles();//Ponemos todos archivos de la carpeta en un array

            for (File file : listOfFiles) {//Recorremos todos los archivos que hay en la carpeta para ver si alguno coincide

                if (file.isFile() && file.getName().equals(f.getName())) {//Si encuentra un archivo con el mismo nombre cambiamos el valor a <existe>
                    existe = true;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        //Si el archivo existe el usuario decide si sobreescribirlo o no
        if (existe) {
            int opcionElegida = JOptionPane.showConfirmDialog(null, "¿Sobreescribir archivo?", "Nombre existente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcionElegida == 0) {
                return true;
            }
            return false;
        }
        //Si no hay ningún archivo que coincida devuelve true
        return true;
    }

    //Al abrir un archivo, si ya hay un archivo abierto, pregunta si se quieren guardar los cambios realizados en el que ya estaba abierto
    private void guardarCambios() {

        if (archivoAbierto != null) {
            int opcionElegida = JOptionPane.showConfirmDialog(null, "¿Sobreescribir archivo?", "Nombre existente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcionElegida == 0) {
                escribirArchivo();
            }

        }
    }
    
    
    //Pone encima del jTextAreaPrincipal el nombre del archivo con el que se está trabajando
    private void ponerNombre() {

        //Si no hay ningún archivo seleccionado
        if (archivoAbierto == null) {
            label_nombre.setText("Sin título");
        } else {
            label_nombre.setText(archivoAbierto.getName());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrir;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_guardar_como;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaPrincipal;
    private javax.swing.JLabel label_nombre;
    // End of variables declaration//GEN-END:variables
}
