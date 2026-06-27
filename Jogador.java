package TrabalhoPOO;

import java.util.Scanner;

public class Jogador {
    private int vida = 5;
    private int percepcao;
    int posicaoX;
    int posicaoY;

    public Jogador(char[][] tabuleiro){
        posicaoX = 0;
        posicaoY = 0;
        tabuleiro[posicaoX][posicaoY] = 'P';
    }

    public int move(char[][] tabuleiro, int tamanhoTabuleiro){
        System.out.println("Escolha para onde se mover: ");
        System.out.println("1- Cima");
        System.out.println("2- Baixo");
        System.out.println("3- Esquerda");
        System.out.println("4- Direita");
        System.out.println("5- Sair do jogo");

        Scanner scanner = new Scanner(System.in);
        int direcao;
        int flag;

        do{
            flag = 1;
            direcao = scanner.nextInt();

            if(direcao > 5 || direcao < 1){
                System.out.println("Direção inválida");
                flag = 0;
            } else if((direcao == 1 && (posicaoX - 1 < 0 || tabuleiro[posicaoX - 1][posicaoY] != '.')) || (direcao == 2 && (posicaoX + 1 >= tamanhoTabuleiro || tabuleiro[posicaoX + 1][posicaoY] != '.')) || (direcao == 3 && (posicaoY - 1 < 0 || tabuleiro[posicaoX][posicaoY - 1] != '.')) || (direcao == 4 && (posicaoY + 1 >= tamanhoTabuleiro || tabuleiro[posicaoX][posicaoY + 1] != '.'))) {
                System.out.println("Direção inválida");
                flag = 0;
            }
        } while(flag == 0);

        tabuleiro[posicaoX][posicaoY] = '.';

        if(direcao == 1){
            posicaoX--;
            tabuleiro[posicaoX][posicaoY] = 'P';
        } else if(direcao == 2){
            posicaoX++;
            tabuleiro[posicaoX][posicaoY] = 'P';
        } else if(direcao == 3){
            posicaoY--;
            tabuleiro[posicaoX][posicaoY] = 'P';
        } else if(direcao == 4){
            posicaoY++;
            tabuleiro[posicaoX][posicaoY] = 'P';
        } else{
            System.out.println("Você saiu do jogo");
        }

        return direcao;
    }
}
