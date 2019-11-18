/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Eric
 */
public class Chuchu extends Enemic implements Serializable {
    
    private double danyMinim;
    private double danyMaxim;

    
    public Chuchu(){
        
    }
    
    public Chuchu(String color, int puntsVida, double danyPromig, String descripcio) {
        super(color, puntsVida, danyPromig, descripcio);
    }
    
    
    
    public Chuchu(String color, int puntsVida, double danyPromig, String descripcio, double danyMinim, double danyMaxim) {
        super(color, puntsVida, danyPromig, descripcio);
        this.danyMinim = danyMinim;
        this.danyMaxim = danyMaxim;
    }

    public double getDanyMinim() {
        return danyMinim;
    }

    public void setDanyMinim(double danyMinim) {
        this.danyMinim = danyMinim;
    }

    public double getDanyMaxim() {
        return danyMaxim;
    }

    public void setDanyMaxim(double danyMaxim) {
        this.danyMaxim = danyMaxim;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CHUCHU\n");
        sb.append(super.toString());
        sb.append("\nDany Minim:" + danyMinim);
        sb.append("\nDany Maxim:" + danyMaxim + "\n");
        return sb.toString();
    }

    @Override
    public double Atacar() {
        Random r = new Random();
        return danyMinim + (danyMaxim - danyMinim) * r.nextDouble();

    }
    
    /**
     *
     */
    public void Rebotar(){
        System.out.println("La teva arma rebota contra el cos del Chuchu");
    }
    
}
