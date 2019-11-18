/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Eric
 */
public class Persona {
    
    private String cognom;
    private String nom;
    private int zeldas;
    private String menjar;
    private String data;
    /*private int mes;
    private int dia;*/

    public Persona(String cognom, String nom, String data, int zeldas, String menjar) {
        this.cognom = cognom;
        this.nom = nom;
        this.zeldas = zeldas;
        this.menjar = menjar;
        //comentari: manera de tractar amb dates
        SimpleDateFormat s = new SimpleDateFormat("dd-MM");
        this.data = s.format(new Date(2018, Integer.parseInt(data.substring(3,5)), Integer.parseInt(data.substring(0,2))));
        //this.data = data.substring(3,5) + "-" + data.substring(0,2);
    }

    public Persona() {

    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getZeldas() {
        return zeldas;
    }

    public void setZeldas(int zeldas) {
        this.zeldas = zeldas;
    }

    public String getMenjar() {
        return menjar;
    }

    public void setMenjar(String menjar) {
        this.menjar = menjar;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data.substring(3,5) + "-" + data.substring(0,2);
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cognom:" + cognom);
        sb.append("\nNom:" + nom);
        sb.append("\nData:" + data);
        sb.append("\nZeldas:" + zeldas);
        sb.append("\nMenjar:" + menjar);
        sb.append("\n");
        return sb.toString();
    }
    
    
    public static Comparator<Persona> PersonaByNameComparator = new Comparator<Persona>() {
        @Override
	public int compare(Persona p1, Persona p2) {            
            int val = p1.cognom.compareTo(p2.cognom);
            if (val == 0){
                val=p1.nom.compareTo(p2.nom);
            }
            return val;
        }
    };
    
    public static Comparator<Persona> PersonaByBirthdayComparator = new Comparator<Persona>() {
        @Override
	public int compare(Persona p1, Persona p2) {            
            return p1.data.compareTo(p2.data) * -1; //multiplicar per -1 per ordenacio descendent
            
        }
    };
}
