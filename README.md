# The-Doomed-Dice-Challenge

Dice Rolling Logic: The Dice class simulates rolling a six-sided die. It maintains an array representing the faces of the die and utilizes java.util.Random to generate a random index within the range of the array, effectively simulating the roll of the die.

Game Simulation Logic: In the main method, the program simulates a game where two dice (Die A and Die B) are rolled together. It repeatedly prompts the user to roll the dice until the sum of the rolls equals either 7 or 11, signifying a loss or a win respectively.

Total Combinations Logic: It calculates the total number of combinations possible when rolling two six-sided dice by multiplying the number of faces on each die.

Dice Combinations Distribution Logic: It creates a 6x6 matrix to represent all possible combinations of rolls of Die A and Die B. Each cell in the matrix holds the sum of the faces of Die A and Die B for the corresponding combination.

Probability Calculation Logic: It calculates the probability of each possible sum occurring by dividing the frequency of each sum by the total number of combinations. This is done by iterating through the sums and dividing the frequency of each sum by the total number of combinations.

Dice Transformation Logic: It transforms Die A according to the constraints imposed by Loki, while leaving Die B unchanged. The transformation ensures that the probabilities of different outcomes remain the same. It calculates the total number of spots on Die A, then distributes these spots evenly among the faces, ensuring that no face has more than 4 spots. Any extra spots are distributed among the faces as evenly as possible.
