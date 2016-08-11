/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Reis
 */
public class Lembrete implements Runnable{ //extends Thread
    
    private String nome;
    private int intervalo;
    private int total;

    public Lembrete(String nome, int intervalo, int total) {
        this.nome = nome;
        this.intervalo = intervalo;
        this.total = total;
    }
    
    public void run(){
        for (int i = 1; i <= total; i++) {
            System.out.println("Tomar " + nome + " " + i);
            try {
                Thread.sleep(intervalo*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lembrete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
