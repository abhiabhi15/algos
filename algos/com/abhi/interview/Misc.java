package com.abhi.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by abhishek
 * Created on 12/23/14.
 */
public class Misc {

    // Write a multiply table in human readable format
    public static void table(int n){

        for(int i=1; i <= n; i++){
            for(int j=1; j <= n;  j++){
                System.out.print( String.format("%4d", j * i ));
            }
            System.out.println();
        }
    }

    // Find the sum of numbers in a file
    public static void fileSum(String name){

        int total =0;
        try{
            BufferedReader in = new BufferedReader(new FileReader(name));
            for( String s = in.readLine(); s != null; s = in.readLine()){
                total += Integer.parseInt(s);
            }
            System.out.println("Total Count " + total);
            in.close();

        }catch (FileNotFoundException ex){
            System.err.println("File Not Found = " + name );
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Read input from Console
    public static void readInputFromStdIn(){

        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while((input = in.readLine()) != null){
                System.out.println(input);
            }
            in.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static long fib(long n){
        if(n <= 1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static boolean isPerfectSquare(double n){
        double x = Math.sqrt(n);
        return ( x % 1 == 0);
    }

    public static String isFibo(Long n){

        if(n < 0) {
            return "IsNotFibo";
        }
        if(n == 0) {
            return "IsFibo";
        }
        if( isPerfectSquare((5*Math.pow(n,2)) + 4)  || isPerfectSquare((5*Math.pow(n,2))- 4) ){
            return "IsFibo";
        }else{
            return "IsNotFibo";
        }
    }

    public static String getBaseConvertNumber(int number, int base){
        String output = "";
        String flag = "";
        if(number < 0){
            flag = "-";
            number = Math.abs(number);
        }
        while(number > 0){
            output += (number % base);
            number = number/base;
        }
        output+=flag;
        return new StringBuilder(output).reverse().toString();
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // a0 <= a1 >= a2 <= a3
    public static void alternateSeq(int[] arr){
        for(int i =0; i < arr.length-1; i++){
            if(i % 2 == 0){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }else {
                if(arr[i] < arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }

    // Given an array of integers, find the count of triplets whose sum is less than or equal to given target Value
    public static int tripleCount(int[] arr, int target){

        if(arr.length < 3) return 0;
        Arrays.sort(arr);
        int i = arr.length-1;
        while(i >= 0 && arr[i] > target){
            i--;
        }
        if(i < 2) return 0;

        for(; i >=2; i--){
            int sum = arr[i] + arr[i-1] + arr[i-2];
            if(sum <=  target){
                break;
            }
        }
        i++;
        return (i * (i-1) * (i-2))/6;
    }

    public static void main(String[] args) throws Exception{

        int[] a = {1,2,3,4,5,6,7};
        alternateSeq(a);
        System.out.println(tripleCount(a, 7));

       // System.out.println(getBaseConvertNumber(-17, 2));

    /*    BufferedReader in = new BufferedReader(new FileReader("/home/abhishek/abc.txt"));
        int testCases = Integer.parseInt(in.readLine());
        while(testCases > 0){
            long N = Long.parseLong(in.readLine());
            String[] ar = in.readLine().split(" ");
            System.out.println(checkPrime(ar,N));
            testCases--;
        }
        in.close() ; */
    }
}
