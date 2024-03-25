import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class DoomedDiceChallenge {

    public static void main(String[] args) {
        // Part A: Rolling dice
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
            if (total == 7) {
                System.out.println("You lose!");
                break;
            } else if (total == 11) {
                System.out.println("You win!");
                break;
            }
        }

        // Part B: Total Combinations
        int numFaces = 6;
        int totalCombinations = numFaces * numFaces;
        System.out.println("Total combinations possible: " + totalCombinations);

        // Part C: Dice Combinations
        int[][] combinations = new int[6][6];
        int[] sumsFrequency = new int[11]; // 11 possible sums from 2 to 12

        // Store combinations and calculate frequency of sums
        int totalCombinationsC = 0;
        for (int dieAValue = 1; dieAValue <= 6; dieAValue++) {
            for (int dieBValue = 1; dieBValue <= 6; dieBValue++) {
                int sum = dieAValue + dieBValue;
                combinations[dieAValue - 1][dieBValue - 1] = sum;
                sumsFrequency[sum - 2]++; // Subtract 2 to map sum 2 to index 0
                totalCombinationsC++;
            }
        }

        // Display the distribution
        System.out.println("Distribution of Dice Combinations:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(combinations[i][j] + "\t");
            }
            System.out.println();
        }

        // Display the probability of each sum
        System.out.println("Probability of each possible sum:");
        for (int i = 0; i < 11; i++) {
            double probability = (double) sumsFrequency[i] / totalCombinationsC;
            System.out.printf("P(Sum = %d) = %.2f\n", i + 2, probability);
        }

        // Part D: Dice Transformation
        int[] initialDieA = {1, 2, 3, 4, 5, 6};
        int[] initialDieB = {1, 2, 3, 4, 5, 6};

        int[] newDieA = undoom_dice(initialDieA, initialDieB).get("New_Die_A");
        int[] newDieB = undoom_dice(initialDieA, initialDieB).get("New_Die_B");

        System.out.println("New Die A: " + arrayToString(newDieA));
        System.out.println("New Die B: " + arrayToString(newDieB));
    }

    static class Dice {
        private int[] faces = {1, 2, 3, 4, 5, 6};
        private Random random = new Random();

        public int roll() {
            int randomIndex = random.nextInt(faces.length);
            return faces[randomIndex];
        }
    }

    public static Map<String, int[]> undoom_dice(int[] dieA, int[] dieB) {
        Map<String, int[]> result = new HashMap<>();

        int[] newDieA = new int[6];
        int[] newDieB = new int[6];

        // Calculate the transformation for Die B (no constraints)
        System.arraycopy(dieB, 0, newDieB, 0, dieB.length);

        // Calculate the transformation for Die A respecting the constraints
        // To maintain the same probabilities, we distribute the spots evenly
        // among the faces with constraints (no more than 4 spots per face)
        int totalSpots = 0;
        for (int spot : dieA) {
            totalSpots += spot;
        }
        int spotsPerFace = totalSpots / 6;
        int extraSpots = totalSpots % 6;

        for (int i = 0; i < newDieA.length; i++) {
            newDieA[i] = spotsPerFace;
            if (extraSpots > 0) {
                newDieA[i]++;
                extraSpots--;
            }
        }

        result.put("New_Die_A", newDieA);
        result.put("New_Die_B", newDieB);

        return result;
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
