package lesson3;

import java.util.Arrays;

public class MatrixUtils {

    //phuong thuc in ma tran
    public static String printMatrix(int[][] matrix){
        StringBuilder result = new StringBuilder();
        for(var i = 0; i<matrix.length;i++){
            result.append("[");
            for (var j = 0; j<matrix[i].length; j++){
                result.append(String.format("%4d", matrix[i][j]));
            }
            result.append("] \n");
        }
        return result.toString();
    }
    public static int[][] addition2Matrix(int[][] matrix1, int[][] matrix2){
        if(matrix1.length  != matrix2.length || matrix1[0].length != matrix2[0].length){
            throw new RuntimeException("Ma tran khong hop le!");
        }
        int[][] resutl = new int[matrix1.length][matrix1[0].length];
        for(var i = 0; i<matrix1.length; i++){
            for(var j = 0; j<matrix1[i].length; j++){
                resutl[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resutl;
    }
    //phuong thuc nhan ma tran voi 1 so
    public static void mutipliConstant(int[][] matrix, int constNumber){
        for(var i = 0; i<matrix.length; i++){
            for(var j = 0; j<matrix[i].length; j++){
                matrix[i][j] *= constNumber;
            }
        }
    }
    //phuong thuc nhan 2 ma tran
    public static int[][] mutiply2Matrix(int[][] matrix1, int[][] matrix2){
        /*
        matrix1[m,p] va matrix2[p,n]
        => resultMatrix[m,n]
         */
        int m = matrix1.length;
        int n = matrix2[0].length;
        int soPhepNhanPhaiThucHien = matrix2.length;
        if(m != n){
            throw new RuntimeException("Ma tran khong hop le!");
        }
        int[][] result = new int[m][n];

        for(var i = 0; i<m ; i++){
            for(var j = 0; j<n ;j++){
                //tinh toan result[i][j]
                for(int k = 0; k<soPhepNhanPhaiThucHien;k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return
                result;
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,5,4,3}
                ,{3,2,6,5}
                ,{3,2,6,2}
                , {2,4,2,3}};
        int[][] matrix2 = {{4,3,4,3}
                ,{3,5,6,2}
                ,{3,6,3,6}
                , {2,4,2,4}};
        System.out.println("Matrix1:");
        System.out.println(printMatrix(matrix1));
        System.out.println("Matrix2:");
        System.out.println(printMatrix(matrix2));
        //test method addtionMatirix
        System.out.println("Matrix1+Matrix2: ");
        System.out.println(printMatrix(addition2Matrix(matrix1, matrix2)));

        //Test method nhan ma tran voi 1 so
        System.out.println("Matrix1*2: ");
        mutipliConstant(matrix1, 2);
        System.out.println(printMatrix(matrix1));

        //Test method nhan ma tran voi 1 so
        System.out.println("Matrix1*Matrix2: ");
        System.out.println(printMatrix(mutiply2Matrix(matrix1, matrix2)));
    }

}
