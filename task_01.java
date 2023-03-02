
import java.util.InputMismatchException;
import java.util.Scanner;


public class Task_01 {
    
    public static void main(String[] args) {
        double numb = getNumb();
        double res = mathMethod(numb);
        printArr(res);


    }
    //Ввод числа
    public static double getNumb() {
        Scanner Get = new Scanner(System.in);
        System.out.println("Введите число: "); 
        try{
            double a = Get.nextDouble();
            System.out.println();
            Get.close();
            return a;
        } catch(InputMismatchException ex) {
            Get.close();
            System.out.println("Вы не ввели число");
        }
        return 0;
    }
    public static double mathMethod(double numb) {
        double result = (numb * 1 / 2) * (numb + 1);
        return result; 
    }


    public static void printArr(double num) {
        System.out.printf("Треугольное число равняется %.0f", num);
        
    }
}
