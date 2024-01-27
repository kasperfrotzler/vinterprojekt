import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Tamagochi CurrentTama;
        ArrayList<Tamagochi> Tamagochis = new ArrayList<Tamagochi>();
        System.out.println("Kaspers Tamagochi 2024");
        System.out.println("Vad vill du att din första Tamagochi ska heta?");
        String name = scn.nextLine();
        Tamagochi tamagochi = new Tamagochi(name);
        Tamagochis.add(tamagochi);

        while (true) {
            int i = 14;
            System.out.println("Här är alla dina tamagochis:");
            for (i = 0; i < Tamagochis.size(); i++) {
                System.out.println((i + 1) + ". " + Tamagochis.get(i).name);
            }
            System.out.println("Mata in siffra på tamagochi vars stats önskas");
            int tamachoice = scn.nextInt();
            for (i = 0; i < Tamagochis.size(); i++) {
                if (Tamagochis.get(i).getHunger() > 12 || Tamagochis.get(i).getBoredom() > 12) {
                    Tamagochis.remove(i);
                }
            }
            System.out.println(Tamagochis.get(tamachoice - 1).name + "'s hunger är " + Tamagochis.get(tamachoice - 1).getHunger());
            System.out.println(Tamagochis.get(tamachoice - 1).name + "'s boredom är " + Tamagochis.get(tamachoice - 1).getBoredom());
            scn.nextLine();
            System.out.println("Vill du skapa ytterligare en Tamagochi? (y/n)");
            String createTama = scn.nextLine();
            if (createTama.equalsIgnoreCase("y")) {
                System.out.println("Vad vill du att din Tamagochi ska heta?");
                String newName = scn.nextLine();
                Tamagochis.add(new Tamagochi(newName));
            } else if (createTama.equalsIgnoreCase("n")) {
                System.out.println("Mata in siffra på tamagochi som önskas spela med");
                for (i = 0; i < Tamagochis.size(); i++) {
                    System.out.println((i + 1) + ". " + Tamagochis.get(i).name);

                }
                int tamaplay = scn.nextInt();
                exe(Tamagochis.get(tamaplay - 1));
            }

        }


    }


    private static void exe(Tamagochi tamagochi) {
        int money = 80;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Vad vill du göra med din tamagochi");
            System.out.println("1. Mata");
            System.out.println("2. Lär ord");
            System.out.println("3. Säga ord");
            System.out.println("4. Sälj lemonad");
            System.out.println("5. Gör ingenting");
            int action = scn.nextInt();

            switch (action) {
                case 1:
                    money = money - 10;
                    tamagochi.Feed();
                    break;
                case 2:
                    money = money - 10;
                    scn.nextLine();
                    System.out.println("Vad för ord ska " + tamagochi.name + " lära sig?");
                    String taughtWord = scn.nextLine();
                    tamagochi.Teach(taughtWord);
                    System.out.println(tamagochi.name + " lärde sig ordet " + taughtWord);
                    break;
                case 3:
                    tamagochi.Hi();
                    break;
                case 4:
                    money = money + 50;
                    break;
                case 5:
                    System.out.println(tamagochi.name + " gjorde ingenting");
                    break;
                default:
            }
            System.out.println(" ");
            System.out.println(" ");
            tamagochi.Tick();
            System.out.println(tamagochi.name + "'s hunger är " + tamagochi.getHunger());
            System.out.println(tamagochi.name + "'s boredom är " + tamagochi.getBoredom());
            boolean aliveCheck = tamagochi.GetAlive();
            if (!aliveCheck) {
                System.out.println("Din tamagochi har dött");
                break;
            }
            if (action == 5) {
                break;
            }
        }
    }
}