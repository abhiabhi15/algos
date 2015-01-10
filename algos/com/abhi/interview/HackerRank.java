package com.abhi.interview;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by abhishek
 * Created on 12/27/14.
 */
public class HackerRank {

    static void swap(int[] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
        swaps++;
    }

    public static int partition(int[] ar, int lo, int hi){

        int i = lo-1;
        int j;
        while(true){

            while(ar[++i] < ar[hi]){
                swaps++;
                if( i == hi) break;
            }
            j = i;
            if(i == hi) break;

            while(ar[++i] > ar[hi]){
                if(i == hi) break;
            }
            if(i == hi ) break;
            swap(ar, i, j);
            i = j;
        }
        swap(ar, j, hi);
        printArray(ar);
        return j;
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


    static int swaps =0;
    public static void sort(int[] ar, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(ar,lo,hi);
        sort(ar, lo, j-1);
        sort(ar, j+1, hi);
    }

    public static void quickSort(int[] ar){
        sort(ar, 0, ar.length-1);
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


    static void checkSum(long[] A, long[] B, long K, int N){
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        System.out.println(K);

        for(int i=0;i<N;i++){
            long sum = A[i] + B[i];
            if(K < sum){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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



    static void reverse(long[] arr, int len){
        for(int i =0; i < len/2 ; i++){
            long c = arr[i];
            arr[i] = arr[len-1-i];
            arr[len-1-i] = c;
        }
    }

    public static void busStation(String[] str, int n){
        long[] sum = new long[n];
        long cumsum = 0l;
        for(int i =0; i<n;i++){
            int num = Integer.parseInt(str[i]);
            cumsum += num;
            sum[i] = cumsum;
        }

        StringBuilder sb = new StringBuilder();
        long last = sum[n-1];
        for(int i=0; i< n;i++){
            long x = sum[i];
            if(x > last/2){
                break;
            }
            if(checkMultipleExsist(x, sum, last)){
                sb.append(x + " ");
            }
        }
        sb.append(last + " ");
        System.out.println(sb.toString());
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


    private static boolean checkMultipleExsist(long x, long[] sum, long last) {

        int j = 2;
        long multiple = j * x;
        while(multiple != last){
            if(!bsearch(sum,multiple)){
                return false;
            }else{
                multiple = j++ * x;
            }
        }
        return true;
    }

    static boolean bsearch(long[ ] A, long num){

        int lo =0;
        int hi = A.length-1;
        while(lo <= hi){
            int mid = lo + ( hi - lo )/2;
            if( A[mid] == num){
                return true;
            }else if( A[mid] > num){
                hi = mid -1;
            }else{
                lo = mid +1;
            }
        }
        return false;
    }

    public static String checkFeasible(long r, long k){

        long radius = Math.round(Math.sqrt(r));
        Map<Long, Boolean> presence = new HashMap<>();
        long count = 0l;
        for(long i =0; i <= radius; i++){
            if(presence.containsKey(i)){
                i++;
            }else{
                Double y = Math.sqrt(r - (i * i));
                if(y % 1 == 0){
                    presence.put(i, true);
                    presence.put(Math.round(y), true);
                    if(i ==0){
                        count+=4l;
                    }else {
                        count+=8l;
                    }

                    if(count > k){
                        return "impossible";
                    }
                }

            }
        }
        if(k >= count) {
            return "possible";
        }else{
            return "impossible";
        }
    }

    public static void encryption(String text){
        int len = text.length();
        int row = (int)Math.round(Math.floor(Math.sqrt(len)));
        int col = (int)Math.round(Math.ceil(Math.sqrt(len)));
        if((row * col) < len){
            row +=1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < col; i++ ){
            for(int j=0; j < row; j++){
                int index = i + (j * col);
                if(index >= len){
                    break;
                }
                sb.append(text.charAt(index) + "");
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());

    }

    public static void miniMax(long[] arr, int N, long P, long Q){
        Arrays.sort(arr);
        long lo = P;
        long hi = Q;
        while(lo < hi){
            long mid = (lo + hi)/2;
            long diff_lo = getMiniDist(arr,N, lo);
            long diff_hi = getMiniDist(arr,N, hi);
            if( diff_lo >= diff_hi){
                long diff_mid = getMiniDist(arr, N, mid);
                if(diff_mid > diff_lo){
                    lo= mid;
                }else{
                    hi =mid-1;
                }
            }else{
                lo = mid;
            }
        }
        System.out.println(lo);
    }

    public static long getMiniDist(long[] arr, int N, long num){
        long mini = Long.MAX_VALUE;
        int i = 0;
        while((i < N-1) && Math.abs(arr[i]-num) < mini){
            mini = Math.abs(arr[i++] - num);
        }
        return mini;
    }

    public static void main(String[] args) throws Exception{

       BufferedReader in = new BufferedReader(new FileReader("/home/abhishek/abc.txt"));
        int N = Integer.parseInt(in.readLine());
        long[] arr = new long[N];
        String[] str = in.readLine().split(" ");
        for(int i =0; i< N; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        String[] str1 = in.readLine().split(" ");

        long P = Long.parseLong(str1[0]);
        long Q = Long.parseLong(str1[1]);
        miniMax(arr, N, P, Q);
        in.close();
    }



}
