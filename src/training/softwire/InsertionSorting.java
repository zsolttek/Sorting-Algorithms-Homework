package training.softwire;

import java.util.ArrayList;
import java.util.List;

public class InsertionSorting implements Sorting{

    public List<Integer> sort(List<Integer> unsortedListOfNumbers) {
        return insertionSort(unsortedListOfNumbers);
    }

    private static List<Integer> insertionSort(List<Integer> numbers) {
        if (numbers.size() <= 1) {
            return numbers;
        }

        List<Integer> sortedList = new ArrayList<>();
        List<Integer> unsortedList = new ArrayList<>();
        sortedList.add(numbers.get(0));
        unsortedList.addAll(numbers);
        unsortedList.remove(0);

        while (!unsortedList.isEmpty()) {
            int numberToBeCompared = unsortedList.get(0);

            if (sortedList.size() == 1) {
                if (numberToBeCompared >= sortedList.get(0)) {
                    sortedList.add(numberToBeCompared);
                } else {
                    sortedList.add(0, numberToBeCompared);
                }
            } else { //sorted list has 2 or more elements
                for (int lastIndex = sortedList.size() - 1; lastIndex >= 0; lastIndex--) {
                    if(numberToBeCompared < sortedList.get(0)) {
                        sortedList.add(0, numberToBeCompared);
                        break;
                    }

                    if (numberToBeCompared >= sortedList.get(lastIndex)) {
                        sortedList.add(lastIndex + 1, numberToBeCompared);
                        break;
                    }
                }
            }
            unsortedList.remove(0);
        }

        return sortedList;
    }
}
