package br.com.JogoGourmet.controller;

import javax.swing.JOptionPane;
import br.com.JogoGourmet.model.Prato;
/**
 *
 * @author Vitor
 */
public class PratoController{
    private final Object[] options = { "Sim", "Não"};
    private int resposta;
    
    private Prato prato;
    
    public PratoController(){
        prato = (new Prato("Massa"));
        prato.setEsquerdo(new Prato("Lazanha"));
        prato.setDireito(new Prato("Bolo De Chocolate"));
        
    }
    
    public void menuJogo(){
        JOptionPane.showMessageDialog(null, "Pense em um prato que gosta", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
        resposta = JOptionPane.showOptionDialog(null, "O prato que você pensou é "+prato.getAtributo()+"?" ,"Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
        if(resposta == JOptionPane.NO_OPTION){
            perguntas(prato.getDireito());
        } else {
            perguntas(prato.getEsquerdo());
        }
        this.menuJogo();
    }
    
    private void inserirPrato(Prato prato) {
        String pratoEscolhido = JOptionPane.showInputDialog("Qual prato você pensou?");
        if(pratoEscolhido == null) {
            System.exit(0);
        }
        String caracteristica = JOptionPane.showInputDialog(pratoEscolhido+" é _____ mas "+prato.getAtributo()+" não");
        if(caracteristica == null) {
            System.exit(0);
        }
        String aux = prato.getAtributo();
        prato.setAtributo(caracteristica);
        prato.setDireito(new Prato(pratoEscolhido));
        prato.setEsquerdo(new Prato(aux));
    }
    
    public void perguntas(Prato prato) {
        resposta = JOptionPane.showOptionDialog(null, "O prato que você pensou é "+prato.getAtributo()+"?" ,"Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);

        if(resposta == JOptionPane.YES_OPTION){
            if (prato.getDireito()== null) {
                JOptionPane.showMessageDialog(null, "Acertei!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
                resposta = JOptionPane.showOptionDialog(null, "Quer continuar jogando?","Pergunta ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
                if(resposta == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null, "Até logo!", "Tchau", JOptionPane.INFORMATION_MESSAGE, null);
                    System.exit(0);
                }else{
                    this.menuJogo();
                }
            } else {
                perguntas(prato.getDireito());
            }
        } else {
            if (prato.getEsquerdo()== null)
                inserirPrato(prato);
            else {
                perguntas(prato.getEsquerdo());
            }
        }
    }
    
}
