package br.com.JogoGourmet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import br.com.JogoGourmet.model.Prato;
/**
 *
 * @author Vitor
 */
public class PratoController{
    private Object[] options = { "Sim", "Não"};
    private String pratoEscolhido = "";
    private String caracteristica = "";
    private List<Prato> pratos;
    private Prato prato;
    private int resposta;
    
    public PratoController(){
        pratos = new ArrayList<>();
        pratos.add(new Prato("lasanha", "massa"));
        prato = new Prato();
    }
    
    public void adicionarPrato(String pratoEscolhido, String caracteristica){
        pratos.add(new Prato(pratoEscolhido.toLowerCase(), caracteristica.toLowerCase()));
    }
    
    public String filtroPratos(String caracteristica){
        for(Prato prato : pratos){
            if(prato.getCaracteristica().equals(caracteristica)) {
                pratoEscolhido = prato.getPrato();
            }
        }
        return "O prato que você pensou é um(a): "+pratoEscolhido+"?";
    }
    
    //Construção das interações entre o algoritimo e o usuário
    
    public void menuJogo(){
        this.perguntasRepetidas();
    }
    
    public void perguntasPoucoRepetidas(String tipoPrato){
        pratoEscolhido = JOptionPane.showInputDialog("Qual prato você pensou?");
        if(pratoEscolhido == null) {
            System.exit(0);
        }
        caracteristica = JOptionPane.showInputDialog(pratoEscolhido+" é _____ mas "+tipoPrato+" não");
        if(caracteristica == null) {
            System.exit(0);
        }
        adicionarPrato(pratoEscolhido, caracteristica);
        this.perguntasRepetidas();
    }
    
    private void perguntasRepetidas(){
        JOptionPane.showMessageDialog(null, "Pense em um prato que gosta", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
        for(Prato prato : pratos) {
            resposta = JOptionPane.showOptionDialog(null, "O prato que você pensou é "+prato.getCaracteristica()+"?" ,"Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
            if (prato == pratos.get(pratos.size()-1) && resposta == JOptionPane.NO_OPTION){
                perguntasBoloDeChocolate();
            }
            if(resposta == JOptionPane.YES_OPTION){
                resposta = JOptionPane.showOptionDialog(null, "O prato que você pensou é um(a): "+prato.getPrato()+"?","Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
                if(resposta == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Acertei!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
                    resposta = JOptionPane.showOptionDialog(null, "Quer continuar jogando?","Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
                    if(resposta == JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(null, "Até logo!", "Tchau", JOptionPane.INFORMATION_MESSAGE, null);
                        System.exit(0);
                    }else{
                        this.perguntasRepetidas();
                    }
                } else if (prato == pratos.get(pratos.size()-1)){
                    this.perguntasPoucoRepetidas(prato.getPrato());
                }
            } else if (prato == pratos.get(pratos.size()-1)){
                perguntasRepetidas();
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
                this.perguntasRepetidas();
            }
        } else {
            this.perguntasPoucoRepetidas("Bolo De Chocolate");
        }
    }
    
}
