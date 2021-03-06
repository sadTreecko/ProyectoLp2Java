/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.CarpetaBL;
import Controlador.CursoBL;
import Controlador.GrupoBL;
import Controlador.PermisoBL;
import Modelo.Carpeta;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Oscar
 */
public class ManejoCarpetas extends javax.swing.JInternalFrame {

    private int nivelActual=0;
    private int profundidad=0;
    private ArrayList<Integer> buffNivel=new ArrayList<Integer>();
    private ArrayList<Carpeta> nivelCarpetaActual=new ArrayList<Carpeta>();
    private ArrayList<String>listaGrupos;
    private ImageIcon icon = new ImageIcon(this.getClass().getResource("/Imagenes/carpeta.png"));
    private String [] col={"" ,"Nombre","Descripcion"};
    private String [] colA={"" ,"Nombre","Descripcion","Habilitado"};
    private CarpetaBL cBL=new CarpetaBL();
    private Carpeta carpetaActual;
    /**
     * Creates new form ManejoCarpetas
     */
    public ManejoCarpetas() {
        setSize(990,700);
        buffNivel.add(0);
        setClosable(true);
        initComponents();
        if(nivelActual==0)BtnAnterior.setEnabled(false);
        BtnEliminar.setEnabled(false);
        CheckCurso.setEnabled(false);
        TableCarpeta.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                BtnEliminar.setEnabled(true);
                if(nivelActual==0)BtnAnterior.setEnabled(false);
                if(nivelCarpetaActual.size()==0){
                BtnSiguiente.setEnabled(false);
                }
            }
         });
        PermisoBL pBL=new PermisoBL();
        CBoxNomGrupo.removeAllItems();
        ArrayList<String>listaPermiso=pBL.lecturaPermiso();
        for(int i=0;i<listaPermiso.size();i++){
            CBoxNomGrupo.addItem(listaPermiso.get(i));
        }
        nivelCarpetaActual=cBL.lecturaCurso(nivelActual);
        DefaultTableModel tableModel ;
        if(frmPrincipal.cargo==2){
            BtnHabilitar.setVisible(false);
            tableModel = new DefaultTableModel(col, 0){
                @Override
                public Class<?> getColumnClass(int column) {
                    switch (column) {
                        case 0: return ImageIcon.class;
                        default: return String.class;
                    }
                }
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };

            for(int i=0;i<nivelCarpetaActual.size();i++){
                Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                tableModel.addRow(data);

            }
        }else{
            System.out.println("Cargando");
                //BtnHabilitar.setVisible(true);
//                if(carpetaActual.getHabilitado()==1){
//                    BtnHabilitar.setEnabled(false);
//                }else{
//                    BtnHabilitar.setEnabled(true);
//                }
                tableModel = new DefaultTableModel(colA, 0){
                @Override
                public Class<?> getColumnClass(int column) {
                    switch (column) {
                        case 0: return ImageIcon.class;
                        default: return String.class;
                    }
                }
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };

            for(int i=0;i<nivelCarpetaActual.size();i++){
                String opcion;
                if(nivelCarpetaActual.get(i).getHabilitado()==0){
                    opcion="SI";
                } else{
                    opcion="NO";
                }
                Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion(),
                    opcion};
                tableModel.addRow(data);

            }
            System.out.println("Cargando");
        }
        
        TableCarpeta.setModel(tableModel);
        TableCarpeta.setRowHeight(60);
       
        carpetaActual=cBL.getCarpetaActual(nivelActual);
        System.out.println(carpetaActual.getHabilitado());
        if(carpetaActual.getHabilitado()==1){
            BtnHabilitar.setEnabled(true);
        }else{
            BtnHabilitar.setEnabled(false);
        }
        LabelCarpeta.setText(carpetaActual.getNombre());
        if(carpetaActual.getMaestro()!=1){
            BtnNuevoGrupo.setEnabled(false);
            BtnEliminaGrupo.setEnabled(false);
            TxtNomGrupo.setEnabled(false);
            CBoxNomGrupo.setEnabled(false);
        }else{
            BtnNuevoGrupo.setEnabled(true);
            BtnEliminaGrupo.setEnabled(true);
            TxtNomGrupo.setEnabled(true);
            CBoxNomGrupo.setEnabled(true);
        }
        mostrarGrupos(carpetaActual);
