/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsimona.proves_javaee8;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ramon
 */
@Named(value = "managedBean")
@RequestScoped
public class managedBean {

    private String text;
    private int longitut;
    /**
     * Creates a new instance of managedBean
     */
    public managedBean() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLongitut() {
        return longitut;
    }

    public void setLongitut(int longitut) {
        this.longitut = longitut;
    }
    
    public void comprobarLongitut(){
        System.out.println(text);
        longitut=this.text.length();
        System.out.println(longitut);
    }
}
