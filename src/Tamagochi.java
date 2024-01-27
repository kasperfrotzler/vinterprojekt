import java.util.Random;
import java.util.ArrayList;


public class Tamagochi {
    /*
    Attribut
     */
    private int hunger = 3;
    private int boredom = 2;
    private boolean isAlive = true;
    private Random random = new Random();
    public String name;
    private ArrayList<String> words = new ArrayList<String>();

    /*
    Konstruktor
     */
    public Tamagochi(String name) {
        this.name = name;
    }

    /*
    Metoder
     */
    public void Feed() {
        this.hunger = this.hunger - (random.nextInt(1, 4));
        if (this.hunger < 0) {
            this.hunger = 0;
        }

    }

    public void Hi() {
        ReduceBoredom();
        if (words.size() > 0) {
            System.out.println(words.get(random.nextInt(words.size())));
        } else {
            System.out.println("Din Tamagochi har inte lärt sig några ord än");
        }
    }

    public void Teach(String word) {
        ReduceBoredom();
        words.add(word);
    }

    public void Tick() {
        this.hunger++;
        this.boredom++;
        if (hunger > 12 || boredom > 12) {
            isAlive = false;
        }
    }

    public void PrintStatus() {
        if (this.isAlive == true) {
            System.out.println("Din Tamagochi lever");

        } else {
            System.out.println("Din Tamagochi har dött");
        }
    }

    public int getHunger() {
        return hunger;
    }


    public int getBoredom() {
        return boredom;
    }

    public boolean GetAlive() {
        return isAlive;
    }

    private void ReduceBoredom() {
        this.boredom = this.boredom - (random.nextInt(1, 4));
        if (this.boredom < 0) {
            this.boredom = 0;
        }

    }
}
