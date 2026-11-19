import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        //variables
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int [] dataPoints = new int[100];
        int minimum = 100;
        int maximum = 0;
        int userNum = 0;
        int intSearch = 0;
        int intCount = 0;
        int intBreak = 0;
        int intFound = 0;
        int total = 0;

        double averageNum = 0.0;

        boolean breakValid = false;

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100)+1;

            if (dataPoints[i] < minimum) {
                minimum = dataPoints[i];
            }

            if (dataPoints[i] > maximum) {
                maximum = dataPoints[i];
            }
            total += dataPoints[i];
        }

        intSearch = InputHelper.getRangedInt(scan, "Enter an integer to search for:", 1, 100);

        for (int x : dataPoints) {
            System.out.print(x + "|");

            if (x == intSearch) {
                intCount++;
            }
        }

        intBreak = InputHelper.getRangedInt(scan, "\nEnter an integer that when found will break the array :", 1, 100);
        for (int i = 0; i < dataPoints.length; i++) {
            if (intBreak == dataPoints[i]) {
                intFound = i;
                breakValid = true;
                break;
            }
        }

        averageNum = total/dataPoints.length;
        System.out.println("\nSum of all elements in dataPoints: " + total);
        System.out.println("Average of all elements in dataPoints: " + averageNum);
        System.out.println("\nMinimum of all elements in dataPoints: " + minimum);
        System.out.println("Maximum of all elements in dataPoints: " + maximum);
        System.out.println("\nYour integer, " + intSearch + ", is found this many times: " + intCount);

        if (breakValid) {
            System.out.println("The value " + intBreak + " was found at array index: " + intFound);
        } else {
            System.out.println("The value " + intBreak + " was NOT found in the array");
        }
    }
}