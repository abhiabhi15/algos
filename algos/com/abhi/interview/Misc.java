package com.abhi.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

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

    public static int heightUtopian(int N){
        int initial = 1;
        int total = initial;
        for(int i =1; i <=N; i++){
            if( i % 2 == 1){
                total = 2 * total;
            }else{
                total += 1;
            }
        }
        return total;
    }

    public static int findIndex(String[] arr, int size, int number){

        int lo = 0;
        int hi = size -1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(Integer.parseInt(arr[mid]) == number){
                return mid;
            }else if(Integer.parseInt(arr[mid]) > number){
                hi = mid -1;
            }else{
                lo = mid +1;
            }
        }
        return -1;
    }

    public static int getConversions(String input){

        int count = 0;
        int n = input.length();
        if(n <= 1){
            return 0;
        }
        for(int i=0,j=n-1; i< n/2; i++,j--){
            char front = input.charAt(i);
            char rear = input.charAt(j);
            if(front != rear){
                while(rear != front){
                    if(rear > front && rear != 'a'){
                        rear--;
                        count++;
                    }else if(front > rear && front != 'a'){
                        front--;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void insertIntoSorted(int[] ar) {

        int num = ar[ar.length-1];
        for(int i = ar.length-1; i > 0; i--){
            if( num < ar[i-1] ){
                ar[i] = ar[i-1];
                printArray(ar);
            }else{
                ar[i] = num;
                printArray(ar);
                break;
            }
        }
        if(num < ar[0]){
            ar[0] = num;
            printArray(ar);
        }
    }

    public static void insertionSortPart2(int[] ar)
    {
        for(int i = 1; i < ar.length; i++){

            for(int j = i; j > 0; j--){
                if( ar[j] < ar[j-1] ){
                    int temp = ar[j];
                    ar[j] = ar[j-1];
                    ar[j-1] = temp;
                    printArray(ar);

                }else{
                        printArray(ar);
                    break;
                }
            }
        }
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }


    public static void main(String[] args) throws Exception{

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
