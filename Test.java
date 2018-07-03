import java.util.ArrayList;
public class Test {
    public void PrintMatrixClockwisely(int[][] matrix){
        int columns = matrix[0].length;
        int rows = matrix.length;

        if(matrix == null || columns <= 0 || rows <= 0){
            return;
        }

        int start = 0;
        while(columns > start * 2 && rows > start * 2 ){
            PrintMatrixCircle(matrix,columns,rows,start);
            start++;
        }
    }



    public void  PrintMatrixCircle(int[][] matrix, int columns, int rows, int start){


        int endX = columns - 1 - start;
        int endY = rows - 1 -start;

        //从左到右打印一行
        for(int i = start; i <= endX; i++){
            int number = matrix[start][i];
           System.out.print(number + " ");
        }

        //从上到下打印一列
        if(start < endY){
            for(int i = start + 1; i <= endY; i++){
                int number = matrix[i][endX];
                System.out.print(number + " ");
            }
        }

        //从右向左打印一行
        if(endX > start ){
            for(int i = endX - 1; i >= start; i--){
                int number = matrix[endY][i];
                System.out.print(number + " ");
            }
        }

        //从下向上打印一列
        if(start < endX && start < endY - 1){
            for(int i = endY -1; i > start; i--){
                int number = matrix[i][start];
                System.out.print(number + " ");
            }
        }
    }


    public  static  void main(String[] args){
        int[][] matrix = new int[1][1];
        int m = 1;
        matrix[0][0] = 1;
//        for(int i = 0;i < 4;i++){
//            for(int j = 0;j < 4;j++){
//                matrix[i][j] = m++;
//            }


        Test a = new Test();
        a.PrintMatrixClockwisely(matrix);
    }
}


