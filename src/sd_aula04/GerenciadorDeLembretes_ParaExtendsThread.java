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
public class GerenciadorDeLembretes_ParaExtendsThread {

    public static void main(String[] args) throws InterruptedException {

        Lembrete l1 = new Lembrete("Dorflex", 4, 10);
        Lembrete l2 = new Lembrete("Paracetamol", 6, 20);
        Lembrete l3 = new Lembrete("Cataflan", 8, 8);

//        l1.start();
//        l2.start();
//        l3.start();
////        TROCAR O MODO NA CLASSE Lembrete.java

        System.out.println("");
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
