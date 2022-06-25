import java.util.Scanner;

public class Show {
    
    public void welcome() throws InterruptedException {
        this.clear();
        this.line("::::::::::::::::::::::::::");
        this.line("::::::::::::::::::::::::::");
        this.line("::::::Genius in Java::::::");
        this.line("::::::::::::::::::::::::::");
        this.line("::::::::::::::::::::::::::");
        Thread.sleep(2000);
        this.clear();
    }

    public int numPlayers() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        this.line("Digite a quantidade de jogadores:");
        return input.nextInt();
    }

    public int modeSelect(int numPlayers) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int aux;
        this.clear();
        if(numPlayers>1){
            this.line("Digite o modo de jogo:\n1-Modo normal\n2-Modo Desafio\n3-Modo Criador");
            aux = input.nextInt();
        }
        else{
            this.line("Com um jogador, somente o modo normal está disponível.");
            this.waitText(53);
            aux = 1;
            this.clear();
        }  
        switch(aux){
            case 1: this.line("Modo Normal selelcionado!\nNeste modo você deve acertar as cores que o jogo determina.");break;
            case 2: this.line("Modo Desafio Selecionado!\nNeste modo você deve acertar mais cores que o seu oponente.");break;
            case 3: this.line("Modo Criador selecionado!\nNeste modo você deve acertar as cores do seu oponente e determinar a proxima cor.");break;
            default: this.line("Numero incorreto!\n");this.line("Entrando em modo normal");aux=1;break;
        } 
        this.waitText(58);
        return aux;
    }

    public int codeSelect() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        this.line("Digite o nivel de jogo:\n1-Facil\n2-Medio\n3-Dificil\n4-Ultimate");
        switch(input.nextInt()){
            case 1: return 10;
            case 2: return 20;
            case 3: return 30;
            case 4: return 40;
            default: this.line("Numero incorreto!\nEntrando em modo de teste...........");
                return 0;
        }
    }

    public void line(String text) throws InterruptedException{
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(5);
        }
        System.out.println();
    }

    public void clear(){
        System.out.print("\033\143");
    }

    public void waitText(int points) throws InterruptedException{
        for (int i = 0; i < points; i++) {
            System.out.print(".");
            Thread.sleep(50);
        }
        System.out.println();
    }

    public void endGame(int winPlayer) throws InterruptedException {
        this.clear();
        this.line("::::::::::::::::::::::::::");
        this.line(":::::::Fim do Jogo!!::::::");
        this.line("::::::::::::::::::::::::::");
        Thread.sleep(2000);
        this.clear();
        this.line("::::::::::::::::::::::::::::");
        this.line("::::Vitoria do Jogador"+winPlayer+"!!:::");
        this.line("::::::::::::::::::::::::::::");
        Thread.sleep(2000);
        this.clear();
    }
}
