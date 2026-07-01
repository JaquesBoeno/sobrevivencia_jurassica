package TrabalhoPOO;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int map_size = 20;
        int choice = 0;
        int dificuldade =0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=======================");
            System.out.println("Bem vindo ao Sobrevivência Jurassica! O que deseja fazer?");
            System.out.println("(1) Iniciar novo Jogo\t(2) Iniciar novo Jogo em mode debug (visão completa)\n(3) Encerrar o programa");
            choice = scanner.nextInt();
            if (choice == 3){
                break;
            }
            int percepcao = 3;
            if (choice == 2){
                dificuldade = 100;
            }
            if (choice == 1){
                System.out.println("Qual dificuldade deseja?\n(3) facil\t(2) medio\t(1) dificil");
                dificuldade = scanner.nextInt();
                percepcao = dificuldade;
            }
            Main.RunGame(map_size, dificuldade*2 +0.2, percepcao);
            System.out.println("=======================");
        } while(choice != 3);
        scanner.close();
    }

    private static void  RunGame(int map_size, double dificuldade, int percepcao){
        Scanner scanner = new Scanner(System.in);
        Map map = new Map(map_size);
        Vector<Dinosaur> dinos = new Vector<>();

        dinos.add(new Compsognato(map, dinos));
        dinos.add(new Compsognato(map, dinos));
        dinos.add( new Velociraptor(map, dinos));
        dinos.add( new Velociraptor(map, dinos));
        dinos.add( new Troodonte(map, dinos));
        dinos.add(new Troodonte(map, dinos));
        dinos.add( new Troodonte(map, dinos));
        dinos.add( new Troodonte(map, dinos));
        dinos.add( new Troodonte(map, dinos));
        dinos.add( new Tiranossauro(map, dinos));
        Box b1 = new Box(map, dinos);
        Box b2 = new Box(map, dinos);
        Box b3 = new Box(map, dinos);
        Box b4 = new Box(map, dinos);
        Box b5 = new Box(map, dinos);

        System.out.println(b1.getType() + " " + b2.getType() + " " + b3.getType() + " " + b4.getType() + " " + b5.getType());

        Player player = new Player(map, percepcao);

        while(true) {
            map.renderMap(player.position, dificuldade);
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
            } while ("wasd0k".indexOf(input) < 0); // intervalo de inputs valido

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

            for (Dinosaur d: dinos) {
                if (d.isAlive())
                    d.move();
            }
            dinos.removeIf(d -> !d.isAlive());

            if (dinos.isEmpty()){
                System.out.println("Parabens você matou todos dinossauros e venceu o jogo! :)");
                break;
            }
            if (player.getHealth() <= 0 || input == 'k'){
                System.out.println("Infelizmente você morreu e perdeu o jogo :(");
                break;
            }

            System.out.println();
            System.out.println();
        }
    }
}