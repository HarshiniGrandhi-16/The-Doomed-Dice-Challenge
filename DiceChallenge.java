import java.util.Random;
import java.util.Scanner;

class Dice {
    private int[] faces = {1, 2, 3, 4, 5, 6};
    private Random random = new Random();

    public int roll() {
        int randomIndex = random.nextInt(faces.length);
        return faces[randomIndex];
    }
}

public class DoomedDiceChallenge {
    public static void main(String[] args) {
        Dice dieA = new Dice();
        Dice dieB = new Dice();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press Enter to roll the dice...");
            scanner.nextLine();
            int rollA = dieA.roll();
            int rollB = dieB.roll();
            int total = rollA + rollB;
            System.out.println("Die A: " + rollA + ", Die B: " + rollB + ", Total: " + total);
            // Assuming 
            if (total == 7) { 
                System.out.println("You lose!");
                break;
            } else if (total == 11) {
                System.out.println("You win!");
                break;
            }
        }
    }
}
