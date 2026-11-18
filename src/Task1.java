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
        int total = 0;
        int averageNum = 0;
        int intSearch = 0;
        int intCount = 0;
        int intBreak;
        int intFound = 0;

        boolean breakValid = false;


        intSearch = InputHelper.getRangedInt(scan, "Enter an integer to search for:", 1, 100);
        intBreak = InputHelper.getRangedInt(scan, "Enter an integer that when found will break the array :", 1, 100);

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100)+1;

            if (dataPoints[i] <= minimum) {
                minimum = dataPoints[i];
            }

            if (dataPoints[i] >= maximum) {
                maximum = dataPoints[i];
            }

            total += dataPoints[i];


            // search for intSearch and break when intBreak is found
            if (dataPoints[i] == intSearch) {
                    intCount++;
            }

            if (dataPoints[i] == intBreak) {
                    intFound = dataPoints[i];
                    breakValid = true;
                    break;
            } else {
                    break;
            }
        }



        for (int x : dataPoints) {
            System.out.print(x + "|");
        }

        averageNum = total/dataPoints.length;
        System.out.println("\nSum of all elements in dataPoints: " + total);
        System.out.println("Average of all elements in dataPoints: " + averageNum);
        System.out.println("Minimum of all elements in dataPoints: " + minimum);
        System.out.println("Maximum of all elements in dataPoints: " + maximum);
        System.out.println("Your integer is found this many times: " + intCount);

        if (!breakValid) {
            System.out.println("The value " + intBreak + " was found at array index: " + intFound);
        } else if (breakValid == true) {
            System.out.println("The value " + intBreak + " was NOT found in the array");
        }

    }
}
