
import java.util.InputMismatchException;
import java.util.Scanner;


public class task_01 {
    
    public static void main(String[] args) {
        double numb = getNumb();
        double res = mathMethod(numb);
        printArr(res);


    }
    //Ввод числа
    public static double getNumb() {
        Scanner get = new Scanner(System.in);
        System.out.println("Введите число: "); 
        try{
            double a = get.nextDouble();
            System.out.println();
            get.close();
            return a;
        } catch(InputMismatchException ex) {
            get.close();
            System.out.println("Вы не ввели число");
        }
        return 0;
    }
    public static double mathMethod(double numb) {
        double result = (numb * 1 / 2) * (numb + 1);
        return result; 
    }


    public static void printArr(double num) {
        System.out.printf("Триугольное число равняется %.0f", num);
        
    }
}
