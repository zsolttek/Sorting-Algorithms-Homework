package training.softwire.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import training.softwire.InsertionSorting;
import training.softwire.MergeSorting;
import training.softwire.SelectionSorting;
import training.softwire.Sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SortingTest {
    Sorting sortingAlgorithm;
    List<Integer> unsortedTestingNumbers = generateList();
    List<Integer> sortedTestingNumbers = generateSortedVersion();
    List<Integer> emptyTestingList = new ArrayList<>();


    public SortingTest() {
        this.sortingAlgorithm = new InsertionSorting();
//        this.sortingAlgorithm = new MergeSorting();
//        this.sortingAlgorithm = new SelectionSorting();
    }

    @Test
    public void shouldReturnAnEmptyListIfEmptyListIsPassedIn() {
        List<Integer> sortedList = sortingAlgorithm.sort(emptyTestingList);
        assertEquals(0, sortedList.size());
        assertNotEquals(1, sortedList.size());
        assertNotEquals(sortedTestingNumbers.size(), sortedList.size());
    }

    @Test
    public void shouldReturnTheListIfAListWithOneElementIsPassedIn() {
        List<Integer> testListWithOneElement = new ArrayList<>();
        testListWithOneElement.add(1000);
        List<Integer> sortedList = sortingAlgorithm.sort(testListWithOneElement);
        assertEquals(testListWithOneElement.get(0), sortedList.get(0));
        assertEquals(testListWithOneElement.size(), sortedList.size());
    }

    @Test
    public void shouldHaveThreeNegatives() {
        List<Integer> sortedList = sortingAlgorithm.sort(unsortedTestingNumbers);
        List<Integer> result = sortedList.stream()
                .filter(nr -> nr < 0)
                .collect(Collectors.toList());
        assertEquals(3, result.size());
    }

    @Test
    public void orderShouldMatch() {
        List<Integer> sortedList = sortingAlgorithm.sort(unsortedTestingNumbers);
        for(int i = 0; i < sortedList.size() - 1; i++) {
            assertEquals(sortedList.get(i), sortedTestingNumbers.get(i));
        }
    }

    private List<Integer> generateList() {
        List<Integer> result = new ArrayList<>();
        result.add(-2);
        result.add(1);
        result.add(-1);
        result.add(3);
        result.add(0);
        result.add(2);
        result.add(2);
        result.add(100);
        result.add(6);
        result.add(4);
        result.add(-1);
        return result;
    }

    private List<Integer> generateSortedVersion() {
        List<Integer> result = new ArrayList<>();
        result.add(-2);
        result.add(-1);
        result.add(-1);
        result.add(0);
        result.add(1);
        result.add(2);
        result.add(2);
        result.add(3);
        result.add(4);
        result.add(6);
        result.add(100);
        return result;
    }
}
