package training.softwire;

import java.util.Collections;
import java.util.List;

public class SelectionSorting implements Sorting {

    public List<Integer> sort(List<Integer> unsortedListOfNumbers) {
        return selectionSorting(unsortedListOfNumbers);
    }

    private List<Integer> selectionSorting(List<Integer> numbers) {
        boolean swap = true;
        boolean smallestFound;
        int highestNumber = findTheHighestNumber(numbers);
        int startingIndex = 0;
        Integer smallest;

        while(swap) {
            smallestFound = false;
            smallest = highestNumber;
            for(Integer number : numbers.subList(startingIndex, numbers.size())) {
                if(number < smallest) {
                    smallest = number;
                    smallestFound = true;
                }
            }

            if(smallestFound) {
                int idxOfSmallestNumber = numbers.indexOf(smallest);
                Collections.swap(numbers, startingIndex, idxOfSmallestNumber);
                startingIndex += 1;
            } else {
                swap = false;
            }
        }

        return numbers;
    }

    private static int findTheHighestNumber(List<Integer> numbers) {
        int result = 0;
        for(Integer number : numbers) {
            if(number > result) {
                result = number;
            }
        }
        return result;
    }
}
