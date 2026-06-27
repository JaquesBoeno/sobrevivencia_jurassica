package TrabalhoPOO;

import java.util.Random;

public abstract class Dinossauros {
    private int vida;
    private int dano;
    int posicaoX;
    int posicaoY;

    protected int ataca() {
        return dano;
    }

    abstract protected void move(char[][] tabuleiro, int tamanhoTabuleiro);

    // abstract void recebeAtaque();
}