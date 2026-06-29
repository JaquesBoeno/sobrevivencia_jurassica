package TrabalhoPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int map_size = 15;
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
        Box b1 = new Box(map, dinos);
        Box b2 = new Box(map, dinos);
        Box b3 = new Box(map, dinos);
        Box b4 = new Box(map, dinos);
        Box b5 = new Box(map, dinos);

        System.out.println(b1.getType() + " " + b2.getType() + " " + b3.getType() + " " + b4.getType() + " " + b5.getType());

        Player player = new Player(map);

        while(true) {
            map.renderMap(player.getPos(), 3);
            char input = '-';

            System.out.println("--------------");
            System.out.println("Saúde: " + player.getHealth());
            System.out.println(player.renderInventory());
            System.out.println("--------------");
            System.out.println("User WASD para se mover (digite apenas um caracter por vez em minusculo)");
            System.out.println("(0) Sair do jogo");
            System.out.println("--------------");

            do {
                if (input != '-')
                    System.out.println("Opção invalida, digite novamente.");
                input = scanner.next().charAt(0);
            } while ("wasd0".indexOf(input) < 0); // intervalo de inputs valido

            if (input == '0') {
                break;
            }

            if ("wasd".indexOf(input) >= 0) {
                int dir = switch (input) {
                    case 'w' -> 3;
                    case 'a' -> 0;
                    case 's' -> 2;
                    case 'd' -> 1;
                    default -> 0;
                };

                player.setDirection(dir);
                player.move();
            }

            for (int i = 0; i < dinos.length; i++) {
                dinos[i].move();
            }

            System.out.println();
            System.out.println();
        }

        scanner.close();
    }
}