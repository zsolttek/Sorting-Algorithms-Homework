package training.softwire;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        LocalTime start;
        LocalTime finish;
        List<Integer> listOfUnsortedNumbers = buildListWithRandomNumbers(11, 1000);

        System.out.println("Unsorted numbers:         " + listOfUnsortedNumbers);
        System.out.println();


        start = LocalTime.now();
        System.out.println("Insertion sort:           " + new InsertionSorting().sort(listOfUnsortedNumbers));
        finish = LocalTime.now();
        System.out.println("Duration: " + Duration.between(start, finish).getNano());

        System.out.println();

        start = LocalTime.now();
        System.out.println("Merge sort:               " + new MergeSorting().sort(listOfUnsortedNumbers));
        finish = LocalTime.now();
        System.out.println("Duration: " + Duration.between(start, finish).getNano());

        System.out.println();

        start = LocalTime.now();
        System.out.println("Selection sort:           " + new SelectionSorting().sort(listOfUnsortedNumbers));
        finish = LocalTime.now();
        System.out.println("Duration: " + Duration.between(start, finish).getNano());
    }

    private static List<Integer> buildListWithRandomNumbers(int listSize, int limit) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        while(listSize > 0) {
            int randomNumber = random.nextInt(limit + 1);
            if(random.nextBoolean()) {
                result.add(randomNumber);
            } else {
                result.add(-randomNumber);
            }
            listSize--;
        }
        return result;
    }
}
