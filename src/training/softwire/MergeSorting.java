package training.softwire;

import java.util.ArrayList;
import java.util.List;

public class MergeSorting implements Sorting {

    public List<Integer> sort(List<Integer> unsortedListOfNumbers) {
        return mergeSort(unsortedListOfNumbers);
    }

    private static List<Integer> mergeSort(List<Integer> numbers) {
        int size = numbers.size();
        if(size <= 1) {
            return numbers;
        }

        int middle = size / 2;
        List<Integer> left = numbers.subList(0, middle) ;
        List<Integer> right = numbers.subList(middle, size);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        int indexToInsert = 0;

        while(leftIndex < left.size() || rightIndex < right.size()) {
            if (leftIndex < left.size() && rightIndex < right.size()) {
                if (left.get(leftIndex) < right.get(rightIndex)) {
                    result.add(indexToInsert, left.get(leftIndex));
                    leftIndex++;
                } else {
                    result.add(indexToInsert, right.get(rightIndex));
                    rightIndex++;
                }
                indexToInsert++;
            } else if(leftIndex < left.size()) {
                result.add(indexToInsert, left.get(leftIndex));
                leftIndex++;
                indexToInsert++;
            } else if(rightIndex < right.size()) {
                result.add(indexToInsert, right.get(rightIndex));
                rightIndex++;
                indexToInsert++;
            }
        }

        return result;
    }
}
