/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Resurrectable;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Eric
 */
public class Bokoblin extends Enemic implements Resurrectable, Serializable {
    private String arma;
    private boolean escut;
    private ArrayList<String> objectes;
    
    public Bokoblin(){
        
    }

    public Bokoblin(String color, int puntsVida, double danyPromig, String descripcio, String arma, boolean escut) {
        super(color, puntsVida, danyPromig, descripcio);
        this.arma = arma;
        this.escut = escut;
        this.objectes = new ArrayList<>();
    }

    
    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public boolean isEscut() {
        return escut;
    }

    public void setEscut(boolean escut) {
        this.escut = escut;
    }

    public ArrayList<String> getObjectes() {
        return objectes;
    }

    public void setObjectes(ArrayList<String> objectes) {
        this.objectes = objectes;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BOKOBLIN\n");
        sb.append(super.toString());
        sb.append("\nArma:" + arma);
        if (escut==true){
            sb.append("\nTé escut");
        }
        else{
            sb.append("\nNo té escut");
        }
        sb.append("\nObjectes:" + objectes.toString() + "\n");
        
        return sb.toString();
    }

    @Override
    public double Atacar() {
        if (escut==true){
            return danyPromig/2;
        }
        
        
        return danyPromig;
    }

    @Override
    public void Ressucitar() {
        puntsVida = puntsVida*2;
        danyPromig = danyPromig * 0.5;
    }
}
