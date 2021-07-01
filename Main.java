/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20180696;

import java.util.*;

/**
 *
 * @author hp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void get_index(int arr[], int x) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println("Exist in index : " + i);
            }

        }

    }

    public static int firstt(int arr[], int l, int h, int key, int size) {

        while (h >= l) {
            int mid = (l + h) / 2;
            if ((mid == 0 || arr[mid - 1] < key) && arr[mid] == key) {
                return mid;

            } else if (key > arr[mid]) {
                return firstt(arr, (mid + 1), h, key, size);

            } else {
                return firstt(arr, l, (mid - 1), key, size);

            }
        }

        return -1;

    }

    public static int lastt(int arr[], int l, int h, int key, int size) {

        while (h >= l) {
            int mid = (l + h) / 2;
            if ((mid == size - 1 || arr[mid + 1] > key) && arr[mid] == key) {
                return mid;

            } else if (key < arr[mid]) {
                return lastt(arr, l, (mid - 1), key, size);

            } else {
                return lastt(arr, (mid + 1), h, key, size);

            }
        }

        return -1;

    }

    public static void first_solution(int arr[], int arr2[]) {

        Arrays.sort(arr);
        int size = arr.length;
        int first, last = 0;
        int count = -1;
        first = firstt(arr, 0, size - 1, arr[size / 2], size);

        if (first != -1) {

            last = lastt(arr, first, size - 1, arr[size / 2], size);
            count = last - first + 1;

        }
        if (count > (size / 2) ) {
            get_index(arr2, arr[size / 2]);

        } else {
            System.out.println("-1");

        }

    }

    public static int find_Dominator(int arr[]) {
        int size = arr.length;
        int index = 0;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (arr[index] == arr[i]) {
                counter++;

            } else {
                counter--;
            }
            if (counter == 0) {
                index = i;
                counter = 1;

            }

        }
        return arr[index];
    }

    public static int check_frequency(int num, int arr[]) {

        int count = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == num) {

                count++;
            }

        }
        if (count > (size / 2)) {
            return 1;

        } else {
            return -1;

        }
    }

    public static void Second_solution(int arr[]) {
        int dominator = find_Dominator(arr);
        int check = check_frequency(dominator, arr);
        if (check != -1) {
            get_index(arr, dominator);

        } else {
            System.out.println("-1");

        }

    }

    public static void main(String[] args) {

        int size;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size :");
        size = sc.nextInt();
        int[] arr = new int[size];
        int[] arr2 = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element number "+(i+1)+":");
            arr[i] = sc.nextInt();
            arr2[i] = arr[i];

        }
        //Divide and Conquer Algorithm
      first_solution(arr, arr2);
        //Boyer Moore's Algoritm
       //Second_solution(arr);
    }

}
