/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ListaProductos {
    private ArrayList listaP;

    public ListaProductos(ArrayList listaP) {
        this.listaP = listaP;
    }

    public ListaProductos() {
        this.listaP = new ArrayList();
    }
    public ArrayList getListaP() {
        return listaP;
    }

    public void setListaP(ArrayList listaP) {
        this.listaP = listaP;
    }
    
    
}
