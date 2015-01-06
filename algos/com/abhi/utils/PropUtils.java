package com.abhi.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

/**
 * Author : abhishek
 * Created on 1/5/15.
 */
public abstract class PropUtils {

    private static final String propFile = "/home/abhishek/myPrograms/algos/algo.prop";
    private static Properties prop;

    private static void loadProperties(){
        try{
            prop = new Properties();
            prop.load(new FileReader(propFile));

        }catch (FileNotFoundException ex){
            System.err.println("File Not Found " + propFile);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key){
        if(prop == null){
            loadProperties();
        }
        return (String) prop.get(key);
    }

    public static void main(String[] args) {
        System.out.println(getProperty("graph_input"));
    }
}
