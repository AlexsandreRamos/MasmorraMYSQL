
package com.alex.main;

import java.util.Scanner;

/**
 *
 * @author Alexsandre
 */
public class Atributo {
 // SISTEMA DE ATRIBUTOS E CLASSES
protected String nomePersonagem;
protected String nomeClasse;    
protected boolean mago;
protected boolean guerreiro;
protected boolean deus;
protected int nivelMasmorra = 1;
protected int masmorrasConcluidas = 0;    
protected int vitalidade = 0;
protected int forca = 0;
protected int stamina = 0;
protected int magia = 0;
protected int pontuacao = 0;


 public void setAtributosClasse(){
        if (mago == true){
            forca = 15;
            vitalidade = 50;
            magia = 30;
            stamina = 15;
            nomeClasse = "Mago";
        }else
        if(guerreiro == true){    
            forca = 5;
            vitalidade = 80;
            magia = 5;
            stamina = 30;
            nomeClasse = "Guerreiro";
        }else
        
        if(deus = true){
            forca = 1000;
            vitalidade = 1000;
            magia = 1000;
            stamina = 1000;
            nomeClasse = "Deus";
        }
 
 }


 
 
 
 // XP PERSONAGEM
 
  protected int nivelPersonagem = 1;
    protected int xpPersonagem = 0;
   
    protected int avisarXP;
    
    public void avisarXP(){
       
        if (xpPersonagem >= 250 && avisarXP == 0){
            nivelPersonagem = 2;
            avisarXP ++;
            uparNivel();
            
        }else if (xpPersonagem >= 500  && avisarXP == 2){
            nivelPersonagem = 3;
            avisarXP ++;
           uparNivel();
            
        }else if(xpPersonagem >= 1000  && avisarXP == 4){
             nivelPersonagem = 4;
            avisarXP ++;
            uparNivel();
        
        }else if(xpPersonagem >= 2000  && avisarXP == 6){
        nivelPersonagem = 5;
            avisarXP ++;
            uparNivel();
        }
            
        
    }
    
    public void uparNivel(){
        Scanner teclado = new Scanner(System.in);
        
        String enter;
        
        
        if(avisarXP == 1 ){
            System.out.println("Você upou para o nível 2!");
        System.out.println("Você ganhou '+10 de Força', '+50 de Vitalidade', '+10 de Magia', '+5 de Stamina'");
              forca += 10;
            vitalidade += 50;
            magia += 10;
            stamina += 5;
            
            avisarXP ++;
            System.out.println("\n\nPrecione 'enter' para continuar.");
        
                enter = teclado.nextLine();
        
        }else if(avisarXP == 3){
             System.out.println("Você upou para o nível 3!");
        
             System.out.println("Você ganhou '+20 de Força', '+50 de Vitalidade', '+20 de Magia', '+5 de Stamina'");
              forca += 20;
            vitalidade += 50;
            magia += 20;
            stamina += 5;
            
            avisarXP ++;
            
             System.out.println("\n\nPrecione 'enter' para continuar.");
        
                    enter = teclado.nextLine();
        
        }else if(avisarXP == 5){
             System.out.println("Você upou para o nível 4!");
        
             
             System.out.println("Você ganhou '+20 de Força', '+50 de Vitalidade', '+20 de Magia', '+15 de Stamina'");
             forca += 20;
            vitalidade += 50;
            magia += 20;
            stamina += 15;
           
            avisarXP ++;
                     System.out.println("\n\nPrecione 'enter' para continuar.");
        
                 enter = teclado.nextLine();
        
            }else if(avisarXP == 7){
                      System.out.println("Você upou para o nível 5!'ULTIMO NIVEL'");
        
             
             System.out.println("Você ganhou '+50 de Força', '+100 de Vitalidade', '+50 de Magia', '+50 de Stamina'");
             forca += 50;
            vitalidade += 100;
            magia += 50;
            stamina += 50;
           
            avisarXP ++;
                   System.out.println("\n\nPrecione 'enter' para continuar.");
        
        enter = teclado.nextLine();
          
                    }
       
    }
    
public void aa(){
    
    
}
  
    
 // DETALHES
    
    public String atributos(){
    return  "\n\nNome: "+ nomePersonagem +"\nMasmorras Concluídas: "+ masmorrasConcluidas + "\n\nNivel do Personagem: " + nivelPersonagem+ "\nXP do Personagem: " +xpPersonagem +"\nClasse: "+ nomeClasse + "\n\nForça: " + forca +"                'Esse será seu dano caso seja Físico'"+"\nVitalidade: " + vitalidade +"           'Esse será a vida do seu personagem'"+"\nMagia: " + magia +"                'Esse será seu dano caso Mágico'"+ "\nStamina: " + stamina +"              'Esse valor está muito ligado a fugir, acertar um ataque ou desviar de um ataque.'";
        
    }
 


    
    
}
