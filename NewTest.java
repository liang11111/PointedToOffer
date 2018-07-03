import java.util.ArrayList;

public class NewTest {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cloums = matrix[0].length;
        if( matrix == null || rows <= 0 || cloums <= 0 ){
            return list;
        }
        int start = 0;
        while(cloums > 2 * start && rows > 2* start){
            list = PrintMatrix(matrix,rows,cloums,start);
            start++;
        }
        return list;
    }

    ArrayList<Integer> list1 = new ArrayList<>();
    public ArrayList<Integer> PrintMatrix(int[][] matrix,int rows,int cloums,int start){

        int endX = cloums - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for(int i = 0; i <= endX;i++){
            int number = matrix[start][i];
            list1.add(number);
        }

        //从上向下打印一列
        if(endY > start){
            for(int i = start + 1; i <= endY; i++){
                int number = matrix[i][endX];
                list1.add(number);
            }
        }

        //从右向左打印一行
        if(endX > start && endY > start){
            for(int i = endX -1 ;i >= start; i--){
                int number = matrix[endY][i];
                list1.add(number);
            }
        }

        //从下向上打印一列
        if(endY > start + 1 && endX > start){
            for(int i = endY - 1; i > start; i--){
                int number = matrix[i][start];
                list1.add(number);
            }
        }
        return list1;
    }

    public  static  void main(String[] args) {
        int[][] matrix = new int[4][4];
        int m = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = m++;
            }
        }


            NewTest a = new NewTest();
            ArrayList<Integer> list1 = new ArrayList<>();
            list1 = a.printMatrix(matrix);
            System.out.print(list1);
    }
}
