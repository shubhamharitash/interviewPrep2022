package leetcodeBasicQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    private int index;
    private int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class CustomComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair pair1, Pair pair2) {
        if (pair1.getValue() > pair2.getValue())
            return 1;
        else if (pair1.getValue() == pair2.getValue()) {
            return Integer.compare(pair1.getIndex(), pair2.getIndex());
        }
        return -1;
    }
}

public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new CustomComparator());
        for (int i = 0; i < mat.length; i++){
            int value = Arrays.stream(mat[i]).reduce(0, Integer::sum);
            minHeap.add(new Pair(i, value));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.remove().getIndex();
        }
        return result;
    }
}
