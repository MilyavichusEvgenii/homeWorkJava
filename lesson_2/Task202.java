package lesson_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

class Task202 {
    public static void main(String[] args) {
        int[] arr = initArr();
        int[] resArr = selectArr(arr);
        System.out.println("Массив после перебора: ");
        print(resArr);
    }
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
    private static int[] selectArr(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    logger(array);
                }
            }
        }
        return array;
    }
    private static void logger(int[] arr) {
        String battary = "";
        for (int i = 0; i < arr.length; i++) {
            if(i == 0){
                battary = "log: " + battary + arr[i];
            } else {
                battary = battary + ", " + arr[i];
            }
            
        }
        try(FileWriter file = new FileWriter("file202.txt", true)){
            file.append(battary + "\n");
            file.flush();
            file.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        

    }
    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
}