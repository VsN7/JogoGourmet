/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.JogoGourmet.model;

import java.util.List;

/**
 *
 * @author Vitor
 */
public class Prato {
    
    private Prato esquerdo;
    private Prato direito;
    private String atributo;

    public Prato(String atributo) {
        this.atributo = atributo;
    }

    public Prato getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Prato esquerdo) {
        this.esquerdo = esquerdo;
    }

    public Prato getDireito() {
        return direito;
    }

    public void setDireito(Prato direito) {
        this.direito = direito;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
}
