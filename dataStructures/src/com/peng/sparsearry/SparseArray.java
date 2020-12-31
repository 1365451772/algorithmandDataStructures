package com.peng.sparsearry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Author sp
 * @Description
 * @create 2020-12-10 22:28
 * @Modified By:
 */

public class SparseArray {

  public static void main(String[] args) throws IOException {

    int chasseArry1[][] = new int[11][11];
    chasseArry1[1][2] = 1;
    chasseArry1[2][3] = 2;

    //输出原始的二维数组
    System.out.println("原始的二维数组");
    for (int[] row : chasseArry1) {
      for (int data : row) {
        System.out.printf("%d\t", data);
      }
      System.out.println();
    }

    int sum = 0;
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        if (chasseArry1[i][j] != 0) {
          sum++;
        }
      }
    }

    int sparseArr[][] = new int[sum + 1][3];
    sparseArr[0][0] = 11;
    sparseArr[0][1] = 11;
    sparseArr[0][2] = sum;

    int count = 0;//count 用于记录是第几个非0数据
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        if (chasseArry1[i][j] != 0) {
          count++;
          sparseArr[count][0] = i;
          sparseArr[count][1] = j;
          sparseArr[count][2] = chasseArry1[i][j];
        }
      }
    }
    //输出稀疏数组的形式
    System.out.println();
    System.out.println("得到稀疏数组为~~~~");
    for (int i = 0; i < sparseArr.length; i++) {
      System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
    }
    //稀疏数组转为二维数组
    int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
    //恢复数据
    for (int i = 1; i < sparseArr.length; i++) {
      chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
    }

    for (int[] row : chessArr2) {
      for (int data : row) {
        System.out.printf("%d\t", data);
      }
      System.out.println();
    }
    BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("map.data"), "utf-8"
        ));
    for (int i = 0; i < sparseArr.length; i++) {
      writer.write(String.valueOf(sparseArr[i][0]));
      writer.write("\t");
      writer.write(String.valueOf(sparseArr[i][1]));
      writer.write("\t");
      writer.write(String.valueOf(sparseArr[i][2]));
      writer.newLine();
    }
    writer.close();

    BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream("test.txt")));
    String a = null;
    while ((a = reader.readLine()) != null) {
      System.out.println(a);
      System.out.println(a.length());
      if (a.contains("\\\\x00")) {
        System.out.println(a);
        break;
      }
    }

  }
}
