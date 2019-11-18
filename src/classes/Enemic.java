/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Eric
 */
public abstract class Enemic {
    protected String color;
    protected int puntsVida;
    protected double danyPromig;
    protected String descripcio;
    protected static int contador = 0;

    public Enemic(){
        
    }
    
    public Enemic(String color, int puntsVida, double danyPromig, String descripcio) {
        this.color = color;
        this.puntsVida = puntsVida;
        this.danyPromig = danyPromig;
        this.descripcio = descripcio;
        this.contador++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuntsVida() {
        return puntsVida;
    }

    public void setPuntsVida(int puntsVida) {
        this.puntsVida = puntsVida;
    }

    public double getDanyPromig() {
        return danyPromig;
    }

    public void setDanyPromig(double danyPromig) {
        this.danyPromig = danyPromig;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Color:" + color);
        sb.append("\nPunts de Vida:" + puntsVida);
        sb.append("\nDany Promig:" + danyPromig);
        sb.append("\nDescripcio:" + descripcio);
        return sb.toString();
    }
    
    public abstract double Atacar();
    
    public final void PujarDeNivell(int nivell){
        puntsVida = puntsVida * nivell;
        danyPromig = danyPromig * nivell;
    }
    
    @Override
    
    public boolean equals (Object o){
        boolean iguals;
        if (o==null){
            iguals=false;
        }
        else {
            if (o == this){
                iguals = true;
            }
            else if (o.getClass() != this.getClass()){
                iguals = false;
            }
            else {
                Enemic enemics = (Enemic) o;
                if (this.getDanyPromig() == enemics.danyPromig && this.getColor().equals(enemics.getColor())) {
                    iguals = true;
                }
                else {
                    iguals = false;
                }
            }
        }
        return iguals;
    }
    
    @Override
    
    public int hashCode(){
        int hash = 7;
        hash = 19*hash;
        if (this.color!=null){
            hash = hash + this.color.hashCode();
        }
        hash = (int) (hash*13+this.danyPromig);
        return hash;
    }
    
    
}
