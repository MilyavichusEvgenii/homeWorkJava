package lesson_4;

import java.util.Arrays;
import java.util.Random;

public class Task401 {
    public static void main(String[] args) {
        int[] arr = initArr();
        heapSort(arr);
        System.out.println("Массив после перебора: ");
        print(arr);
    }
    //Инициализация массива
    private static int[] initArr() {
        Random rnd = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1, 11);
        }
        System.out.println("Массив до перебора:");
        print(arr);
        return arr;
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        
        int length = array.length;
        
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        
        for (int i = length - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array, length, largest);
        }
    }
     //печать
     private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
