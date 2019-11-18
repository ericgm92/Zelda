/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import classes.Bokoblin;
import classes.Chuchu;
import classes.Enemic;
import classes.Octorok;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Eric
 */
public class MyParser extends DefaultHandler {
    private String temp;
    private Enemic enemic;
    private Set<Enemic> llista = new HashSet<>();

    public Set<Enemic> getLlista() {
        return llista;
    }

    public void setLlista(Set<Enemic> llista) {
        this.llista = llista;
    }
    
    public void addToLlista(Enemic e) {
        llista.add(e);
    }
    
   @Override
   public void characters(char[] buffer, int start, int length) {
          this.temp = new String(buffer, start, length);
   }
   
   
   @Override
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
          this.temp = ""; 
          
          
          //trobar si es enemic, crear objecte i llegir atribut xml
          
          if (qName.equalsIgnoreCase("Chuchu")) {
                 enemic = new Chuchu() {};
          }
          else if (qName.equalsIgnoreCase("Bokoblin")) {
                 enemic = new Bokoblin() {};
                 
          }
          else if (qName.equalsIgnoreCase("Octorok")) {
                 enemic = new Octorok() {};
          }
          /*else if (qName.equalsIgnoreCase("drop")) {
              if (attributes.equals("qty")){
                  
              }
                
          }*/
          else if (qName.equalsIgnoreCase("avgDamage") && enemic instanceof Chuchu){
              ((Chuchu) enemic).setDanyMinim(Double.parseDouble(attributes.getValue("min")));
              ((Chuchu) enemic).setDanyMaxim(Double.parseDouble(attributes.getValue("max")));     
                  
          }
   }
          
   
    
 
    @Override
   public void endElement(String uri, String localName, String qName) throws SAXException {

          // Cada vez que encontramos un nuevo elemento de cierre "Account", añadimos el objeto a la lista
          // El resto de elementos XML corresponden, en este caso, a atributos del objeto "Account"
          if (qName.equalsIgnoreCase("Chuchu") || qName.equalsIgnoreCase("Bokoblin") || qName.equalsIgnoreCase("Octorok") ) {
                 llista.add(enemic);

          } else if (qName.equalsIgnoreCase("color")) {
                 enemic.setColor(temp);
                 
          } else if (qName.equalsIgnoreCase("HP")) {
                 enemic.setPuntsVida(Integer.parseInt(temp));
                 
          } else if (qName.equalsIgnoreCase("avgDamage")) {
                 enemic.setDanyPromig(Double.parseDouble(temp));
                 
          } else if (qName.equalsIgnoreCase("desc")) {
                 enemic.setDescripcio(temp);
                 
          } else if (qName.equalsIgnoreCase("shield")) {
                 ((Bokoblin) enemic).setEscut(Boolean.parseBoolean(temp));
          } else if (qName.equalsIgnoreCase("weapon")) {
                 ((Bokoblin) enemic).setArma(temp);
          } else if (qName.equalsIgnoreCase("drop")) {
              ArrayList<String> objectes = new ArrayList<>();
              String s;
              int i;
              while ((i=temp.indexOf(","))>0){
                  s = temp.substring(0, i);
                  temp = temp.substring(i+1);
                  objectes.add(s);
              }
              objectes.add(temp);
              ((Bokoblin) enemic).setObjectes(objectes);
          }
          else if (qName.equalsIgnoreCase("type")) {
                 ((Octorok) enemic).setTipus(temp.charAt(0));
          }
          
   }
   
   public void readList() {
          //System.out.println("No of the accounts in bank '" + accList.size()  + "'.");
          Iterator<Enemic> it = llista.iterator();
          while (it.hasNext()) {
                 System.out.println(it.next().toString());
          }
   }
}
