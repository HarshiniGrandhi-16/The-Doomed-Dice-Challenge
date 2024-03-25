public class DiceCombinations {
    public static void main(String[] args) {
        int[][] combinations = new int[6][6];
        int[] sumsFrequency = new int[11]; // 11 possible sums from 2 to 12
        
        // Store combinations and calculate frequency of sums
        int totalCombinations = 0;
        for (int dieA = 1; dieA <= 6; dieA++) {
            for (int dieB = 1; dieB <= 6; dieB++) {
                int sum = dieA + dieB;
                combinations[dieA - 1][dieB - 1] = sum;
                sumsFrequency[sum - 2]++; // Subtract 2 to map sum 2 to index 0
                totalCombinations++;
            }
        }

        // Display the probability of each sum
        System.out.println("Probability of each possible sum:");
        for (int i = 0; i < 11; i++) {
            double probability = (double) sumsFrequency[i] / totalCombinations;
            System.out.printf("P(Sum = %d) = %.2f\n", i + 2, probability);
        }
    }
}
