package br.com.JogoGourmet.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.JogoGourmet.model.Caracteristica;
/**
 *
 * @author Vitor
 */
public class PratoController{
    final Object[] options = { "Sim", "Não"};
    private List<Caracteristica> caracteristicas;
    private int resposta;
    
    public PratoController(){
        caracteristicas = new ArrayList<>();
        adicionarCaracteristica("massa", "lazanha");
    }
    
    private void adicionarCaracteristica(String caracteristicaPrato, String pratoEscolhido){
        List<String> pratos = new ArrayList<>();
        pratos.add(pratoEscolhido);
        caracteristicas.add(new Caracteristica(caracteristicaPrato, pratos));
    }
    
    public void adicionarPrato(Caracteristica caracteristica){
        String pratoEscolhido = JOptionPane.showInputDialog("Qual prato você pensou?");
        if(pratoEscolhido == null) {
            System.exit(0);
        }
        caracteristica.getPratos().add(pratoEscolhido.toLowerCase());
        this.menuJogo();
    }
    
    public void menuJogo(){
        JOptionPane.showMessageDialog(null, "Pense em um prato que gosta", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
        for(Caracteristica caracteristica : caracteristicas) {
            resposta = JOptionPane.showOptionDialog(null, "O prato que você pensou é "+caracteristica.getCaracteristica()+"?" ,"Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
            if(resposta == JOptionPane.YES_OPTION){
                for(String prato : caracteristica.getPratos()) {
                    resposta = JOptionPane.showOptionDialog(null, "O prato que você pensou é um(a): "+prato+"?","Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
                    if(resposta == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "Acertei!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
                        resposta = JOptionPane.showOptionDialog(null, "Quer continuar jogando?","Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
                        if(resposta == JOptionPane.NO_OPTION){
                            JOptionPane.showMessageDialog(null, "Até logo!", "Tchau", JOptionPane.INFORMATION_MESSAGE, null);
                            System.exit(0);
                        }else{
                            this.menuJogo();
                        }
                    } else if (prato.equals(caracteristica.getPratos().get(caracteristica.getPratos().size()-1))){
                        this.adicionarPrato(caracteristica);
                    }
                }   
            } else if (caracteristica == caracteristicas.get(caracteristicas.size()-1)){
                perguntasBoloDeChocolate();
            }
        }
    }
    
    public void perguntasBoloDeChocolate() {
        resposta = JOptionPane.showOptionDialog(null, "O prato que você pensou é Bolo De Chocolate?" ,"Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
        if(resposta == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Acertei!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
            resposta = JOptionPane.showOptionDialog(null, "Quer continuar jogando?","Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
            if(resposta == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Até logo!", "Tchau", JOptionPane.INFORMATION_MESSAGE, null);
                System.exit(0);
            }else{
                this.menuJogo();
            }
        } else {
            this.adicionarNovaCaracteristica("Bolo De Chocolate");
        }
    }
    
    public void adicionarNovaCaracteristica(String tipoPrato){
        String pratoEscolhido = JOptionPane.showInputDialog("Qual prato você pensou?");
        if(pratoEscolhido == null) {
            System.exit(0);
        }
        String caracteristicaPrato = JOptionPane.showInputDialog(pratoEscolhido+" é _____ mas "+tipoPrato+" não");
        if(caracteristicaPrato == null) {
            System.exit(0);
        }
        adicionarCaracteristica(caracteristicaPrato, pratoEscolhido);
        this.menuJogo();
    }
    
}
