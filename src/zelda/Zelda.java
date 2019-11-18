/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import classes.Bokoblin;
import classes.Chuchu;
import classes.Enemic;
import classes.Octorok;
import classes.Persona;
import excepcions.MyException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import parsers.MyParser;

/**
 *
 * @author Eric
 */
public class Zelda {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //Enemic[] enemics = nousEnemics();
        
        //ArrayList<Enemic> enemics = new ArrayList<>();
        
        
        
        int x = 0x80000000;
        System.out.println(x + " and ");
        x = x >>>31;
        System.out.println(x);
        
        BufferedReader br = null;
        ArrayList<Persona> persones = new ArrayList<>();
        
        
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("players.txt"));
            
            while ((sCurrentLine = br.readLine()) != null) {
                
              
              ArrayList<String> camps = new ArrayList<>();
              String s;
              int i;
              while ((i=sCurrentLine.indexOf(";"))>0){
                   s = sCurrentLine.substring(0, i);
                  sCurrentLine = sCurrentLine.substring(i+1);
                  camps.add(s);
              }
              camps.add(sCurrentLine);
              boolean mostro = validarDades(Integer.parseInt(camps.get(3)),camps.get(1));
              
              if (mostro==true){
                  persones.add(new Persona(camps.get(0),camps.get(1), camps.get(2), Integer.parseInt(camps.get(3)),camps.get(4)));
              }
              
              if (Integer.parseInt(camps.get(3))>0){
                   persones.add(new Persona(camps.get(0),camps.get(1), camps.get(2), Integer.parseInt(camps.get(3)),camps.get(4)));
              }
              else {
                  throw new Exception ("Error:" + camps.get(1) + " té una dada no valida");
              }
              
              
                    //System.out.println(sCurrentLine);
            }
            
            Iterator it = persones.iterator(); 
            while (it.hasNext()){
                System.out.println(it.next());
            }
            
            Collections.sort(persones, Persona.PersonaByNameComparator);
            for(Persona p:persones) {
                System.out.println(p);
            }
            Collections.sort(persones, Persona.PersonaByBirthdayComparator);
            for(Persona p:persones) {
                System.out.println(p);
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("No se ha podido encontrar el fichero especificado");
        }        
        catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                    if (br != null) {  
                        br.close();
                    }
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }

        
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser sp;
        try {
            sp = spfac.newSAXParser();
        
            MyParser handler = new MyParser();
        
            sp.parse("zeldaBreath.xml", handler);

            /*handler.addToLlista(new Chuchu ("Blau",5,4, "ab",2,6));
            handler.addToLlista(new Chuchu ("Bla",5,4, "ab",2,6));*/
            
            handler.readList();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        
       
        

        Set enemics = new HashSet<>();
        Enemic e = new Chuchu ("Blau",5,4, "ab",2,6);
        Enemic e1 = new Octorok ("Groc", 7,3,"b",'G');
        Enemic e2 = new Octorok ("Groc", 6,6,"c",'W');
        Enemic e3 = new Octorok ("Groc", 6,5,"c",'Z');
        Enemic e4 = new Bokoblin ("Verd",4,5,"d","Espasa",false);
        Enemic e5 = new Bokoblin ("Verd",3,7,"d","Espasa",true);
        Enemic e6 = new Chuchu ("Blau",8,4, "abc",1,7);
        enemics.add(e);
        enemics.add(e1);
        enemics.add(e2);
        enemics.add(e3);
        enemics.add(e4);
        enemics.add(e5);
        enemics.add(e6);
        Iterator<Enemic> it = enemics.iterator();
                
        while (it.hasNext()){
            Enemic actual = it.next();
            System.out.println(actual);
            if (actual instanceof Chuchu){
                
                ((Chuchu) actual).Rebotar();
                //System.out.println("a");
            }
            else if (actual instanceof Bokoblin){
                ((Bokoblin) actual).Ressucitar();
                //System.out.println("b");
            }
            
            else if (actual instanceof Octorok){
                //((Bokoblin) it.next()).Ressucitar();
                System.out.println("c");
            }
            
            
            
        }
        
        
    }
    
    
    public static boolean validarDades(int zeldas, String nom) throws MyException{
        boolean val;
        if (zeldas<0){
            val = false;
            throw new MyException("ERROR. " + nom + " té una dada no vàlida");
            
            //System.out.println();
        }
        else {
            System.out.println("TOT OK");
            val = true;
        }
        return val;
    }
    
}
