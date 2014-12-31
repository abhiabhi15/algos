package com.abhi.interview;


import java.io.*;
import java.util.*;
import java.util.LinkedList;


/**
 * Created by abhishek
 * Unity Id : akagrawa
 * Created on 12/23/14.
 */
public class Misc {

    public static void table(int n){

        for(int i=1; i <= n; i++){
            for(int j=1; j <= n;  j++){
                System.out.print( String.format("%4d", j * i ));
            }
            System.out.println();
        }
    }


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

    public static int divisibleDigit(String input){

        Long num = Long.parseLong(input);
        Long orgNum = num;
        int count =0;
        while( num >= 1){
            long divisor = num % 10;
            if( divisor > 0 && (orgNum % divisor) == 0){
                count++;
            }
            num = num/10;
        }
        return count;
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

    public static String checkPalindrome(String str){

        int[] arr = new int[256];
        for(int i=0; i <= str.length()-1; i++){
            System.out.println((int)str.charAt(i));
            arr[(int)str.charAt(i)]++;
        }
        boolean allowed = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 1){
                if(allowed){
                    allowed = false;
                }else{
                    return "NO";
                }
            }
        }
        return "YES";

    }

    public static String checkSum(String[] arr, int size, int sum){

        if(size <= 1) { return null;}
        Map<Integer, Integer> indexMap = new HashMap() ;
        for(int i = 0; i<size; i++){
            if(indexMap.containsKey(sum - Integer.parseInt(arr[i]))){
                return indexMap.get(sum - Integer.parseInt(arr[i])) +  "  " + (i+1);
            }else{
                indexMap.put((Integer.parseInt(arr[i])), i+1);
            }
        }
        return null;
    }

    public static void matchTopic(int people, int topics, String[] ar){

        List<Integer[]> bitSets = new LinkedList<>();
        for(int i =0; i < people; i++){
            Integer[] bitSet = new Integer[topics];
            for(int j=0; j < topics; j++  ){
                bitSet[j] =  Character.getNumericValue(ar[i].charAt(j));
            }

            bitSets.add(bitSet);
        }

        int max = 0;
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i =0;i<people; i++){
            Integer[] temp = bitSets.get(i);
            for(int j=i+1; j < people; j++){
                int count = checkCounter(temp, bitSets.get(j));
                if(count > max){
                    max = count;
                    indexMap.put(max, 1);
                }else if(count == max){
                    indexMap.put(max, indexMap.get(max)+1);
                }
            }
        }
        System.out.println(max+"\n" +indexMap.get(max));
    }

    private static int checkCounter(Integer[] temp, Integer[] integers) {
        int counter = 0;
        for(int i=0; i< temp.length; i++){
            if(!(temp[i] == 0 && integers[i] == 0)){
                counter++;
            }
        }
        return counter;
    }

    public static void sampleRead(){
        try{
            BufferedReader in = new BufferedReader(new FileReader("/home/abhishek/abc.txt"));
            String[] line = in.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            long candies = 0l;
            while(M > 0) {
                candies += getAvgOps(in.readLine()) ;
                System.out.println(candies);
                M--;
            }

            System.out.println((long)Math.floor(candies/N));
            in.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static long getPerfectSquares(String str){

        String[] line = str.split(" ");
        long start = Long.parseLong(line[0]);
        long end = Long.parseLong(line[1]);
        int count = 0;

        long num = (long)Math.floor(Math.sqrt(start));
        long sqr = num * num;
        while(sqr <= end){
            count++;
            num++;
            sqr = num * num;
        }
        return count;
    }

    public static int maxChocolates(int K){
        if(K <= 1) return 0;
        float half = (float)K/2;
        if(half % 1 == 0){
            return (int) (half * half);
        }else{
            return (int)(Math.floor(half) * Math.ceil(half));
        }
    }

    public static long getAvgOps(String line){

        String[] indices = line.split(" ");
        int index1 = Integer.parseInt(indices[0]);
        int index2 = Integer.parseInt(indices[1]);
        long fills = index2 - index1 +1;
        return fills * Integer.parseInt(indices[2]);
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static String checkPrime(String[] arr, long N){

        for(int i =0; i< N; i++){
            long num = Long.parseLong(arr[i]);
            if(num == 1l){
                return "YES";
            }
            for(int j= i+1; j < N; j++){
                if(gcd(num, Long.parseLong(arr[j])) == 1){
                    return "YES";
                }
            }
        }
        return "NO";

    }

    public static void printNum(int x, int y) throws Exception{
        OutputStream out = new BufferedOutputStream( System.out );

        while(x > 0){
            out.write((5 + "").getBytes());
            x--;
        }
        while(y > 0){
            out.write((3+"").getBytes());
            y--;
        }

        out.flush();
    }

    public static void minDifference(String[] arr, int size){
        int[] nums = new int[size];
        for(int i=0; i<size; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>> numMap = new HashMap();
        for(int i =0; i < size-1; i++ ){
            int diff = nums[i+1]-nums[i];
            if(diff <= min){
                min = diff;
                if(numMap.containsKey(min)){
                    List<String> oldList = numMap.get(min);
                    oldList.add(nums[i] + " " + nums[i+1] + " ");
                    numMap.put(min, oldList);
                }else{
                    List<String> list = new ArrayList<>();
                    list.add(nums[i] + " " + nums[i+1] + " ");
                    numMap.put(min, list);
                }
            }
        }

        for(String str : numMap.get(min)){
            System.out.print(str);
            int[] a = new int[2];
            a[0] =4;
             Arrays.sort(a);
        }
    }

    static long getSum(int[]a, int pos1, int pos2){
        long total = 0l;
        for(int i=pos1; i<= pos2; i++){
            total+= a[i];
        }
        return total;
    }

    public static long getCost(int[] C, int N, int K){
        long fcost = 0l;
        int div = N/K;
        int shift = 0;
        for(int i = 0; i < div; i++){
            fcost += (i+1)* getSum(C, shift, (shift+K-1));
            shift += K;
        }
        if( N % K != 0){
            fcost += (div+1)*getSum(C, N-(N%K) ,N-1);
        }
        return fcost;
    }

    public static void reverse(int[] a){

        int front = 0;
        int rear = a.length-1;
        while(rear > front){
            int temp = a[rear];
            a[rear--] = a[front];
            a[front++] = temp;
        }
    }



    public static void main(String[] args) throws Exception{

        int[] C = new int[4];
        C[0]=7;
        C[1] =1;
        C[2] =10;
        C[3] =3;
        Arrays.sort(C);
        reverse(C);
        System.out.println(Arrays.toString(C));
        System.out.println(getCost(C, 4, 2));
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
