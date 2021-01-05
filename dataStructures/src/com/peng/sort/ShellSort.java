package com.peng.sort;

/**
 * @Author sp
 * @Description
 * @create 2020
 */
public class ShellSort {

  public static void main(String[] args) {
    int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
    shellSort(arr);
  }

  public static void shellSort(int[] arr) {
    int n = 0;
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      System.out.println(++n);
      //从第gap个元素，逐个对其所在的组进行直接
      for (int i = gap; i < arr.length; i++) {
        int j = i;
        int temp = arr[j];
        if (arr[j] < arr[j - gap]) {
          while (j - gap >= 0 && temp < arr[j - gap]) {
            //移动
            arr[j] = arr[j - gap];
            j -= gap;

          }
          //当退出while后，就给temp找到插入的位置
          arr[j] = temp;
        }
      }
    }
  }

}
