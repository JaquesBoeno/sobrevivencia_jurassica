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
            char input = '-';
            System.out.println("User WASD para se mover (digite apenas um caracter por vez em minusculo)");
            System.out.println("(0) Sair do jogo");

            do {
                if (input!= '-')
                    System.out.println("Opção invalida, digite novamente.");
                input = scanner.next().charAt(0);
            }while("wasd0".indexOf(input) < 0); // intervalo de inputs valido

            if(input == '0'){
                break;
            }

            if ("wasd".indexOf(input) >= 0){
                int dir = 0;
                switch (input ){
                    case 'w':
                        dir = 3;
                        break;
                    case 'a':
                        dir = 0;
                        break;
                    case 's':
                        dir = 2;
                        break;
                    case 'd':
                        dir = 1;
                        break;
                }

                player.setDirection(dir);
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