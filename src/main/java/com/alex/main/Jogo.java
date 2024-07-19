
package com.alex.main;

import java.sql.Connection; 

import java.sql.DriverManager; 

import java.sql.SQLException; 


import static java.lang.System.exit;
import java.sql.PreparedStatement;
import java.util.Random;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexsandre
 */
public class Jogo extends Inventario{
   // MASMORRAS
    private int checkupMasmorra = 0;
    private boolean masmorra1 = true;
    private boolean masmorra2 = false;
    private int vidaGoblin = 100;
    private int vidaZumbi = 150;
    private int goblin = 100;
    private int zumbi = 150;
    private boolean pegarCajadoAprimorado = true;
    // CRIAÇÃO DO PERSONAGEM
    public void criarPersonagem(){
        Scanner teclado = new Scanner(System.in);
    Scanner int1 = new Scanner(System.in);
    
        System.out.println("Escreva o nome do seu personagem: ");   
    nomePersonagem = teclado.nextLine();
    escolherClasse();
    }
     public void escolherClasse(){
          Scanner teclado = new Scanner(System.in);
          
    System.out.println("Escolha sua classe:"
                + "\n(1) Mago"
                + "\n(2) Guerreiro"
                + "\n(3) DEUS");
        
        System.out.printf("\nDigite aqui: ");
        String r = teclado.nextLine().toLowerCase();
        
        switch (r) {
            case "1":
                mago = true;
                
                break;
            case "2":
               guerreiro = true;
                
                break;
            case "3":
                deus = true;
                break;
            default:
                System.out.println("Valor inválido tente novamente!");
                escolherClasse();
                break;    
        }
        setAtributosClasse();       
        menu();
    }
    
    
    // JOGO 
    
    public void menu(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n\nO que você quer fazer:"
                + "\n(1)Abrir Inventário"
                + "\n(2)Ver Atributos"
                + "\n(3)Ir para Masmorra nivel "+ nivelMasmorra
                + "\n(4)Resetar a Masmorra"
                + "\n\n(X)Sair do Jogo"
                        + "\nDigite aqui: ");
        
        
         String r = teclado.nextLine().toLowerCase();
         
