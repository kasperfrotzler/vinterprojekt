import java.util.ArrayList;
import java.util.InputMismatchException;
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

            try {
                System.out.println("Mata in siffra på tamagochi vars stats önskas");
                int tamachoice = scn.nextInt();
                if (tamachoice <= Tamagochis.size()) {
                    for (i = 0; i < Tamagochis.size(); i++) {
                        if (Tamagochis.get(i).getHunger() > 12 || Tamagochis.get(i).getBoredom() > 12 || Tamagochis.get(i).getThirst() > 12) {
                            Tamagochis.remove(i);
                        }
                    }

                    System.out.println(Tamagochis.get(tamachoice - 1).name + "'s hunger är " + Tamagochis.get(tamachoice - 1).getHunger());
                    System.out.println(Tamagochis.get(tamachoice - 1).name + "'s boredom är " + Tamagochis.get(tamachoice - 1).getBoredom());
                    System.out.println(Tamagochis.get(tamachoice - 1).name + "'s thirst är " + Tamagochis.get(tamachoice - 1).getThirst());
                    break;
                } else {
                    System.out.println("Ogiltigt val");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ogiltigt val");
                System.out.println("Välj mellan valbara nummer");
                scn.nextLine();
            }
        }
        scn.nextLine();
        while (true) {

            try {
                System.out.println("Vill du skapa ytterligare en Tamagochi? (j / n)");
                String createTama = scn.nextLine();

                if (createTama.equalsIgnoreCase("j")) {
                    System.out.println("Vad vill du att din Tamagochi ska heta?");
                    String newName = scn.nextLine();
                    Tamagochis.add(new Tamagochi(newName));
                } else if (createTama.equalsIgnoreCase("n")) {
                    while (true) {
                        try {
                            System.out.println("Mata in siffra på tamagochi som önskas spela med");
                            int i;
                            for (i = 0; i < Tamagochis.size(); i++) {
                                System.out.println((i + 1) + ". " + Tamagochis.get(i).name);

                            }
                            int tamaplay = Integer.parseInt(scn.nextLine());
                            if (tamaplay <= Tamagochis.size()) {
                                exe(Tamagochis.get(tamaplay - 1));
                                break;
                            } else {
                                System.out.println("Ogiltigt val");
                            }
                        } catch (Exception e) {
                            System.out.println("Ogiltigt val");
                            System.out.println("Välj mellan valbara nummer");
                        }
                    }


                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ogiltigt val");
                System.out.println("Välj mellan j eller n");
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
            if (action <= 5) {


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
                        Random earnings = new Random();
                        int earningsout = earnings.nextInt(1 - 5) - 1;
                        switch (earningsout) {
                            case 1:
                                money = money + 10;
                            case 2:
                                money = money + 20;
                            case 3:
                                money = money + 30;
                                break;
                            case 4:
                                money = money + 40;
                                break;
                            case 5:
                                money = money + 50;
                                break;
                        }
                        System.out.println("Din tamagochi sålde lemonad");
                        System.out.println("Du balance är nu " + money);
                        break;
                    case 5:
                        System.out.println(tamagochi.name + " gjorde ingenting");
                        break;
                    default:
                        System.out.println(" ");
                        tamagochi.Tick();
                        System.out.println(tamagochi.name + "'s hunger är " + tamagochi.getHunger());
                        System.out.println(tamagochi.name + "'s boredom är " + tamagochi.getBoredom());
                        System.out.println(tamagochi.name + "'s thirst är " + tamagochi.getThirst());
                        boolean aliveCheck = tamagochi.GetAlive();
                        if (!aliveCheck) {
                            System.out.println("Din tamagochi har dött");
                            break;
                        }

                }
            }
        }
    }
}