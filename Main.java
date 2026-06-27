package TrabalhoPOO;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int tamanhoTabuleiro = 11;

        char[][] tabuleiro = new char[tamanhoTabuleiro][tamanhoTabuleiro];

        Random random = new Random();
        int isWall;

        for(int i = 0; i < tamanhoTabuleiro; i++){
            for(int j = 0; j < tamanhoTabuleiro; j++) {
                isWall = random.nextInt(0, 101);
                if(isWall <= 80) {
                    tabuleiro[i][j] = '.';
                } else {
                    tabuleiro[i][j] = '█';
                }
            }
        }

        Jogador jogador = new Jogador(tabuleiro);

        Dinossauros[] d1 = new Dinossauros[10];

        d1[0] = new Compsognato(tabuleiro, tamanhoTabuleiro);
        d1[1] = new Compsognato(tabuleiro, tamanhoTabuleiro);
        d1[2] = new Velociraptor(tabuleiro, tamanhoTabuleiro);
        d1[3] = new Velociraptor(tabuleiro, tamanhoTabuleiro);
        d1[4] = new Troodonte(tabuleiro, tamanhoTabuleiro);
        d1[5] = new Troodonte(tabuleiro, tamanhoTabuleiro);
        d1[6] = new Troodonte(tabuleiro, tamanhoTabuleiro);
        d1[7] = new Troodonte(tabuleiro, tamanhoTabuleiro);
        d1[8] = new Troodonte(tabuleiro, tamanhoTabuleiro);
        d1[9] = new Tiranossauro(tabuleiro, tamanhoTabuleiro);



        int isInGame;

        while(true) {
            for (int i = 0; i < tamanhoTabuleiro; i++) {
                for (int j = 0; j < tamanhoTabuleiro; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }

            isInGame = jogador.move(tabuleiro, tamanhoTabuleiro);

            if(isInGame == 5){
                break;
            }

            for (int i = 0; i < 9; i++) {
                d1[i].move(tabuleiro, tamanhoTabuleiro);
            }

            System.out.println();
            System.out.println();
        }
    }
}