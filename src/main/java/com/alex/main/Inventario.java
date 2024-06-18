
package com.alex.main;

import java.util.Scanner;

/**
 *
 * @author Alexsandre
 */
public class Inventario extends Atributo{
    // ITENS
    private boolean espada;
    private boolean capacete;
    private boolean peitoral;
    private boolean botas;
    private boolean luvas;
    private boolean cajado;
    private boolean cajadoAprimorado;
    protected boolean saberCajadoAprimorado;
    private boolean onisciencia;
    private boolean onipotencia;
    private boolean onipresenca;
    private boolean oni;
    protected boolean cura = true;
    protected int numCura = 3;
    // METODO CURAR
    public void cura(){
        if(numCura <= 0){
        cura = false;
        curarVida();
        
    }else{
            curarVida();
        }
        
    }
    
    
     public void curarVida(){
        if (cura == true){
            System.out.println("Você tomou uma pocão de cura '+20 Vitalidade'");
            vitalidade += 20;
            numCura -= 1;
            
        }else {
            System.out.println("\nSuas poções de cura acabaram!");
        }
        
    }
    
    public String saberCura(){
        if(cura == true){
        return "\n(R) Poções de cura restantes: " + numCura;
    }else{
            return "";
        }
    }
    
    // EQUIPAR ITENS
    
    public void inventario(){
         Scanner teclado = new Scanner(System.in);
         
         if(mago == true){
             
                                    System.out.println("Inventario:\n\n"
                                       + (cajado? "(1) Cajado 'EQUIPADO'" : "(1) Cajado") 
                                       + (peitoral? "\n(2) Tunica Magica 'EQUPADO'" : "\n(2) Tunica Magica")
                                       + (luvas? "\n(3) Luvas Arcanicas 'EQUIPADO'" : "\n(3) Luvas Arcanicas")
                                       + (botas? "\n(4) Botas Velozes 'EQUIPADO'" : "\n(4) Botas Velozes") +
                                       (saberCajadoAprimorado? (cajadoAprimorado? "\n(5) Cajado Aprimorado 'EQUIPADO'" : "\n(5) Cajado Aprimorado") : "") +
                                       "\n\n(X) Fechar inventario"
                                               + "\nDigite aqui: ");

                              

                               String resposta = teclado.nextLine().toLowerCase();

                               switch (resposta) {
                                   case "1":
                                       System.out.println((cajado? "Você desquipou o Cajado! '-25 MAGIA'" : "Você equipou o Cajado! '+25 MAGIA'" ) );
                                       cajado();
                                       desequiparCajadoAprimorado();
                                       inventario();
                                       break;
                                   case "2":
                                       System.out.println((peitoral? "Você desequipou a Tunica Magica '-30 VITALIDADE'" : "Você equipou a Tunica Magica '+30 VITALIDADE'"));
                                       peitoral();
                                       inventario();
                                       break;
                                   case "3":
                                       System.out.println((luvas? "Você desequipou as Luvas Arcanicas '-15 VITALIDADE' '-5 STAMINA'" : "Você equipou as Luvas Arcanicas '+15 VITALIDADE' '+5 STAMINA'"));
                                       luvas();
                                       inventario();
                                       break;
                                   case "4":
                                       System.out.println((botas? "Você desequipou as Botas Velozes '-20 VITALIDADE' '-20 STAMINA'" : "Você equipou as Botas Velozes '+20 VITALIDADE' '+20 STAMINA'"));
                                       botas();
                                       inventario();
                                       break;
                                   case "5":
                                       saberCajadoAprimorado();

                                       break;
                                   case "x":
                                       System.out.println("Você fechou o inventário");
                                       break;
                                   default:
                                       System.out.println("Item não encontrado tente novamente!");
                                       inventario();
                                       break;
                                }

    
                               
                               
         }else if(guerreiro == true){
                            System.out.println("Inventario:\n\n"
                                 + (espada? "(1) Espada 'EQUIPADO'" : "(1) Espada") 
                                 + (capacete? "\n(2) Capacete de ferro 'EQUPADO'" : "\n(2) Capacete de ferro")
                                 + (peitoral? "\n(3) Peitoral de ferro 'EQUIPADO'" : "\n(3) Peitoral de ferro")
                                 + (botas? "\n(4) Botas de ferro leve 'EQUIPADO'" : "\n(4) Botas de ferro leve") +
                                 "\n\n(X) Fechar inventario"
                                         + "\nDigite aqui: ");



                         String resposta = teclado.nextLine().toLowerCase();

                         switch (resposta) {
                             case "1":
                                 System.out.println((espada? "Você desquipou a espada! '-40 FORÇA'" : "Você equipou a espada! '+40 FORÇA'" ) );
                                 espada();
                                 inventario();
                                 break;
                             case "2":
                                 System.out.println((capacete? "Você desequipou o capacete de ferro '-20 VITALIDADE'" : "Você equipou o capacete '+20 VITALIDADE'"));
                                 capacete();
                                 inventario();
                                 break;
                             case "3":
                                 System.out.println((peitoral? "Você desequipou o peitoral '-30 VITALIDADE'" : "Você equipou o peitoral '+30 VITALIDADE'"));
                                 peitoral();
                                 inventario();
                                 break;
                             case "4":
                                 System.out.println((botas? "Você desequipou a botas de ferro '-20 VITALIDADE' '-20 STAMINA'" : "Você equipou a bota '+20 VITALIDADE' '+20 STAMINA'"));
                                 botas();
                                 inventario();
                                 break;
                             case "x":
                                 System.out.println("Você fechou o inventário");
                                 break;
                             default:
                                 System.out.println("Item não encontrado tente novamente!");
                                 inventario();
                                 break;
                         }  
                         
                         
                         
                         
         }else if(deus = true){
             
             
        


                            System.out.println("Inventario:\n\n"
                                    + (onipotencia? "(1) Onipotencia 'EQUIPADO'" : "(1) Onipotencia") 
                                    + (onipresenca? "\n(2) Onipresença 'EQUIPADO'" : "\n(2) Onipresença")
                                    + (onisciencia? "\n(3) Onisciencia 'EQUIPADO'" : "\n(3) Onisciencia")
                                    + (oni? "\n(4) ONI 'EQUIPADO'" : "\n(4) ONI") +
                                    "\n\n(X) Fechar inventario"
                                            + "\nDigite aqui: ");



                            String resposta = teclado.nextLine().toLowerCase();

                            switch (resposta) {
                                case "1":
                                    System.out.println((onipotencia? "Você parou de usar a Onipotencia! '-10000 FORÇA'" : "Você está usando a Onipotencia '+10000 FORÇA'" ) );
                                    Onipotencia();
                                    inventario();
                                    break;
                                case "2":
                                    System.out.println((onipresenca? "Você parou de usar a Onipresença '-10000 STAMINA'" : "Você está usando a Onipresença '+10000 STAMINA'"));
                                    Onipresencia();
                                    inventario();
                                    break;
                                case "3":
                                    System.out.println((onisciencia? "Você parou de usar a Onisciencia '-10000 VITALIDADE' '-10000 MAGIA'" : "Você está usando a Onisciencia '+10000 VITALIDADE' '+10000 MAGIA'"));
                                    Onisciencia();
                                    inventario();
                                    break;
                                case "4":
                                    System.out.println((oni? "Você voltou ao normal" : "Você é mais poderoso do que você pode imaginar"));
                                    Oni();
                                    inventario();
                                    break;
                                case "x":
                                    System.out.println("Você fechou o inventário");
                                    break;
                                default:
                                    System.out.println("Item não encontrado tente novamente!");
                                    inventario();
                                    break;
                            }
         }
    }
   
