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

    public boolean modeSelect(int numPlayers) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        if(numPlayers>1)
            this.line("Digite o modo de jogo:\n1-Modo normal\n2-Modo Desafio\n3-Modo Criador");
        else
            this.line("Digite o modo de jogo:\n1-Modo normal\n2-Modo Desafio");
        return input.nextInt() == 3 ? true : false;
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
}
