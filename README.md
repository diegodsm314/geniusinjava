# geniusinjava
PT-Br

## Visão geral
Inicialmente o foco será sobre as classes auxiliares, e no final a classe principal do jogo.

### Sobre o jogo
O jogo Genius in Java consiste em um jogo que o jogador tem que ser capaz de decorar as cores, de modo que ganha quem completar a sequencia dada pelo jogo (modo normal) ou pela propria sequencia dos jogadores (modo criador).

### Sobre as funcionalidades
O codigo base (engine) foi montado em java sema utilização de bibliotacas auxiliares, ja a interface grafica está sendo montada em JavaFX, uma framework mais atualizada.]

## Sobre o codigo
O codigo é dividido em 6 classes, sendo que uma é a classe de execução 'App.java':

### Color.java
Este enumerador foi desenvolvido com a intenção de tratarmos as cores como numeros, de modo que evitar colocar numeros no lugar das cores, evitando o uso de estrutura de condição.

### Item.java
Esta classe é responsavel por gerar o objeto "item-cor" da rodada, encapsulando um enum Color com a sua cor, um detalhe que podemos ressaltar é que 
[print line 6-14] 
quando o objeto item é criado ele ja recebe uma cor randômica e para o modo criador o uso do setColor é importante.
O método getRandColor() faz a conversão matematica para gerar uma cor aleatoria a partir de um numero randomico arrendondado de 0 a 3. A atribuição se deve pelo metodo values() -> Color[]

### Player.java
Essa classe é responsavel por gerar o objeto jogador, ela é responsavel por guardar os pontos que o jogador fez e seu status(isStatus), status esse que delimita se o jogador em jogo ou ja perdeu. É importante ressaltar que a função getNamePlayer() que busca o numero do jogador na rodada.
Neste caso as variaveis isStatus e namePlayer estão encapsuladas em jogador para que preserve os jogadores em Game.java, assim, saberemos a pontuação de todos os jogadores.

### Game.java
Essa é a classe que é responsavel por rodar o jogo, onde todos os metodos relacionados ao jogo acontece.
#### Variaveis
    int gotcha                      :armazena o valor maximo de rodadas
    boolean modeGame                :responsavel pelo modo de jogo: singleplayer e multiplayer
    ArrayList<Item> colorSequence   :vetor de itens (cores)
    ArrayList<Player> players       :vetor de players
    Show s                          :instancia de prints (da classe shows)           
    boolean win                     :variavel para armazenar a vitoria
#### Contrutor
O construtor de 'Game.java' recebe suas variaveis: numPlayerse e codeSelect que são responsaveis por:
    i) adicionar os players no vector 'players'
    ii) determinar se o modo de jogo é single ou multiplayer
    iii) determinar o valor maximo de rodadas ('gotcha')

#### Metodos privados (auxiliares)
1. O metodo getColorSequence() é responsavel por retornar a sequencia de cores, seu uso é feito no metodo Gamming e create Gamming
2. O metodo showColors() tem como objetivo mostrar as cores para o usuario, ele utiliza do objeto Show para exibir o usuario as cores.
3. O metodo trying() é responsavel por avaliar se as cores digitadas pelo usuario condizem com a registrada pelo jogo (criado ou não). O metodo, por receber variaveis digitadas no teclado, foi tratado se caso o usuario não coloque um caractere diferente do estipulado.
4. O metodo addPlayer() tem como objetivo adicionar os jogadores ao vetor 'players' esse metodo é utilizado no construtor da classe.
5. O metodo verify() busca verificar se há algum player no jogo, chamando o metodo isStatus() dentro de cada objeto Player, este metodo é utilizado dentro do while dos metodos Gamming e createGamming como parametro para a continuidade do jogo.
6. O metodo modeSelect() faz o filtro de nivelamento do jogo, onde ele atrubui a gotcha o valor de acordo com o nivel escolhido pelo usuario.
7. O metodo verifyPlayers() faz a contagem de jogadores, se o numero de jogadores for iguial a 1, o jogo finaliza. A diferença entre ele e o verify(), é que se o modo for de apenas um jogador o uso entre os metodos se diferencia.

