# MasmorraMYSQL
Este é um projeto baseado em um sistema simples de masmorras, combates, atributos, inventário e classes. Que tem como seu principal objetivo alcançar a maior pontuação possível.

# Descrição
- **CLASSES**: Mago, Guerreiro e Deus;
-  **NÍVEIS**:
    - **Nível 1**:
        - **XP**: 0;
        - **Modificações**: Nenhumea.
    - **Nível 2**:
        - **XP**: 250;
        - **Modificações**: +50 Vitalidade, +10 Força, +10 Mágia e +5 Stamina.
    - **Nível 3**:
        - **XP**: 500;
        - **Modificações**: +50 Vitalidade, +20 Força, +20 Mágia e +5 Stamina.
    - **Nível 4**:
        - **XP**: 1000;
        - **Modificações**: +50 Vitalidade, +20 Força, +20 Mágia e +15 Stamina.
    - **Nível 5**:
        - **XP**: 2000;
        - **Modificações**: +100 Vitalidade, +50 Força, +50 Mágia e +50 Stamina.
- **ATRIBUTOS INICIAIS**:
    - **Mago**:
        - **Vitalidade**: 50
        - **Força**: 15
        - **Magia**: 30
        - **Stamina**: 15
    - **Guerreiro**:
        - **Vitalidade**: 80
        - **Força**: 5
        - **Magia**: 5
        - **Stamina**: 30 
    - **Deus**:
        - **Vitalidade**: 1000
        - **Força**: 1000
        - **Magia**: 1000
        - **Stamina**: 1000
- **EQUIPAMENTOS**:
    - **Mago**: Cajado Aprimorado, Cajado, Tunica Mágica, Luvas Arcanicas, Botas Velozes e 3 Poções de cura(+20 Vitalidade);
    - **Guerreiro**: Espada, Capacete de Ferro, Peitoral de Ferro, Botas de Ferro e 3 Poções de cura(+20 Vitalidade);
    - **Deus**: Onipotencia, Onipresença, Onisciencia, Oni e 3 Poções de cura(+20 Vitalidade).
- **MASMORRAS**:
    - **Níveis disponíveis**: 2
    - **Inimigos**:
        - **Nivel 1**: Goblin (100 de Vida).
            - **Drops Itens**: 2 Poções de Cura;
            - **Drops XP**:   75 a 100.  
        - **Nivel 2**: Zumbi (150 de Vida).
            - **Drops Itens**: 4 Poções de Cura e Cajado Aprimorado(Somente Mago);
            - **Drops XP**:   150 a 200.

# FUNCIONALIDADES
  - **Criação Usuario**:
    - Escolha do nome de Usuário;
    - Escolha da classe desejada.
  - **Menu**:
    - Visualização do Inventário;
    - Visualização dos Atributos;
    - Entrar nas Masmorras;
    - Resetar as Masmorras (Aumenta a Dificuldade);
    - Sair do jogo.
   - **Inventário**:
      - Cada classe possue seus próprios equipamentos, onde é informado se os itens estão equipados ou não e te da a possibilidade de equipar ou desequipar os equipamentos;
          - Exemplo:
        ```
            (1) Cajado 'EQUIPADO'
            (2) Tunica Magica
            (3) Luvas Arcanicas 'EQUIPADO'
            (4) Botas Velozes
    
            (X) Fechar inventario
            Digite aqui: 
                  

        
   - **Atributos**:
       - É possível vizualizar o valor de seus atributos e como funciona:
           - Exemplo:
          ```
               Nome:
               Masmorras Concluídas:
               Nivel do Personagem:
               XP do Personagem:
               Classe:

               Força:                'Esse será seu dano caso seja Físico'
               Vitalidade:           'Esse será a vida do seu personagem'
               Magia:                'Esse será seu dano caso Mágico'
               Stamina:              'Esse valor está muito ligado a fugir, acertar um ataque ou desviar de um ataque'"


  - **Masmorras**:
      - Antes de entrar na masmorra acontece um checkup que verifica o nível da masmorra, redirecionando o usuario para a sua masmorra.
      - Dentro da masmorra você possui três opções:
          - Exemplo:
        ```
                Vida do Personagem: 40
                Goblin: 100

                O que deseja fazer?
                (1) Causar dano
                (R) Poções de cura restantes: 3
                (X) Fugir

                Digite aqui:

      - **Sistema de Combate**:
          - Ao selecionar a opção '(1) Causar dano', ocorrerá 2 métodos.
              - **MÉTODO 1**:
                  - baseada na stamina do personagem calcula uma porcentagem de chance em acerto.
              - **MÉTODO 2**:
                  - caso você acerte o ataque você entra em um método onde você tem 33 porcento de chance para acertar um critico e multiplicar seu dano em 1,2 (no caso do zumbi, ele possui uma pequna chance de recuperar um pouco da sua vida).
          - Após isso ocorreo o método 'Turno do Inimigo' onde faz um checkup se o inimigo está vivo e depois calcula sua porcentagem baseada na stamina do seu personagem a chance de você esquivar de seu ataque.
          - Depois disso ocorrerá um checkup da vida do usuário, caso a vida seja 0 ou menor você será jogado para o mÉtodo (Sair()), caso maior que 0 o usuário volta para o menu da masmorra.
      - **Sistema de Cura**:
          - Ao selecionar a opção '(R) Poções de cura restantes: 3', ocorrerá 2 métodos.
              - **MÉTODO 1**:
                  - Faz um checkup que verifica se ainda existe Poções de Cura, caso tenha ele retorna um boolean = true, caso não tenha ele retorna um boolean = false.
              - **MÉTODO 2**:
                  - Caso o boolean = true  soma +20 Vitalidade e -1 Número de Poções de Cura, Caso boolean = false será informado para o usuário que ele não possue mais Poções de cura.
      - **Sistema de Fuga**:
          - Ao selecionar a opção '(X) Fugir', ocorrerá 1 método.
              - **MÉTODO 1**:
                  - Baseado na sua stamina calcula uma probabilidade de fuga, caso nao consiga fugir o usuario receberá o dano do inimigo.
                  - Caso não consiga fugir: o usuario receberá o dano do inimigo e depois disso ocorrerá um checkup da vida do usuário, caso a vida seja 0 ou menor você será jogado para o método (Sair()), caso maior que 0 o usuário volta para o menu da masmorra.
                  - Caso consiga fugir: o usuário voltará para o menu.

  - **Resetar Masmorras**:
      - Ocorre 2 métodos
        - **MÉTODO 1**:
            - Faz um checkup onde verifica se o nivel 1 e o nivel 2 da masmorra está concluido.
            - Caso não concluido você não entra no método 2.
        - **MÉTODO 2**:
            -  Caso concluido ocorrerá um reset nas masmorras e a vida dos inimigos será multiplicadas aumentando a dificuldade.
  - **Sair do Jogo**:
    

            

              
          
        
