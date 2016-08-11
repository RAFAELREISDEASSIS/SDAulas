/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula04;

/**
 *
 * @author Rafael Reis
 */
public class GerenciadorDeLembretes_ParaImplementsRunnable {

    public static void main(String[] args) throws InterruptedException {

        Lembrete l1 = new Lembrete("Dorflex", 4, 10);
        Lembrete l2 = new Lembrete("Paracetamol", 6, 20);
        Lembrete l3 = new Lembrete("Cataflan", 8, 8);

        Thread t1 = new Thread(l1);
        Thread t2 = new Thread(l2);
        Thread t3 = new Thread(l3);
        
        t1.start();
        t2.start();
        t3.start();       
    }
}
