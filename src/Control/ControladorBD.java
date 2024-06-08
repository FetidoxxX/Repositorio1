/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.*;
import Vista.Ventana;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class ControladorBD implements ActionListener {
    ListaProductos listaP;
    Ventana frmP;

    public ControladorBD() {
        this.listaP = new ListaProductos();
        this.frmP = new Ventana();
        frmP.getBtnRegistrar().addActionListener(this);
        frmP.getBtnConectar().addActionListener(this);
        frmP.getBtnActualizar().addActionListener(this);
        frmP.getBtnEliminar().addActionListener(this);
        frmP.getBtnLimpiar().addActionListener(this);
        
    }
    
    public void iniciar(){
    frmP.setTitle("Productos con BD");
    frmP.setLocationRelativeTo(frmP);
    frmP.getTxtCod().setEnabled(false);
    frmP.setVisible(true);
    }
    
    public void agregarProductos( Producto prod,JTable tabla){
        Object datos[]= {prod.getCod(),prod.getNom(),prod.getPrecio(),
                         prod.getCant(),prod.valorPago()};
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.addRow(datos);
        
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ProductoDAO prodBD = new ProductoDAO(); 
        if(e.getSource().equals(frmP.getBtnConectar())){
            frmP.getTblDatos().setModel(prodBD.consultar());
        }
        if(e.getSource().equals(frmP.getBtnRegistrar())){
            Producto objP= new Producto();
            objP.setNom(frmP.getTxtNom().getText());
            objP.setPrecio(Double.parseDouble(frmP.getTxtPrecio().getText()));
            objP.setCant(Integer.parseInt(frmP.getTxtCant().getText()));
            frmP.getTxtCod().setText(objP.getCod());
            listaP.getListaP().add(objP);
            agregarProductos(objP, frmP.getTblDatos());
            JOptionPane.showMessageDialog(frmP, objP.toString()+
                    "\nSub Total: "+objP.valorPago()+ "\nIVA: "+objP.IVA());
            prodBD.setObjP(objP);
            JOptionPane.showMessageDialog(frmP, prodBD.insertar2());
        }
        if(e.getSource().equals(frmP.getBtnActualizar())){
            enviarDatosDAO(prodBD, frmP.getTblDatos());
            JOptionPane.showMessageDialog(frmP, prodBD.actualizar());
        }
        if(e.getSource().equals(frmP.getBtnEliminar())){
            JTable tabla = frmP.getTblDatos();
            DefaultTableModel plantilla= (DefaultTableModel) tabla.getModel();
            enviarDatosDAO(prodBD, tabla);
            JOptionPane.showMessageDialog(frmP, prodBD.eliminar());
            plantilla.removeRow(tabla.getSelectedRow());
        }
        if(e.getSource().equals(frmP.getBtnLimpiar())){
            iniciarControles(frmP.getjPanel1().getComponents());
        }    
    }
    
    public void enviarDatosDAO(ProductoDAO objP, JTable tabla){
        int fila= tabla.getSelectedRow();
        objP.setObjP(new Producto(
                tabla.getValueAt(fila, 0).toString(),
                tabla.getValueAt(fila, 1).toString(),
                Double.parseDouble(tabla.getValueAt(fila, 2).toString()),
                Integer.parseInt(tabla.getValueAt(fila, 3).toString())
        ));
    }
        public void iniciarControles(Component [] controles){
        int cantTab=0;
        for (Component control : controles) {
            cantTab++;
            if(control instanceof JTabbedPane){
             cantTab= ((JTabbedPane) control).getTabCount();
                for (int i = 0; i <cantTab ; i++) {
                 Component panel=((JTabbedPane) control).getComponent(i);
                 if(panel instanceof JPanel){
                     //recursividad
                     iniciarControles(((JPanel) panel).getComponents());
                 }   
                }
            }else if (control instanceof JPanel){
            // recursivida
             iniciarControles(((JPanel) control).getComponents());          
            }else if(control instanceof JTextField){
            ((JTextField) control).setText("");
            }else if(control instanceof JTable){
              // se llena un obj aux model para traer el modelo del Jtable  
              DefaultTableModel model=(DefaultTableModel)((JTable) control).getModel();
             // boorrar todas las filas del JTable
                for (int i = ((JTable) control).getRowCount()-1; i >= 0; i++) {
                    model.removeRow(i);
                    //model.fireTableDataChanged();
                }
             
            }   
        }   
    }
}
