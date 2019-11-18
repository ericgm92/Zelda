/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class Octorok extends Enemic implements Serializable {
    private char tipus;
    
    public Octorok(){
        
    }

    public Octorok(String color, int puntsVida, double danyPromig, String descripcio, char tipus) /*throws Exception*/ {
        super(color, puntsVida, danyPromig, descripcio);
        if (tipus=='W' || tipus =='G'){
            this.tipus = tipus;
        } /*else {
           throw new Exception e; 
        }*/
        this.tipus = tipus;
            
            
        
    }

    public char getTipus() {
        return tipus;
    }

    public void setTipus(char tipus) {
        this.tipus = tipus;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OCTOROK\n");
        sb.append(super.toString());
        if (tipus=='G'){
            sb.append("\nTipus: Grass\n");
        }
        else if (tipus=='W'){
            sb.append("\nTipus: Water\n");
        }
        return sb.toString();
    }

    @Override
    public double Atacar() {
        
        if (tipus=='W'){
            return danyPromig + 10;
        }
        
        return danyPromig;
    }
    
    
}