//        TableCarpeta.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//        public void valueChanged(ListSelectionEvent event) {
//            // do some actions here, for example
//            // print first column value from selected row
//            System.out.println(TableCarpeta.getValueAt(TableCarpeta.getSelectedRow(), 1).toString());
//            buffNivel.add(nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId());
//            
//        }
//        });
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
        TableCarpeta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        BtnNuevaCarpeta = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtADescripcion = new javax.swing.JTextArea();
        CheckCurso = new javax.swing.JCheckBox();
        CheckBoxMaestro = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtNomGrupo = new javax.swing.JTextField();
        CBoxNomGrupo = new javax.swing.JComboBox<>();
        BtnNuevoGrupo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableGrupo = new javax.swing.JTable();
        BtnEliminaGrupo = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnSiguiente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        LabelCarpeta = new javax.swing.JLabel();
        BtnHabilitar = new javax.swing.JButton();

        setClosable(true);

        TableCarpeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableCarpeta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(TableCarpeta);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Carpeta"));

        jLabel1.setText("Nombre:");

        BtnNuevaCarpeta.setText("Nueva Carpeta");
        BtnNuevaCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevaCarpetaActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar Carpeta");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripcion:");

        TxtADescripcion.setColumns(20);
        TxtADescripcion.setRows(5);
        jScrollPane2.setViewportView(TxtADescripcion);

        CheckCurso.setText("Carpeta de Curso");

        CheckBoxMaestro.setText("Maestro");
        CheckBoxMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxMaestroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnEliminar)
                                    .addComponent(BtnNuevaCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CheckCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckBoxMaestro)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckCurso)
                    .addComponent(CheckBoxMaestro))
                .addGap(18, 18, 18)
                .addComponent(BtnNuevaCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnEliminar)
                .addGap(9, 9, 9))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo"));

        jLabel2.setText("Nombre:");

        CBoxNomGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtnNuevoGrupo.setText("Nuevo Grupo");
        BtnNuevoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoGrupoActionPerformed(evt);
            }
        });

        TableGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TableGrupo);

        BtnEliminaGrupo.setText("Eliminar Grupo");
        BtnEliminaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminaGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CBoxNomGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnNuevoGrupo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNomGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(BtnEliminaGrupo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtNomGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(CBoxNomGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnNuevoGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEliminaGrupo))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnAnterior.setText("Anterior");
        BtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnteriorActionPerformed(evt);
            }
        });

        BtnSiguiente.setText("Siguiente");
        BtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiguienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Carpeta:");

        LabelCarpeta.setText("jLabel5");

        BtnHabilitar.setText("Habilitar");
        BtnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHabilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnAnterior)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(LabelCarpeta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnHabilitar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnSiguiente))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAnterior)
                            .addComponent(BtnSiguiente)
                            .addComponent(jLabel4)
                            .addComponent(LabelCarpeta)
                            .addComponent(BtnHabilitar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguienteActionPerformed
        // TODO add your handling code here:
//        int nivelAux=nivelActual=nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId();
//        ArrayList<Carpeta> nivelCarpetaAux=cBL.lecturaCurso(nivelAux);
//        if(nivelCarpetaAux.size()==0){
//            JOptionPane.showMessageDialog(null, "No hay carpetas dentro de esta carpeta","Error",DISPOSE_ON_CLOSE);
//        }else{
            
            buffNivel.add(nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId());
            nivelActual=nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId();
            if(nivelActual==0)BtnAnterior.setEnabled(false);
            else BtnAnterior.setEnabled(true);
            nivelCarpetaActual=cBL.lecturaCurso(nivelActual);
            DefaultTableModel tableModel ;
            if(frmPrincipal.cargo==2){
                tableModel = new DefaultTableModel(col, 0){
                    @Override
                    public Class<?> getColumnClass(int column) {
                        switch (column) {
                            case 0: return ImageIcon.class;
                            default: return String.class;
                        }
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
                };

                for(int i=0;i<nivelCarpetaActual.size();i++){
                    Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                    tableModel.addRow(data);

                }
            }else{
                if(carpetaActual.getHabilitado()==1)BtnHabilitar.setEnabled(false);else BtnHabilitar.setEnabled(true);
                    tableModel = new DefaultTableModel(colA, 0){
                    @Override
                    public Class<?> getColumnClass(int column) {
                        switch (column) {
                            case 0: return ImageIcon.class;
                            default: return String.class;
                        }
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
                };

                for(int i=0;i<nivelCarpetaActual.size();i++){
                    String opcion;
                    if(nivelCarpetaActual.get(i).getHabilitado()==0){
                        opcion="SI";
                    } else{
                        opcion="NO";
                    }
                    Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion(),
                        opcion};
                    tableModel.addRow(data);

                }
            }
            TableCarpeta.setModel(tableModel);
            profundidad++;
            if(nivelCarpetaActual.size()==0){
                BtnSiguiente.setEnabled(false);
            }
            carpetaActual=cBL.getCarpetaActual(nivelActual);
            if(carpetaActual.getHabilitado()==1){
                BtnHabilitar.setEnabled(true);
            }else{
                BtnHabilitar.setEnabled(false);
            }
            LabelCarpeta.setText(carpetaActual.getNombre());
            TableCarpeta.setModel(tableModel);
            carpetaActual=cBL.getCarpetaActual(nivelActual);
            LabelCarpeta.setText(carpetaActual.getNombre());
            if(carpetaActual.getMaestro()!=1){
                BtnNuevoGrupo.setEnabled(false);
                BtnEliminaGrupo.setEnabled(false);
                TxtNomGrupo.setEnabled(false);
                CBoxNomGrupo.setEnabled(false);
            }else{
                BtnNuevoGrupo.setEnabled(true);
                BtnEliminaGrupo.setEnabled(true);
                TxtNomGrupo.setEnabled(true);
                CBoxNomGrupo.setEnabled(true);
            }
            mostrarGrupos(carpetaActual);
//        }
            if(carpetaActual.getMaestro()==1){
                CheckBoxMaestro.setEnabled(false);
            }
            if(carpetaActual.getNombre().equals("Cursos en el Ciclo")){
                CheckCurso.setEnabled(true);
            }else{
                CheckCurso.setEnabled(false);
            }
    }//GEN-LAST:event_BtnSiguienteActionPerformed

    private void BtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnteriorActionPerformed
        // TODO add your handling code here:
        if(carpetaActual.getMaestro()==1 && !CheckBoxMaestro.isEnabled()){
            CheckBoxMaestro.setEnabled(true);
        }
        buffNivel.remove(profundidad);
        profundidad--;
        nivelActual=buffNivel.get(profundidad);
        if(nivelActual==0)BtnAnterior.setEnabled(false);
        else BtnAnterior.setEnabled(true);
        System.out.println(nivelActual);
        nivelCarpetaActual=cBL.lecturaCurso(nivelActual);
        DefaultTableModel tableModel ;
        if(frmPrincipal.cargo==2){
            tableModel = new DefaultTableModel(col, 0){
                @Override
                public Class<?> getColumnClass(int column) {
                    switch (column) {
                        case 0: return ImageIcon.class;
                        default: return String.class;
                    }
                }
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };

            for(int i=0;i<nivelCarpetaActual.size();i++){
                Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                tableModel.addRow(data);

            }
        }else{
            if(carpetaActual.getHabilitado()==1)BtnHabilitar.setEnabled(false);else BtnHabilitar.setEnabled(true);
                tableModel = new DefaultTableModel(colA, 0){
                @Override
                public Class<?> getColumnClass(int column) {
                    switch (column) {
                        case 0: return ImageIcon.class;
                        default: return String.class;
                    }
                }
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };

            for(int i=0;i<nivelCarpetaActual.size();i++){
                String opcion;
                if(nivelCarpetaActual.get(i).getHabilitado()==0){
                    opcion="SI";
                } else{
                    opcion="NO";
                }
                Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion(),
                    opcion};
                tableModel.addRow(data);

            }
        }
        TableCarpeta.setModel(tableModel);
        BtnSiguiente.setEnabled(true);
        BtnEliminar.setEnabled(false);
        carpetaActual=cBL.getCarpetaActual(nivelActual);
        if(carpetaActual.getHabilitado()==1){
                BtnHabilitar.setEnabled(true);
            }else{
                BtnHabilitar.setEnabled(false);
            }
        LabelCarpeta.setText(carpetaActual.getNombre());
        TableCarpeta.setModel(tableModel);
        carpetaActual=cBL.getCarpetaActual(nivelActual);
        LabelCarpeta.setText(carpetaActual.getNombre());
        if(carpetaActual.getMaestro()!=1){
            BtnNuevoGrupo.setEnabled(false);
            BtnEliminaGrupo.setEnabled(false);
            TxtNomGrupo.setEnabled(false);
            CBoxNomGrupo.setEnabled(false);
        }else{
            BtnNuevoGrupo.setEnabled(true);
            BtnEliminaGrupo.setEnabled(true);
            TxtNomGrupo.setEnabled(true);
            CBoxNomGrupo.setEnabled(true);
        }
        mostrarGrupos(carpetaActual);
        if(carpetaActual.getNombre().equals("Cursos en el Ciclo")){
            CheckCurso.setEnabled(true);
        }else{
            CheckCurso.setEnabled(false);
        }
    }//GEN-LAST:event_BtnAnteriorActionPerformed

    private void BtnNuevaCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevaCarpetaActionPerformed
        // TODO add your handling code here:}
        int esMaestro=0;
        if(CheckBoxMaestro.isSelected())esMaestro=1;
        if(TxtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No ha escrito un nombre para la carpeta","Error",DISPOSE_ON_CLOSE);
        }else{
            Carpeta c=new Carpeta();
            CarpetaBL caBL=new CarpetaBL();
            c.setNombre(TxtNombre.getText());
            c.setDescripcion(TxtADescripcion.getText());
            c.setCarpetaPadre(nivelActual);
            if(CheckCurso.isSelected()){
                CursoBL cBL=new CursoBL();
                c.setCurso(cBL.obtieneIdCurso(TxtNombre.getText()));
                System.out.println(c.getCurso());
                caBL.registraCarpeta(c, 1,esMaestro);
            }else{
                caBL.registraCarpeta(c, 0,esMaestro);
            }
            nivelCarpetaActual.add(c);
            DefaultTableModel tableModel ;
            if(frmPrincipal.cargo==2){
                tableModel = new DefaultTableModel(col, 0){
                    @Override
                    public Class<?> getColumnClass(int column) {
                        switch (column) {
                            case 0: return ImageIcon.class;
                            default: return String.class;
                        }
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
                };

                for(int i=0;i<nivelCarpetaActual.size();i++){
                    Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                    tableModel.addRow(data);

                }
            }else{
                if(carpetaActual.getHabilitado()==1)BtnHabilitar.setEnabled(false);else BtnHabilitar.setEnabled(true);
                    tableModel = new DefaultTableModel(colA, 0){
                    @Override
                    public Class<?> getColumnClass(int column) {
                        switch (column) {
                            case 0: return ImageIcon.class;
                            default: return String.class;
                        }
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
                };

                for(int i=0;i<nivelCarpetaActual.size();i++){
                    String opcion;
                    if(nivelCarpetaActual.get(i).getHabilitado()==0){
                        opcion="SI";
                    } else{
                        opcion="NO";
                    }
                    Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion(),
                        opcion};
                    tableModel.addRow(data);

                }
            }
            TableCarpeta.setModel(tableModel);
            BtnEliminar.setEnabled(false);
        }
        BtnSiguiente.setEnabled(true);
        TxtNombre.setText("");
        TxtADescripcion.setText("");
        JOptionPane.showMessageDialog(null,"Carpeta creada con éxito","Aviso de confirmacion",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnNuevaCarpetaActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta carpeta?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          System.out.println("SI");
          CarpetaBL cBL=new CarpetaBL();
          cBL.eliminarCarpeta(nivelCarpetaActual.get(TableCarpeta.getSelectedRow()));
          nivelCarpetaActual.remove(nivelCarpetaActual.size()-1);
          DefaultTableModel tableModel ;
            if(frmPrincipal.cargo==2){
                tableModel = new DefaultTableModel(col, 0){
                    @Override
                    public Class<?> getColumnClass(int column) {
                        switch (column) {
                            case 0: return ImageIcon.class;
                            default: return String.class;
                        }
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
                };

                for(int i=0;i<nivelCarpetaActual.size();i++){
                    Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                    tableModel.addRow(data);

                }
            }else{
                if(carpetaActual.getHabilitado()==1)BtnHabilitar.setEnabled(false);else BtnHabilitar.setEnabled(true);
                    tableModel = new DefaultTableModel(colA, 0){
                    @Override
                    public Class<?> getColumnClass(int column) {
                        switch (column) {
                            case 0: return ImageIcon.class;
                            default: return String.class;
                        }
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
                };

                for(int i=0;i<nivelCarpetaActual.size();i++){
                    String opcion;
                    if(nivelCarpetaActual.get(i).getHabilitado()==0){
                        opcion="SI";
                    } else{
                        opcion="NO";
                    }
                    Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion(),
                        opcion};
                    tableModel.addRow(data);

                }
            }
            TableCarpeta.setModel(tableModel);
        }
        else {
           System.out.println("NO");
        }
        BtnEliminar.setEnabled(false);
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnNuevoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoGrupoActionPerformed
        // TODO add your handling code here:
        if(TxtNomGrupo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"DEbe ingresar un nombre","Aviso de alerta",JOptionPane.WARNING_MESSAGE);
            return;
        }
        GrupoBL gBL=new GrupoBL();
        gBL.creaGrupo(carpetaActual.getId(), TxtNomGrupo.getText(), CBoxNomGrupo.getSelectedItem().toString());
        mostrarGrupos(carpetaActual);
        JOptionPane.showMessageDialog(null,"Grupo creado con éxito","Aviso de confirmacion",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnNuevoGrupoActionPerformed

    private void CheckBoxMaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxMaestroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxMaestroActionPerformed

    private void BtnEliminaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminaGrupoActionPerformed
        // TODO add your handling code here:
        GrupoBL gBL=new GrupoBL();
        int idEliminar=(int) TableGrupo.getValueAt(TableGrupo.getSelectedRow(), 0);
        System.out.println(idEliminar);
        gBL.eliminaGrupo(idEliminar);
        mostrarGrupos(carpetaActual);
    }//GEN-LAST:event_BtnEliminaGrupoActionPerformed

    private void BtnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHabilitarActionPerformed
        // TODO add your handling code here:
        CarpetaBL cBL=new CarpetaBL();
        cBL.habilitarCarpeta(carpetaActual.getId());
        BtnHabilitar.setEnabled(false);
    }//GEN-LAST:event_BtnHabilitarActionPerformed
    private void mostrarGrupos(Carpeta c){
        TableGrupo.removeAll();
        GrupoBL gBL=new GrupoBL();
        TableGrupo.setModel(gBL.listaGrupoXcarpeta(c));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnEliminaGrupo;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnHabilitar;
    private javax.swing.JButton BtnNuevaCarpeta;
    private javax.swing.JButton BtnNuevoGrupo;
    private javax.swing.JButton BtnSiguiente;
    private javax.swing.JComboBox<String> CBoxNomGrupo;
    private javax.swing.JCheckBox CheckBoxMaestro;
    private javax.swing.JCheckBox CheckCurso;
    private javax.swing.JLabel LabelCarpeta;
    private javax.swing.JTable TableCarpeta;
    private javax.swing.JTable TableGrupo;
    private javax.swing.JTextArea TxtADescripcion;
    private javax.swing.JTextField TxtNomGrupo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
