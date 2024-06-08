/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Producto {
    private String cod,nom;
    private double precio;
    private int cant;

    public Producto(String cod, String nom, double precio, int cant) {
        this.cod = cod;
        this.nom = nom;
        this.precio = precio;
        this.cant = cant;
    }
    
    public Producto() {
        int cod= (int)(Math.random()*999+100);
        this.cod = "P"+cod; 
        this.nom = "";
        this.precio = 0;
        this.cant = 0;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public double valorPago(){
        return this.cant * this.precio;
    }
    
    public double IVA(){
        return valorPago()*0.19;
    }
    @Override
    public String toString() {
        return "\n Codigo: " + cod + "\n Nombre: " + nom +
               "\n Precio: " + precio + "\n Cantidad: " + cant;
    }
    
    
}
