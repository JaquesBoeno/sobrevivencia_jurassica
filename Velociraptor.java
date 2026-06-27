package TrabalhoPOO;

import java.util.Random;

public class Velociraptor extends Dinossauros{
    private int vida;
    private int dano;
    int posicaoX;
    int posicaoY;

    public Velociraptor(char[][] tabuleiro, int tamanhoTabuleiro){
        Random random = new Random();
        do {
            posicaoX = random.nextInt(0, tamanhoTabuleiro);
            posicaoY = random.nextInt(0, tamanhoTabuleiro);
        } while (tabuleiro[posicaoX][posicaoY] != '.' || (posicaoX == tamanhoTabuleiro - 1 && posicaoY == tamanhoTabuleiro - 1) || (posicaoX == 0 && posicaoY == 0));
        tabuleiro[posicaoX][posicaoY] = 'V';
    }

    protected int ataca() {
        return super.ataca();
    }

    protected void move(char[][] tabuleiro, int tamanhoTabuleiro){
        int direcao;
        Random random = new Random();

        for(int i = 0; i < 2; i++) {
            direcao = random.nextInt(0, 4);

            tabuleiro[posicaoX][posicaoY] = '.';

            if (direcao == 0 && posicaoX - 1 >= 0 && tabuleiro[posicaoX - 1][posicaoY] == '.') {
                posicaoX--;
            } else if (direcao == 1 && posicaoX + 1 < tamanhoTabuleiro && tabuleiro[posicaoX + 1][posicaoY] == '.') {
                posicaoX++;
            } else if (direcao == 2 && posicaoY - 1 >= 0 && tabuleiro[posicaoX][posicaoY - 1] == '.') {
                posicaoY--;
            } else if (direcao == 3 && posicaoY + 1 < tamanhoTabuleiro && tabuleiro[posicaoX][posicaoY + 1] == '.') {
                posicaoY++;
            }

            tabuleiro[posicaoX][posicaoY] = 'V';
        }
    }
}