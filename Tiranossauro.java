package TrabalhoPOO;

public class Tiranossauro extends Dinossauros{
    private int vida;
    private int dano;
    int posicaoX;
    int posicaoY;

    public Tiranossauro(char[][] tabuleiro, int tamanhoTabuleiro){
        posicaoX = tamanhoTabuleiro - 1;
        posicaoY = tamanhoTabuleiro - 1;
        tabuleiro[posicaoX][posicaoY] = 'R';
    }

    protected int ataca(){
        return super.ataca();
    }

    protected void move(char[][] tabuleiro, int tamanhoTabuleiro){
        return;
    }
}