        switch (r) {
            case "1":
                inventario();
                menu();
                break;
            case "2":
                System.out.println(atributos());
                System.out.printf("\nAperte 'enter' para continuar.");
                String enter = teclado.nextLine();
                menu();
                break;
            case "3":
                checkupMasmorra();
                break;
            case "4":
                resetMasmorras();
            case "x":
                sair();
                
            default:
                System.out.println("Valor inválido tente novamente!");
                menu();
                break;
        
    }    
}
 
    //METODO MASMORRAS
     public void nivelMasmorra(){
       Scanner teclado = new Scanner(System.in);
        
        if(masmorra1 == true){
            masmorra();
        }else if(masmorra2 == true){
           masmorra();
   
        }else{
            System.out.println("Não há mais masmorras!"
                    + "\n\nAperte 'enter' para continuar.");
    
             String enter = teclado.nextLine();
             menu();
        }
        
        
       
        
    }
     
     public void resetMasmorras(){
       Scanner teclado = new Scanner(System.in);
       if(masmorra1 == false && masmorra2 == false){ 
           
        masmorra1 = true;
        masmorra2 = false;
        nivelMasmorra = 1;
        
        vidaGoblin *= 2;
        vidaZumbi *= 2;
         
        goblin = vidaGoblin;
        vidaZumbi = vidaZumbi;
       
        
        System.out.println("\n\nMasmorra resetada com sucesso! 'Dificuldade aumentada'"
                + "\n\nPrecione 'enter' para continuar.");
        String enter = teclado.nextLine();
        
        menu();
       }else{
           System.out.println("Complete todas as Masmorras primeiro! ");
           
           menu();
       }
       
    }
    
    // MASMORRAS
     
     public void masmorra(){
         System.out.println("\n\nVida do Personagem: "+ vitalidade
                + (masmorra1? "\nGoblin: " + vidaGoblin : "") + (masmorra2? "\nZumbi: " + vidaZumbi : "")
                + "\nO que deseja fazer?"
                + "\n(1) Causar dano"+
                 (cura? saberCura()  : "\n(R) Poções de cura restantes: 0")
                +"\n(X) Fugir\n");
                
        
        Scanner teclado = new Scanner(System.in);
         System.out.printf("\nDigite aqui: ");
        String a = teclado.nextLine().toLowerCase();
        
        switch (a) {
            case "1":
                acertarAtaque();
                turnoInimigo();
                
                 
                break;
           
            case "x":
                fugir();
               
                break;
            case "r":
                cura();
                System.out.println("\nPrecione 'enter' para continuar.");
                String enter = teclado.nextLine();
                checkupVida();
                
                break;
            default:
                System.out.println("\n\nValor inválido!\n\nPrecione 'enter' para continuar.");
                 enter = teclado.nextLine();
                checkupVida();
                break;
          
        }
         
     }
     
     public void concluirMasmorra(){
         if (masmorra1 == true && masmorra2 == false){
             System.out.println("\n\nParabéns você concluiu a masmorra nivel 1!!");
             drop();
             masmorra1 = false;
             masmorra2 = true;
             vidaGoblin = goblin;
             nivelMasmorra ++;
             masmorrasConcluidas ++;
             menu();
             
         }else if (masmorra2 == true && masmorra1 == false){
             System.out.println("\n\nParabéns você concluiu a masmorra nivel 2!!");
             drop();
             masmorra2 = false;
             nivelMasmorra ++;
             masmorrasConcluidas ++;
             vidaZumbi = zumbi;
             menu();
             
         }else{
            checkupVida(); 
         }
         
     }
     
     // METODOS DE DANO RANDOM
     //////////////////
     public void acertarAtaque(){
         double porcentagem = 1.9 * stamina;
        
        Random random = new Random();
        
        if(random.nextDouble() < porcentagem / 100.0){
            acertarCritico();
        }else{
            System.out.println("O inimigo esquivou!");
        }
         
     }
     //////////////////////
     public void acertarCritico(){
         double porcentagem = 33;
            
            Random random = new Random();
            
            if(random.nextDouble() < porcentagem / 100.0){
                System.out.println("você acertou um critico! \n\nDano causado: ");
               danosCriticos();
                
                
            }else{
                System.out.println("\n\nDano causado: ");
                danosNormal();
                
            }
         
     }
     ////////////////
     public void danosCriticos(){
          if (mago == true && masmorra1 == true){
                magia *= 1.2;
                System.out.printf(""+ this.magia +" Mágico" );
                vidaGoblin -= magia;
                magia /= 1.2;       
            
            }else if (guerreiro == true && masmorra1 == true){
                forca *= 1.2;
                System.out.printf("" +this.forca  + " Fisíco");
                vidaGoblin -= forca;
                forca /= 1.2;
             
            }else if (deus == true && masmorra1 == true){forca *= 100;
                System.out.printf("" +this.forca + " Angelical");
                vidaGoblin -= forca;
                forca /= 100;
                
                            }else if (mago == true && masmorra2 == true){
                                magia *= 1.2;
                                System.out.printf(""+ this.magia +" Mágico" );
                                vidaZumbi -= magia;
                                magia /= 1.2;
                                
                            }else if (guerreiro == true && masmorra2 == true){
                                forca *= 1.2;
                                 System.out.printf("" +this.forca  + " Fisíco");
                                vidaZumbi -= forca;
                                forca /= 1.2;
                                
                            }else if (deus == true && masmorra2 == true){
                                forca *= 100;
                                 System.out.printf("" +this.forca + " Angelical");
                                vidaZumbi -= forca;
                                forca /= 100;
                                
                            }
     }
     ///////////////////////////
     public void danosNormal(){
         if (mago == true && masmorra1 == true){
                System.out.printf(""+ this.magia  +" Mágico" );
                vidaGoblin -= magia;
                
            }else if (guerreiro == true && masmorra1 == true){
                System.out.printf("" +this.forca+ " Fisíco");
                vidaGoblin -= forca;
                
            }else if (deus == true && masmorra1 == true){
                System.out.printf("" +this.forca + " Angelical");
                vidaGoblin -= forca;
                
                
                
                                }else if (mago == true && masmorra2 == true){
                                    System.out.printf(""+ this.magia  +" Mágico" );
                                    vidaZumbi -= magia;
                                    
                                }else if (guerreiro == true && masmorra2 == true){
                                    System.out.printf("" +this.forca+ " Fisíco");
                                    vidaZumbi -= forca;
                                    
                                }else if (deus == true && masmorra2 == true){
                                    System.out.printf("" +this.forca + " Angelical");
                                    vidaZumbi -= forca;
                                }
     }
     
     ////////////////////////////////////////////////////////////
     // MÉTODOS TURNO DO INIMIGO
     
     public void turnoInimigo(){
       Scanner teclado = new Scanner(System.in);
       
         if(vidaGoblin <= 0){
            System.out.println("\n\nInimigo eliminado!");
            concluirMasmorra();
            
        }else if(vidaZumbi <= 0){
             System.out.println("\n\nInimigo eliminado!");
             concluirMasmorra();
            
        }else{
            System.out.println("\nTurno do inimigo: Precione 'enter' para continuar" );
             String enter = teclado.nextLine();
             
             
             ataqueInimigo();
             

        }
     }
     
     
     public void ataqueInimigo(){
         
         
         if(masmorra1 == true){
         double porcentagem = 2 * stamina;
         Random random = new Random();
        if (random.nextDouble() < porcentagem / 100.0 ){
            System.out.println("\n\nO goblin errou o ataque!");
            checkupVida();
        }else{
               System.out.println("\n\nO goblin te acertou! '-5 VITALIDADE'");
             
            vitalidade -= 5;
            checkupVida();
        } 
                       
         
                        }else if(masmorra2 == true){
                       double porcentagem = 1.9 * stamina;
                       double porcentagemRecuperacao = 15;

                        Random random = new Random();

                        if (random.nextDouble() < porcentagemRecuperacao / 100.0 ){

                       System.out.println("\n\nO Zumbi recuperou 25 de Vida'");
                       vidaZumbi += 25;
                                           }else{

                        }

                                   if (random.nextDouble() < porcentagem / 100.0 ){


                                    System.out.println("\n\nO Zumbi te acertou! '-15 VITALIDADE'");

                                       vitalidade -= 15;
                                       checkupVida();
                                   }else{
                                       System.out.println("\n\nO Zumbi errou o ataque!");
                                       checkupVida();

                                   }
                        }
         
     }
     
     // METODO DE DROP DO INIMIGO
     
     public void drop(){
         Scanner teclado = new Scanner(System.in);
         String enter;
         Random random = new Random();
         double porcentagemXP = 40;
         double porcentagemDrop = 33;    
         
            if(masmorra1 == true){
               if(random.nextDouble() < porcentagemXP / 100.0){
                   System.out.println("Você ganhou 100 de xp!");
                   xpPersonagem += 100;
                   

                   
               }else{
                  System.out.println("Você ganhou 75 de xp!");
                   xpPersonagem += 75;
                   

               }
            
                                                        
                                    
                                    if(random.nextDouble()< porcentagemDrop / 100.0){
                                        System.out.println("\nVocê ganhou 2 poções de cura!");
                                        System.out.println("Precione 'enter' para continuar:\n");
                                        enter = teclado.nextLine();

                                        numCura += 2;

                                    }else{

                                        System.out.println("\n\nO Goblin não tinha itens! );");
                                        System.out.println("Precione 'enter' para continuar:\n");
                                        enter = teclado.nextLine();

                                    }
            avisarXP();
             
             
         }else if(masmorra2 == true){
             if(random.nextDouble() < porcentagemXP / 100.0){
                   System.out.println("Você ganhou 200 de xp!");
                   xpPersonagem += 200;
                   avisarXP();
                   
                   
               }else{
                  System.out.println("Você ganhou 150 de xp!");
                   xpPersonagem += 150;
                   avisarXP();
                   
               }
             
                        
        
        
                            if(random.nextDouble()< porcentagemDrop / 100.0){
                                System.out.println("\nVocê ganhou 4 poções de cura!");
                                numCura += 4;
                                enter = teclado.nextLine();
                                
                            }else{

            
            
            
                                }
                                                
                                            if(mago == true){
                                                
                                                
                                            double porcentagemDropCajado = 60;

                                               if(random.nextDouble() < porcentagemDropCajado / 100.0 && pegarCajadoAprimorado == true){
                                                   System.out.println("\n\nVocê ganhou um Cajado aprimorado!");
                                                   pegarCajadoAprimorado = false;
                                                   saberCajadoAprimorado = true;
                                                   enter = teclado.nextLine();
                                                                }
                                            }
                                            
         }
         
     }
     
     // METODO FUGIR
     
     public void fugir(){
           Scanner teclado = new Scanner(System.in);
           Random random = new Random();
           double porcentagem = 1.9 * stamina;
         if(masmorra1 == true){
            if (random.nextDouble() < porcentagem / 100.0 ){
            System.out.println("\n\nVocê fugiu!");
            System.out.println("\nPrecione 'enter' para continuar.");
            String enter = teclado.nextLine();
            menu();
        }else{
            System.out.println("Você não consegue fugir");
            System.out.println("\nO goblin te acertou! '-5 VITALIDADE'");
            vitalidade -= 5;
            checkupVida();
        }
             
                                                }else if(masmorra2 == true){

                                            if (random.nextDouble() < porcentagem / 100.0 ){
                                                 System.out.println("\n\nVocê fugiu!");
                                                 System.out.println("\nPrecione 'enter' para continuar.");
                                                 String enter = teclado.nextLine();
                                                 menu();

                                           }else{
                                               System.out.println("Você não consegue fugir");
                                               System.out.println("\nO Zumbi te acertou! '-15 VITALIDADE'");
                                               vitalidade -= 15;
                                               checkupVida();

                                           }
                             }

         
     }
     // METODOS DE CHECKUP
     
     public void checkupVida(){
         Scanner teclado = new Scanner(System.in);
         if(vitalidade > 0 ){
             masmorra();
             System.out.println("Precione 'enter' para continua.");
             String enter = teclado.nextLine();
         }
         else {
             System.out.println("Você morreu!");
             sair();
         }
         
     }
     
     public void checkupMasmorra(){
         if(masmorra1 == true || masmorra2 == true){
             masmorra();
         }else{
             System.out.println("Não existe mais masmorras!");
             menu();
         }
         
     }
     
   // SAIR
     
     public void sair(){
         pontuacao += vitalidade;
         pontuacao += forca;
         pontuacao += magia;
         pontuacao += stamina;
         pontuacao *= masmorrasConcluidas;
         pontuacao *= numCura;
         pontuacao *= nivelPersonagem;
         pontuacao += xpPersonagem;
         if(vitalidade <= 0){
             pontuacao /= 25;
         }
         System.out.println("Sua Pontuação é: "+ pontuacao);
         adicionarUsuario();
         exit(0);
     }
     
     
     // MYSQL
     
     
     
     public void adicionarClasse() {
         try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo", "root", "Sen@crs2024")){
            
             String sql = "INSERT INTO classe (classe, vitalidade, forca, stamina, magia) VALUE (?, ?, ?, ?, ?)";
             try(PreparedStatement statement = connection.prepareStatement(sql)){
                 statement.setString(1, nomeClasse);
                 statement.setInt(2, vitalidade);
                 statement.setInt(3, forca);
                 statement.setInt(4, stamina);
                 statement.setInt(5, magia);
                 statement.executeUpdate();
            
             }catch(SQLException e){
                 e.printStackTrace();
                 
             }
           //  rs.close();
         }catch (SQLException e){
             e.printStackTrace();
             
         }
         
         checkupArmas();
     
     }
     
     public void adicionarUsuario(){
         
         try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo", "root", "Sen@crs2024")){
            
             String sql = "INSERT INTO usuarios (nome, masmorrasconcluidas, pontuacao) VALUE (?, ?, ?)";
             try(PreparedStatement statement = connection.prepareStatement(sql)){
                 statement.setString(1, nomePersonagem);
                 statement.setInt(2, masmorrasConcluidas);
                 statement.setInt(3, pontuacao);
                 statement.executeUpdate();
                
             }catch(SQLException e){
                 e.printStackTrace();
                 
             }
           //  rs.close();
         }catch (SQLException e){
             e.printStackTrace();
             
         }
          adicionarClasse(); 
         
         }
     // ARMAS
     
     protected String capacete;
     protected String armas;
     protected String peitoral;
     protected String luvas;
     protected String botas;
             public void checkupArmas(){
                 if(mago == true){
                     if(saberCajadoAprimorado == true){
                     capacete = " ";
                     armas = "Cajado e Cajado Aprimorado";
                     peitoral = "Tunica Magica";
                     luvas = "Luvas Arcanicas";
                     botas = "Botas Velozes";
                     
                 }else{
                     capacete = " ";
                     armas = "Cajado";
                     peitoral = "Tunica Vagica";
                     luvas = "Luvas Arcanicas";
                     botas = "Botas Velozes";
                     }
                 
             }else if(guerreiro == true){
                 capacete = "Capacete de Ferro";
                 armas = "Espada";
                 peitoral = "Peitoral de Ferro";
                 luvas = " ";
                 botas = "Botas de Ferro";
                 
             }else if(deus == true){
                 capacete = " ";
                 armas = "Onipotencia, Onipresença, Onisciencia, Oni";
                 peitoral = " ";
                 luvas = " ";
                 botas = " ";
                 
             }
                 
                 adicionarEquipamentos();
             }
             public void  adicionarEquipamentos(){
               try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo", "root", "Sen@crs2024")){
            
               String sql = "INSERT INTO equipamentos (cabeca, peitoral, pernas, maos, armas) VALUE (?, ?, ?, ?, ?)";
                      try(PreparedStatement statement = connection.prepareStatement(sql)){
                        statement.setString(1, capacete);
                        statement.setString(2, peitoral);
                        statement.setString(3, botas);
                        statement.setString(4, luvas);
                        statement.setString(5, armas);
                        statement.executeUpdate();
                     
                    }catch(SQLException e){
                        e.printStackTrace();
                        
                    }
                  //  rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                    
                }  
                 
                 
                 
             }
             
             
           
             
             
          
        
         
         
     }

     
     
     
