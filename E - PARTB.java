import java.util.HashMap;
import java.util.Map;

public class DiceTransformation {

    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};

        int[] newDieA = undoom_dice(dieA, dieB).get("New_Die_A");
        int[] newDieB = undoom_dice(dieA, dieB).get("New_Die_B");

        System.out.println("New Die A: " + arrayToString(newDieA));
        System.out.println("New Die B: " + arrayToString(newDieB));
    }

    public static Map<String, int[]> undoom_dice(int[] dieA, int[] dieB) {
        Map<String, int[]> result = new HashMap<>();

        int[] newDieA = new int[6];
        int[] newDieB = new int[6];

        // Calculate the transformation for Die B (no constraints)
        for (int i = 0; i < dieB.length; i++) {
            newDieB[i] = dieB[i];
        }

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
