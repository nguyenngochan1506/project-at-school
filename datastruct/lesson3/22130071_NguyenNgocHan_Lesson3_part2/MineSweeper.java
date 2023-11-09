package lesson3;

import java.util.Arrays;
import java.util.Random;

public class MineSweeper {
    private int rows, cols, numberOfBoom;
    private int[][] maTrix;
    public MineSweeper(int rows, int cols, int numberOfBoom){
        this.rows = rows;
        this.cols = cols;
        this.numberOfBoom = numberOfBoom;
        this.maTrix = new int[rows][cols];
        this.createBoom();
    }
    //tạo ra những quả boom
    private void createBoom() {
        int temp = 0;
        while (temp<numberOfBoom){
            setUpBoom();
            temp++;
        }
        //gọi hàm đếm boom sau khi tạo boom
        addNumber();
    }

    //tạo 1 quả boom với toạ độ raddom
    private void setUpBoom() {
        int x = new Random().nextInt(rows);
        int y = new Random().nextInt(cols);
        if(this.maTrix[x][y] != -1){
            this.maTrix[x][y] = -1;
            return;
        }else {
            setUpBoom();
        }
    }

    //duyệt qua tất cả các ô của trò chơi và gán số lượng boom xung quanh bán kính 1 ô
private void addNumber(){
        for(var i = 0; i<maTrix.length; i++){
            for (var j = 0;j<maTrix[i].length; j++){
                if(maTrix[i][j] == -1){
                    continue;
                }else{
                    maTrix[i][j] = countBoom(i, j);
                }
            }
        }
}

    //đếm số quả boom trong bán kính 1 ô quanh mình
    private int countBoom(int x, int y){
        int result = 0;
        //duyệt hàng
        for(var i = x-1; i<= x+1; i++){
            //duyệt cột
            for(var j = y-1; j<= y+1; j++){
                //kiểm tra trường hợp toạ độ nằm ngoài kích thước của matrix
                if(i>=0 && j>=0 && i<this.maTrix.length && j<maTrix[i].length){
                    if(this.maTrix[i][j] == -1){
                        result++;
                    }
                }
            }
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(var i = 0; i<this.maTrix.length; i++){
            result.append("[");
            for(var j = 0; j<this.maTrix[i].length; j++){
                result.append(String.format("%3d", this.maTrix[i][j]));
            }
            result.append("] \n");
        }
        return  result.toString();
    }

    public static void main(String[] args) {
        MineSweeper game = new MineSweeper(9,9, 50);
        System.out.println(game.toString());
    }
}
