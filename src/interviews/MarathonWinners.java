package interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MarathonWinners {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPositions(new int[]{1, 3, 0, -1})));
        System.out.println(Arrays.toString(getPositions(new int[]{4, 5, 0, -1, 1, 3})));
    }

    static int[] getPositions(int[] winners) {
        Map<Integer/*Position*/, Integer /*Index*/> positionToIndexMap = new HashMap<>();
        boolean found1st = false;
        for (int i = 0; i < winners.length; ++i) {
            // Entries > n  length of array
            // Winner index < -1
            // Duplicates
            if (winners[i] > winners.length - 1 || winners[i] < -1 || positionToIndexMap.containsKey(winners[i])) {
                throw new RuntimeException("Invalid input array -- data error”");
            }
            if (winners[i] == -1) {
                found1st = true;
            }
            positionToIndexMap.put(winners[i], i);
        }
        if (!found1st) throw new RuntimeException("Invalid input array--missing 1st winner");

        int[] output = new int[winners.length];
        int outIdx = 0;
        int pos = -1;
        while (positionToIndexMap.containsKey(pos)) {
            int idx = positionToIndexMap.get(pos);
            output[outIdx++] = idx;
            pos = idx;
        }
        if (outIdx != winners.length) throw new RuntimeException("Invalid input array -- data error");

        return output;
    }

}
