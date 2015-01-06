package com.abhi.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhishek
 * Unity Id : akagrawa
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

    public static void printArray(int[] ar) {
        for(int n : ar){
            System.out.print(n + " ");
        }
        System.out.println();
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
