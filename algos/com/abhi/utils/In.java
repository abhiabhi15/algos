package com.abhi.utils;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Author : abhishek
 * Created on 1/5/15.
 */
public class In {

    InputStream in;

    public In(String file){
        try {
            String filePath = Utils.getFilePath(file);
            in = new FileInputStream(filePath);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public int nextInt(){
        int input = 0;
        try {
            input = in.read();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return input;
    }

}
