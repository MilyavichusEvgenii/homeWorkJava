package lesson_5;

public class Task501 {

    public static void main(String[] args) {
        mapValves();
    }
    private static void mapValves() {
        int[][] mapArr = new int[16][16];
        wallInMap(mapArr);
        initMap(mapArr);
    }
    private static void initMap(int[][] array) {
        System.out.print("*    ");
        for (int i = 0; i < array.length; i++) {
            if(i < 9){
                System.out.print((i + 1) + "   ");
            } else {
                System.out.print((i + 1) + "  ");
            }
                    
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if(i < 9){
                System.out.print((i + 1) + "    ");
            } else {
                System.out.print((i + 1) + "   ");
            }
            
            for (int j = 0; j < array.length; j++) {
                if(array[i][j] > 9 || array[i][j] == -1 || array[i][j] == -2){
                    System.out.print(array[i][j] + "  ");
                } else {
                    System.out.print(array[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
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
    
}
 
