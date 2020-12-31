package com.peng.sort;

/**
 * @Author sp
 * @Description
 * @create
 * @Modified By:
 */
public class BubbleSort {

  public static void main(String[] args) {
    int [] arr= {3,9,-1,10,-2};
    int temp = 0;
    boolean flag = false;
    for (int i = 0;i<arr.length-1;i++){ ;
      for (int j = 0;j<arr.length-1-i;j++){
        if (arr[j] > arr[j+1]) {
          temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          flag = true;
        }
        if (flag){
          break;
        }else {
          flag = false;
        }
        }
      }
    }

   }


