/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GrupoBL;
import Controlador.UsuarioBL;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronie Paolo
 */
public class ManejoGrupos extends javax.swing.JInternalFrame {

    private int idGrupoSel = -1;
    private int idUsuSel = -1;
    private GrupoBL accesoGrupo = new GrupoBL();
    private UsuarioBL accesoUser = new UsuarioBL();

    public enum estado {
        Inicial, SelecGrupo, Guardar, Modificar, NuevoGrupo
    }

    public ManejoGrupos() {
        initComponents();
        setSize(990, 700);
        txtNombre.setEnabled(false);
        DefaultTableModel modelo;
        modelo = accesoGrupo.listaTotalGrupo();
        tableGrupos.setModel(modelo);
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
        tableGrupos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnAsignarUsr = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnBuscaUsuario = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableGrupos);

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableUsuarios);

        jLabel1.setText("Usuarios del grupo:");

        jLabel2.setText("Grupos:");

        btnEliminar.setText("Eliminar usuario seleccionado");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnAsignarUsr.setText("Agregar usuario al grupo seleccionado");
        btnAsignarUsr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarUsrMouseClicked(evt);
            }
        });

        jLabel3.setText("Codigo:");

        jLabel4.setText("Nombre:");

        btnBuscaUsuario.setText("Buscar Usuario");
        btnBuscaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscaUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 105, Short.MAX_VALUE)
                                .addComponent(btnAsignarUsr))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtNombre))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscaUsuario)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscaUsuario))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnAsignarUsr))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGruposMouseClicked
        // TODO add your handling code here:
        int index = tableGrupos.getSelectedRow();
        idGrupoSel = (int) tableGrupos.getValueAt(index, 0);
        try {
            DefaultTableModel modeloU = accesoGrupo.listaUsuariosXGrupo(idGrupoSel);
            tableUsuarios.setModel(modeloU);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tableGruposMouseClicked

    private void btnBuscaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscaUsuarioMouseClicked
        // TODO add your handling code here:
        if (txtCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingresar un codigo");
            return;
        }
        int codigo = Integer.parseInt(txtCodigo.getText());
        Usuario u = accesoUser.buscarUsuarioXcodigo(codigo);
        if (u != null) {
            txtNombre.setText(u.getNombre()+' '+u.getaPaterno()+' '+u.getaMaterno());
            idUsuSel=u.getnEntidad();
            System.out.println(u.getnEntidad());
        } else {
            txtNombre.setText("NO ENCONTRADO");
        }
    }//GEN-LAST:event_btnBuscaUsuarioMouseClicked

    private void btnAsignarUsrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarUsrMouseClicked
        // TODO add your handling code here:  
        if (!txtNombre.getText().equals("NO ENCONTRADO") && !txtNombre.getText().equals("")) {
            if (idGrupoSel != -1) {
                //int idUsu = Integer.parseInt(txtCodigo.getText());
                System.out.println(idUsuSel);
                accesoGrupo.asignarUsuario(idUsuSel, idGrupoSel);
                try{
                    DefaultTableModel modeloU = accesoGrupo.listaUsuariosXGrupo(idGrupoSel);
                    tableUsuarios.setModel(modeloU);
                }catch(Exception e){}
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar un grupo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no valido");
            return;
        }
    }//GEN-LAST:event_btnAsignarUsrMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        int index = tableUsuarios.getSelectedRow();
        
        UsuarioBL uBL= new UsuarioBL();
        Usuario u=uBL.buscarUsuarioXcodigo((int) tableUsuarios.getValueAt(index, 0));
        idUsuSel=u.getnEntidad();
        if(idGrupoSel==-1)
            JOptionPane.showMessageDialog(null, "Seleccionar un grupo!");
        if(idUsuSel==-1)
            JOptionPane.showMessageDialog(null, "Seleccionar un usuario!");
        if(idUsuSel!=-1 && idGrupoSel!=-1){
            System.out.println(idUsuSel);
            System.out.println(idGrupoSel);
            accesoGrupo.eliminarUsuarioGrupo(idUsuSel, idGrupoSel);
            idUsuSel=-1;
            DefaultTableModel modeloU;
            try {
                modeloU = accesoGrupo.listaUsuariosXGrupo(idGrupoSel);
                tableUsuarios.setModel(modeloU);
            } catch (SQLException ex) {
                Logger.getLogger(ManejoGrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void tableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsuariosMouseClicked
        // TODO add your handling code here:
        int index = tableUsuarios.getSelectedRow();
        idUsuSel = (int) tableUsuarios.getValueAt(index, 0);
    }//GEN-LAST:event_tableUsuariosMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManejoGrupos().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarUsr;
    private javax.swing.JButton btnBuscaUsuario;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableGrupos;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