  // MÉTODOS PARA EQUIPAR OS ITENS
    
    
    
    public void saberCajadoAprimorado(){
               if(saberCajadoAprimorado == true){
                  
                   System.out.println((cajadoAprimorado? "Você desequipou o Cajado Aprimorado '-50 MAGIA'" : "Você equipou o Cajado Aprimorado '+50 MAGIA'"));
                   cajadoAprimorado();
                   desequiparCajado();
                   inventario();
                   
               }else{
                   System.out.println("Item não encontrado tente novamente!");
                   inventario();
               }
    }
    
    
     public void espada(){
         if (espada == true){
             
          espada = false;
           forca -= 40;
            
        }else if(espada == false){
            
           espada = true;
           forca += 40;
        }    
     }
     
     public void capacete(){
         if(capacete == true){
            capacete = false;
            vitalidade -= 20;
             
        }else if(capacete == false){
            
            capacete = true;
          vitalidade += 20;
        }
     }
     
    public void cajadoAprimorado(){
        if(cajadoAprimorado == true){
                  
                   cajadoAprimorado = false;
                   magia -= 50;
                   
               }else if(cajadoAprimorado == false ){
                   
                   cajadoAprimorado = true;
                   magia += 50;
                  
               }
        
    }
    
    public void desequiparCajadoAprimorado(){
        if(cajadoAprimorado == true){
                   cajadoAprimorado = false;
                   magia -= 50;        
                   
               }
        
    }
    
    public void desequiparCajado(){
        if(cajado == true){
            
            cajado = false;
            magia -= 25;
        }
    }
    
    public void cajado(){
        if (cajado == true){
           
           cajado = false;
           magia -= 25;
            
        }else if(cajado == false){
           
            cajado = true;
            magia += 25;
        }
        
    }
    
    public void peitoral(){
         if(peitoral == true){
            
           peitoral = false;
           vitalidade -= 30;
           
        }else if(peitoral == false){
         
          peitoral = true;
          vitalidade += 30;
        }
         
    }
    
    public void luvas(){
        if(luvas == true){
            
            luvas = false;
            vitalidade -=15;  
            stamina -= 5;
        }else if(luvas == false){
            
           luvas = true;
           vitalidade += 15;
           stamina += 5; 
                
        }
        

         
    }
    
    public void botas(){
        if(botas == true){
            
            botas = false;
            vitalidade -= 20;
            stamina -= 20;
        }else if(botas == false){
           
            botas = true;
            vitalidade += 20;
            stamina += 20;
            
        }
    
    }
    
     public void Onipotencia(){
        if (onipotencia == true){
             
            onipotencia = false;
            forca -= 10000;
            
        }else if(onipotencia == false){
            
            onipotencia = true;
            forca += 10000;
        }
        
     
    }
    
    public void Onipresencia(){
         if(onipresenca == true){
            
             onipresenca = false;
             stamina -= 10000;
        }else if(onipresenca == false){
            
            onipresenca = true;
            stamina += 10000;
        }
         
    }
    
    public void Onisciencia(){
        if(onisciencia == true){
            
            onisciencia = false;
            vitalidade -= 10000;
            magia -= 10000;
        }else if(onisciencia == false){
            
            onisciencia = true;
            vitalidade += 10000;
            magia += 10000;
        }
        
       
    }
    
    public void Oni(){
        if(oni == true){
            
            oni = false;
            vitalidade -= 100000;
            stamina -= 100000;
            magia -= 100000;
            forca -= 100000;
        }else if(oni == false){
            
            oni = true;
            vitalidade += 100000;
            stamina += 100000;
            magia += 100000;
            forca += 100000;
            
        }
    }
    
    
}
