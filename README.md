# geniusinjava
PT-Br

## Visão geral
O jogo foi construido em Linux (Debian 10) e seu comandos são direcionados para tal, em caso de outro Sistema operacional contate-me.

### Sobre o jogo
O jogo Genius in Java consiste em um jogo que o jogador tem que ser capaz de decorar as cores, de modo que ganha quem completar a sequencia dada pelo jogo (modo normal) ou pela propria sequencia dos jogadores (modo criador).

### Sobre as funcionalidades
O codigo base (engine) foi montado em java sema utilização de bibliotacas auxiliares, ja a interface grafica está sendo montada em JavaFX, uma framework mais atualizada.]

## Sobre o codigo
O codigo é dividido em 6 classes, sendo que uma é a classe de execução 'App.java':

### Color.java
Este enumerador foi desenvolvido com a intenção de tratarmos as cores como numeros, de modo que evitar colocar numeros no lugar das cores, evitando o uso de estrutura de condição.

### Item.java
Esta classe é responsavel por gerar o objeto "item-cor" da rodada, encapsulando um enum Color com a sua cor, um detalhe que podemos ressaltar é que quando o objeto item é criado ele ja recebe uma cor randômica e para o modo criador o uso do setColor é importante.
O método getRandColor() faz a conversão matematica para gerar uma cor aleatoria a partir de um numero randomico arrendondado de 0 a 3. A atribuição se deve pelo metodo values() -> Color[]

### Player.java
Essa classe é responsavel por gerar o objeto jogador, ela é responsavel por guardar os pontos que o jogador fez e seu status(isStatus), status esse que delimita se o jogador em jogo ou ja perdeu. É importante ressaltar que a função getNamePlayer() que busca o numero do jogador na rodada.
Neste caso as variaveis isStatus e namePlayer estão encapsuladas em jogador para que preserve os jogadores em Game.java, assim, saberemos a pontuação de todos os jogadores.

### Show.java
Essa classe concentra todos os entradas e exibições no terminal, ela é utilizada pelas outras classes para exibir para o usuario as informações do jogo.

Os metodos de show.java são os seguintes:
1. welcome(): exibe umas boas vindas
2. numPlayers(): busca o numero de players do jogo
3. modeSelect(): busca o modo de jogo e trata o modo de acordo com o modo pretendido.
4. codeSelect(): busca o nivel do jogo e gera um codigo que será utilizado dentro de Game.java
5. line(): exibe de uma forma animada o texto enviado pelo seu parametro
6. clear(): é responsavel por limpar o terminal linux
7. waitText(): exibe um texto de espera enquanto o usuario lê algo exibido anteriormente
8. endGame(): exibe os parametros finais do jogo, como se venceu (singleplayer) ou vencedor(multiplayer).

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
8. O metodo addItem() tem a função de adicionar um novo item quando se esta no metodo de criação (createGamming), ele funciona aguardando a entrada de uma nova cor digitada pelo usuário.

#### Metodos publicos (motores)
1. O metodo Gamming roda os modos de jogo Single Player e o modo Multiplayer de forma que o codigo é direcionado as funções auxiliares provadas, suas variaveis internas são:
        int index                       :variavel para armazenar o jogador
        int lastPlayer                  :variavel para armazenar o ultimo player
O funcionamento da classe se inicia em uma estrutura de repetição limitada pelo metodo verify() onde ela finaliza quando não houver mais jogadores em jogo, logo apos é intanciado o player especifico puxando do array players entrando no checker inicial, que tem como objetivo verificar quantos plyers estão em jogo (modo multiplayer) e assim começamos o jogo. O gatilho inicial é que o jogador 'n' esteja em jogo, com isso puxaremos o metodo isStatus() dele, caso afirmativo, adiciona-se um novo item randômico ao vetor de cores e é disparado para o usuario as cores na tela, logo apos é enviado para a função trying() e caso todo o acerto é feito os checkers finais, onde avalia o proximo jogador e se ele alcançou os pontos necessarios (single player).
Ao fim do jogo é chamada a função Show.endGame() com os parametros do ultimo jogador em jogo, e se venceu ou o modo de jogo, assim garantindo se esta no modo single ou multiplayer, ou seja, se o jogador estiver no modo multiPlayer (modeGame==false), não interessa a variavel 'win' (vencedor) e sim, quem venceu.
2. O metodo createGamming roda o modo Multiplayer de forma que o codigo é direcionado as funções auxiliares provadas, suas variaveis internas são:
        int index                       :variavel para armazenar o jogador
        boolean first                   :variavel para indicar a primeira vez
        int lastPlayer                  :variavel para armazenar o ultimo player
O funcionamento da classe se inicia em uma estrutura de repetição limitada pelo metodo verify() onde ela finaliza quando não houver mais jogadores em jogo, logo apos é intanciado o player especifico puxando do array players entrando no checker inicial, que tem como objetivo verificar quantos plyers estão em jogo e assim começamos o jogo. 
O gatilho inicial é que o jogador 'n' esteja em jogo, com isso puxaremos o metodo isStatus() dele, caso afirmativo e seja da primeira vez, adiciona-se um novo item escolhido pelo jogador ao vetor de cores chamando o metodo addItem() e first recebe o valor negativo, para que no proximo enlace seja tomado um novo caminho.Assim, na segunda iteração para frente é disparado para o usuario as cores na tela, logo apos é enviado para a função trying() e caso todo o acerto é feito a escolha da nova cor. No fim do enlace passa-se no checker final, onde avalia o proximo jogador.
Ao fim do jogo é chamada a função Show.endGame() com os parametros do ultimo jogador em jogo e o booleano de vitoria, assim garantindo a vitoria do ultimo jogador.

### App.java
Esta é a classe de execução onde puxa as informações dos comandos iniciais do usuario, vindos da classe Show e redireciona para a classe Game iniciando o jogo.


## Diagrama de Classes
![alt text](/util/NextStep%20Diagram.png)