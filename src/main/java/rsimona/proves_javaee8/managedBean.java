/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsimona.proves_javaee8;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Ramon
 */
@Named(value = "managedBean")
@RequestScoped
public class managedBean {

    private String text;
    private String text2;
    private int longitut;

    private String textWebsocket;
    
    public void cridaServlet(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("prova_servlet");
        } catch (IOException ex) {
            Logger.getLogger(managedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadTextWebsocket() {
        // Execute una funció de javaScript des de el backend bean
        PrimeFaces.current().executeScript("connectar('" + this.textWebsocket + "')");
    }

    public managedBean() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getLongitut() {
        return longitut;
    }

    public void setLongitut(int longitut) {
        this.longitut = longitut;
    }

    public String getTextWebsocket() {
        return textWebsocket;
    }

    public void setTextWebsocket(String textWebsocket) {
        this.textWebsocket = textWebsocket;
    }

    public void comprobarLongitut() {
        System.out.println(text);
        longitut = this.text.length();
        System.out.println(longitut);
    }

    public void validarLongitutText(FacesContext context, UIComponent toValidate, Object value) {
        if (((String) value).length() < 2 || ((String) value).length() > 5) {
            ((UIInput) toValidate).setValid(false);

            FacesMessage message = new FacesMessage("Longitut no vàlida", "La longitut del text ha de ser d'entre 2 i 5 caràcters");
            context.addMessage(toValidate.getClientId(context), message);
        }
    }
}
