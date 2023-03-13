package lesson_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Task501 {

    public static void main(String[] args) {
        mapValves();
    }
    //Корневой метод
    private static void mapValves() {
        int[][] mapArr = new int[16][16];
        wallInMap(mapArr);
        String tape = Colorize(new Point2D(3, 3), mapArr);
        ArrayList<int[]> path = mapSearch(tape);
        System.out.println("Размеченная карта: ");
        initMap(mapArr);
        unPack(path, mapArr);
    }
    //Распечатка карты в int
    private static void initMap(int[][] array) {
        System.out.print("*    ");
        for (int i = 0; i < array.length; i++) {
            if(i < 9){
                System.out.print((i + 1) + "    ");
            } else {
                System.out.print((i + 1) + "   ");
            }        
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if(i < 9){
                System.out.print((i + 1) + "   ");
            } else {
                System.out.print((i + 1) + "  ");
            }
            
            for (int j = 0; j < array.length; j++) {
                if(array[i][j] > 99){
                    System.out.print(array[i][j] + " ");
                }
                if(array[i][j] > 9 || array[i][j] == -1 || array[i][j] == -2){
                    System.out.print(array[i][j] + "   ");
                } else {
                    System.out.print(array[i][j] + "    ");
                }
            }
            System.out.println();
        }
    }
    //Препятствия на карте
    private static void wallInMap(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[0][j] = -1;
                array[i][0] = -1;
                array[i][array.length - 1] = -1;
                array[array.length - 1][j] = -1;

            }
        }
        devideMap(array);
    }
    // Проходы в препятствиях на карте
    private static void devideMap(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(j  == 3 || j == 8 || j == 14){
                    array[5][j] = 0;
                } else {
                    array[5][j] = -1;
                }
                if(j == 2 || j == 7){
                    array[j][5] = 0;
                } else {
                    array[j][5] = -1; 
                }
                if(j == 7 || j == 2 || j == 14){
                    array[j][11] = 0;
                } else {
                    array[j][11] = -1;
                }
                if(j == 1 || j == 10 || j == 12){
                    array[10][j] = 0;
                } else {
                    array[10][j] = -1;
                }
                
            }
        }
    }
    //Волновая расскраска поля карты
    private static String Colorize(Point2D startPoint, int[][] array) {
        Queue<Point2D> queue = new LinkedList<Point2D>();
        StringBuilder recTape = new StringBuilder();
        queue.add(startPoint);
        array[startPoint.x][startPoint.y] = 1;
        array[13][14] = -2;
        while (queue.size() != 0) {
            Point2D p = queue.remove();
            if (array[p.x - 1][p.y] == 0) {
                queue.add(new Point2D(p.x - 1, p.y));
                array[p.x - 1][p.y] = array[p.x][p.y] + 1;
                recTape.append(p.x + ":" + p.y + ":" + (array[p.x][p.y]) + ","); 
            }
            if (array[p.x][p.y - 1] == 0) {
                queue.add(new Point2D(p.x, p.y - 1));
                array[p.x][p.y - 1] = array[p.x][p.y] + 1;
                recTape.append(p.x + ":" + p.y + ":" + (array[p.x][p.y]) + ",");   
            }
            if (array[p.x + 1][p.y] == 0) {
                queue.add(new Point2D(p.x + 1, p.y));
                array[p.x + 1][p.y] = array[p.x][p.y] + 1;
                recTape.append(p.x + ":" + p.y + ":" + (array[p.x][p.y]) + ",");
            }
            if (array[p.x][p.y + 1] == 0) {
                queue.add(new Point2D(p.x, p.y + 1));
                array[p.x][p.y + 1] = array[p.x][p.y] + 1;
                recTape.append(p.x + ":" + p.y + ":" + (array[p.x][p.y]) + ","); 
            }
        }
        return recTape.toString();
    }
    //Конвертация карты в строковый тип данных
    private static String[][] intToStringMap(int[][] array) {
        String[][] mapStr = new String[array.length][array.length];
        for (int i = 0; i < mapStr.length; i++) {
            for (int j = 0; j < mapStr.length; j++) {
                mapStr[i][j] = Integer.toString(array[i][j]);
            }
        }
        return mapStr;
    }
    //Распечатка карты в строковом типе данных
    private static void print(String[][] array, ArrayList<int[]> path) {
        for (int[] is : path) {
            array[is[0]][is[1]] = "*";
        }
        array[14][14] = "*";
        array[13][14] = "*";
        array[14][13] = "*";
        System.out.print("*    ");
        for (int i = 0; i < array.length; i++) {
            if(i < 9){
                System.out.print((i + 1) + "    ");
            } else {
                System.out.print((i + 1) + "   ");
            }
                    
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if(i < 9){
                System.out.print((i + 1) + "   ");
            } else {
                System.out.print((i + 1) + "  ");
            }
            
            for (int j = 0; j < array.length; j++) {
                if(array[i][j].length() > 2){
                    System.out.print(array[i][j] + " ");
                }
                if(array[i][j].length() > 1 || array[i][j] == "-1" || array[i][j] == "-2"){
                    System.out.print(array[i][j] + "   ");
                } else {
                    System.out.print(array[i][j] + "    ");
                }
            }
            System.out.println();
        }   
       
    }
    // Поиск маршрута
    private static ArrayList<int[]>mapSearch(String data) {
        System.out.println();
        String[] temp = data.split(",");
        String[][] doubleTemp = new String[temp.length][0];
        int[][] intTemp = new int[temp.length][3];
        ArrayList<int[]> path = new ArrayList<int[]>();
        for (int i = 0; i < temp.length; i++) {
             doubleTemp[i] = temp[i].split(":");
        }
         for (int i = 0; i < doubleTemp.length; i++) {
             for (int j = 0; j < doubleTemp[i].length; j++) {
                 intTemp[i][j] = Integer.parseInt(doubleTemp[i][j]);
             }
             System.out.println();
         }
         int testA = 0;
         int testB = 14;
         int testC = 22;
         for (int i = 0; i < intTemp.length; i++) {
                if(i == 0){
                    continue;
                } else if(intTemp[intTemp.length - 1 - i][2] < testC && intTemp[intTemp.length - 1 - i][1] <= testB){
                    testA = intTemp[intTemp.length - 1 - i][0];
                    testB = intTemp[intTemp.length - 1 - i][1];
                    testC = intTemp[intTemp.length - 1 - i][2];
                    path.add(intTemp[intTemp.length - 1 - i]);
                
                } 
            }
        System.out.println();
        return path;
    }
    private static void unPack(ArrayList<int[]> path, int[][] array) {
        String[][] strMap = intToStringMap(array);
        System.out.println("Карта с маршрутом: ");
        print(strMap, path);
        System.out.println();
        
    }
}

class Point2D {
    int x;
    int y;
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}


