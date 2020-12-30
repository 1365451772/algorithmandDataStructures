package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Author sp
 * @Description
 * @create
 * @Modified By:
 */
public class SelectSort {

  public static void main(String[] args) {
    int[] arry = {3, 5, 9, 6, 0};
    for (int i=0;i<arry.length-1;i++) {
    int minIndex = i;
    int min = arry[minIndex];
    for (int j = i+1; j < arry.length ; j++) {
      if (arry[j] < min) {
        min = arry[j];
        minIndex = j;
      }
      if (minIndex !=i){
        arry[minIndex] = arry[i];
        arry[i] = min;
      }

    }
  }

    System.out.println(Arrays.toString(arry));
  }

}
