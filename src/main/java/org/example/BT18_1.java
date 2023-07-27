package org.example;
import java.util.Scanner;

public class BT18_1 {

        // scanner input
        public static Scanner scanner = new Scanner(System.in);
        // main
        public static void main(String[] args) {
            // save value input
            System.out.print("Enter the number of elements in the A array: ");
            int n = scanner.nextInt();
            // Create array
            int[] inputA = new int[n];
            System.out.print("Enter the elements of the A array: \n");
            for (int i = 0; i < n; i++) {
                System.out.printf("a[%d] = ", i);
                inputA[i] = scanner.nextInt();
            }
            System.out.print("The elements of the A array: ");
            showArray(inputA);
            int[] outputB = plusArrayNumb(inputA);
            System.out.print("The elements of the B array: ");
            showArray(outputB);
        }

        // show value of Array
        public static void showArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(" \n");
        }

        // B = A + 1
        public static int[] plusArrayNumb(int[] arr) {
            String input = "";

            // check if have 0 in array
//            String zeroNumb = (arr[0] == 0) ? "0" : "";

            for (int i = 0; i < arr.length; i++) {
                input += arr[i];
            }

            String result =  String.valueOf(Integer.parseInt(input) + 1);

            // add value for output
            int[] output =  new int[result.length()];
            for (int i = 0; i < result.length(); i++) {
                output[i] = Character.getNumericValue(result.charAt(i));
            }
            return output;
        }
    }
