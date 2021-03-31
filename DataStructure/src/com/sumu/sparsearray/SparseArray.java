package com.sumu.sparsearray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        /**
         * 创建一个原始的二维数组 11*11
         * 0表示无棋子，1表示黑色棋子，2表示蓝色棋子
         */
        int chessArr1[][] = new int[11][11];
        // 给原始二维数组赋值
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始二维数组
        System.out.println("原始二维数组：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * 将 二维数组 转为 稀疏数组
         */
        // 1、先遍历二维数组，得到非0数据个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 初始化第一行数据
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 遍历原始二维数组，将非0数据存放到sparseArr中
        int count = 0; // count用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组
        System.out.println("转换后的稀疏数组如下：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        /**
         * 利用IO流将稀疏数组存储到磁盘中（sparsearray.data文件）
         */
        FileWriter writer = null;
        try {
            writer = new FileWriter("D:\\Data\\sparsearray.data");
            for (int[] row : sparseArr) {
                writer.write(row[0] + "\t" + row[1] + "\t" + row[2] + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 利用IO流从磁盘中读取sparsearray.data文件，并将读取到的数据转为稀疏数组
         */
        int[][] sparseArr2 = null;
        boolean flag = false;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("D:\\Data\\sparsearray.data")));
            String lineStr = null;
            int reaCount = 0;
            while ((lineStr = bufferedReader.readLine()) != null) {
                String[] tempStr = lineStr.split("\t");
                if (!flag) {
                    sparseArr2 = new int[Integer.parseInt(tempStr[2]) + 1][3];
                    sparseArr2[reaCount][0] = Integer.parseInt(tempStr[0]);
                    sparseArr2[reaCount][1] = Integer.parseInt(tempStr[1]);
                    sparseArr2[reaCount][2] = Integer.parseInt(tempStr[2]);
                    reaCount++;
                    flag = true;
                } else {
                    sparseArr2[reaCount][0] = Integer.parseInt(tempStr[0]);
                    sparseArr2[reaCount][1] = Integer.parseInt(tempStr[1]);
                    sparseArr2[reaCount][2] = Integer.parseInt(tempStr[2]);
                    reaCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 输出稀疏数组
        System.out.println("从文件中读取的稀疏数组：");
        for (int[] row : sparseArr2) {
            System.out.printf("%d\t%d\t%d\t\n", row[0], row[1], row[2]);
        }

        /**
         * 将 稀疏数组 恢复为 原始二维数组
         */
        // 1、先读取稀疏数组第一行的数据，根据第一行的数据创建原始的二维数组，例如 int chessArr2[][] = new int[11][11]
        int chessArr2[][] = new int[sparseArr2[0][0]][sparseArr[0][1]];
        // 2、再读取稀疏数组后几行的数据（行、列、值），并赋值给刚创建的二维数组(chessArr2)即可
        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][0];
        }
        // 输出恢复后的二维数组
        System.out.println("恢复后的二维数组为：");
        for (int[] row: chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
