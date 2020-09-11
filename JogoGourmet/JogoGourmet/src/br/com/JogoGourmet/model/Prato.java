package br.com.JogoGourmet.model;
/**
 *
 * @author Vitor
 */
public class Prato{
    
    private String prato;
    
    private String caracteristica;
    
    public Prato(){
        
    }

    public Prato(String prato, String caracteristica) {
        this.prato = prato;
        this.caracteristica = caracteristica;
    }
    
    

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
    
}