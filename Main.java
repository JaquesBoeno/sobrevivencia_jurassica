package TrabalhoPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int map_size = 11;
        Scanner scanner = new Scanner(System.in);
        Map map = new Map(map_size);
        Dinosaur[] dinos = new Dinosaur[10];

        dinos[0] = new Compsognato(map);
        dinos[1] = new Compsognato(map);
        dinos[2] = new Velociraptor(map);
        dinos[3] = new Velociraptor(map);
        dinos[4] = new Troodonte(map);
        dinos[5] = new Troodonte(map);
        dinos[6] = new Troodonte(map);
        dinos[7] = new Troodonte(map);
        dinos[8] = new Troodonte(map);
        dinos[9] = new Tiranossauro(map);

        Player player = new Player(map);

        while(true) {
            map.renderMap();
            int input = 0;
            System.out.println("Escolha para onde se mover: ");
            System.out.println("1- Cima");
            System.out.println("2- Baixo");
            System.out.println("3- Esquerda");
            System.out.println("4- Direita");
            System.out.println("5- Sair do jogo");

            do {
                if (!(input >= 0 && input < 5))
                    System.out.println("Opção invalida, digite novamente.");
                input = scanner.nextInt();
            }while(!(input >= 0 && input < 5)); // intervalo de inputs valido

            if(input == 0){
                break;
            }

            if (input >= 1 && input <=4){
                player.setDirection(input - 1);
                player.move();
            }

            for (int i = 0; i < dinos.length; i++) {
                dinos[i].move();
            }

            System.out.println();
            System.out.println();
        }
    }
}