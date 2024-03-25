public class DiceCombinations {
    public static void main(String[] args) {
        int[][] combinations = new int[6][6];

        // Store combinations without calculating sum
        for (int dieA = 1; dieA <= 6; dieA++) {
            for (int dieB = 1; dieB <= 6; dieB++) {
                combinations[dieA - 1][dieB - 1] = (dieA * 10) + dieB;
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
    }
}
