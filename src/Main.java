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
        Tamagochi startTama = new Tamagochi(name);
        Tamagochis.add(startTama);
        int charselect = 1;

        while (charselect == 1) {
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
                for (i = 0; i < Tamagochis.size(); i++) {
                    System.out.println("Mata in siffra på tamagochi som önskas spela med");
                    System.out.println((i + 1) + ". " + Tamagochis.get(i).name);
                    int tamaplay = scn.nextInt();
                    exe(Tamagochis.get(tamaplay - 1));
                }
            }

        }


    }


    private static void exe(Tamagochi tamagochi) {
    }
}