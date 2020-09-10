package br.com.JogoGourmet.model;

import java.util.List;

/**
 *
 * @author Vitor
 */
public class Caracteristica{
    
    private String caracteristica;
    
    private List<String> pratos;

    public Caracteristica(String caracteristica, List<String> pratos) {
        this.caracteristica = caracteristica;
        this.pratos = pratos;
    }
    
    public Caracteristica () {
        
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public List<String> getPratos() {
        return pratos;
    }

    public void setPratos(List<String> pratos) {
        this.pratos = pratos;
    }
    
    
    
}
