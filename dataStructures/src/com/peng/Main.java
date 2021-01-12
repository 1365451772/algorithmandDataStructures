package com.peng;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author sp
 * @Description
 * @create 2021-01-12 13:55
 * @Modified By:
 */
public class Main {


  public static void main(String[] args) throws IOException {
    Runtime runtime = Runtime.getRuntime();
    String cmd = "java -jar plantuml.jar 1.puml";
    String cmd1 = "cmd /c dir";
    Process exec = runtime.exec(cmd1,null,new File("dataStructures"));
    InputStream inputStream = exec.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
    String line = null;
    while ((line = reader.readLine()) != null) {
      //LogUtils.debug(line);
      System.out.println(line);
    }

  }

}
