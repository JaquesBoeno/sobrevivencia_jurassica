package TrabalhoPOO;

import java.util.Scanner;
import java.util.Random;

public abstract class Combate {
    public static void luta(Player player, Dinosaur dinossauro, Inventory inventario, Map map, Dinosaur[] dinos, int flag){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num;
        char escolha = 'M';

        if(flag != 0){
            num = random.nextInt(1, 4);
            if(player.getPercepcao() < num){
                System.out.println("Você recebeu dano");
                player.recebeAtaque(1);
                System.out.println("Saúde: " + player.getHealth());
            }
        }

        while(player.getHealth() > 0 && dinossauro.getHealth() > 0) {
            System.out.println("---------------------");
            System.out.println("Escolha o que fazer:");
            System.out.print("M- Ataque corpo-a-corpo " + (inventario.getItems()[0] == 0 ? "com as mãos" : "com bastão elétrico"));
            System.out.print(inventario.getItems()[1] == 0 ? "" : "\nR- Ataque com arma de dardos " + inventario.getItems()[1] + "m");
            System.out.print(inventario.getItems()[2] == 0 ? "" : "\nH- Se curar");
            System.out.println("\nF- Fugir");

            do{
                if(escolha != 'M'){
                    System.out.println("Opção inválida");
                }
                escolha = scanner.next().charAt(0);
            } while(escolha != 'M' && !(escolha == 'R' && inventario.getItems()[1] != 0) && !(escolha == 'H' && inventario.getItems()[2] != 0) && escolha != 'F');

            if(escolha == 'M'){
                num = random.nextInt(1, 7);

                if(inventario.getItems()[0] != 0){
                    if(num >= 5){
                        dinossauro.recebeAtaque(2);
                    } else if(num > 1){
                        dinossauro.recebeAtaque(1);
                    }
                } else if(dinos[dinossauro.getIndex()].getClass() != Tiranossauro.class){
                    if(num == 6){
                        dinossauro.recebeAtaque(2);
                    } else if(num > 2){
                        dinossauro.recebeAtaque(1);
                    }
                }
            } else if (escolha == 'R'){
                if(dinos[dinossauro.getIndex()].getClass() != Velociraptor.class){
                    dinos[dinossauro.getIndex()].recebeAtaque(2);
                    inventario.takeItem(1);
                } else {
                    System.out.println("Armas de dardos são inefetivas contra velociraptors");
                }
            } else if (escolha == 'H'){
                player.recebeAtaque(-1);
                inventario.takeItem(2);
            } else if(escolha == 'F'){
                break;
            }

            System.out.println("Vida do inimigo: " + dinossauro.getHealth());

            if(dinossauro.getHealth() <= 0){
                Cell c = map.getCellAt(dinossauro.position.getPosX(), dinossauro.position.getPosY());
                Dinosaur d = (Dinosaur) c.getEntity();
                dinos[d.getIndex()] = null;
                c.setEntity(null);
                break;
            }

            num = random.nextInt(1, 4);
            if(player.getPercepcao() < num){
                System.out.println("Você recebeu dano");
                player.recebeAtaque(1);
                System.out.println("Saúde: " + player.getHealth());
            }

            escolha = 'M';
        }
    }
}
