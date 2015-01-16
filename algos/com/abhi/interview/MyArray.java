package com.abhi.interview;

/**
 * Created by abhishek
 * Created on 12/20/14.
 */

import java.util.*;

public class MyArray {

    final static int NA = -1;

     /*
        Given an array A[] of n numbers and another number x,
        determines whether or not there exist two elements in A whose sum is exactly x
     */
    static boolean sumExist(int[] A, int sum){

        if(A == null  || A.length < 1) return false;
        Map<Integer, Boolean> numMap = new HashMap();
        for( int i =0; i < A.length; i++){
            if(numMap.containsKey(sum - A[i])){
                System.out.println(A[i] + " ," + (sum - A[i]));
                return true;
            }
            numMap.put(A[i], true);
        }
        return false;
    }

    //Method 2 Using sorting
    static boolean sumExists(int[] A, int sum){
        Arrays.sort(A);
        int l =0;
        int r = A.length - 1;
        while( l < r) {
            if( A[l] + A[r] == sum){
                return true;
            }else if( A[l] + A[r] < sum){
                l++;
            }else{
                r--;
            }
        }
        return false;
    }

    /*
        Majority Element: A majority element in an array A[] of size n is an element
        that appears more than n/2 times
     */
    static public boolean majorityElement(int[] A){
        Map<Integer, Integer> numMap = new HashMap();
        for(int i = 0; i < A.length; i++){
            if(numMap.containsKey(A[i])){
                int count = numMap.get(A[i]);
                if(count + 1 > A.length/2){
                        System.out.println("Majority Element Found  =  " + A[i]);
                        return true;
                }
                numMap.put(A[i] , count + 1);
            }else{
                numMap.put(A[i], 1);
            }
        }
        return false;
    }

    /*
    Given an array of positive integers. All numbers occur even number of times except one
     number which occurs odd number of times. Find the number in O(n) time & constant space.
     */
    static int getOdd(int[] A){
        int res = 0;
        for( int i =0; i < A.length; i++){
            res = res ^ A[i];
        }
        return res;
    }

    /*
       Find the sum of contiguous subarray within a one-dimensional array of numbers
        which has the largest sum. [Kadane's Algorithm]
     */
    static int maxSumSubArray(int[] A ) {
        int curr_max = A[0];
        int overall_max = A[0];
        for(int i = 1; i < A.length; i++){
            curr_max = Math.max(A[i], A[i] + curr_max);
            overall_max = Math.max(curr_max, overall_max);
        }
        return overall_max;
    }

    /*
    You are given a list of n-1 integers and these integers are in the range of 1 to n.
    There are no duplicates in list. One of the integers is missing in the list. Find the missing integer.
     */
    static int missingNum(int[ ] A, int n){
        int sum = (n * (n+1))/2;
        for( int i = 0; i < A.length; i++){
            sum = 	sum - A[i];
        }
        return sum;
    }

    /*
        Code for Binary Search
     */
    static boolean bsearch(int[] A, int lo, int hi, int num){

        while(lo <= hi){
            int mid = ( hi + lo )/2;
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

    /*
        Search an element in a sorted and pivoted array
     */
    static boolean pivotSearch(int[] A, int num){

        int pivot = findPivot(A, 0, A.length-1);
        if( pivot == -1){
            return bsearch(A, 0, A.length-1, num);
        }
        if( A[0] < num){
            return bsearch(A, 0, pivot, num);
        }else{
            return bsearch(A, pivot+1, A.length -1, num);
        }
    }

    /*
        Find the pivoted element's index
     */
    static int findPivot( int[] A, int lo, int hi) {
        if(lo < hi){
            return -1;
        }else if( lo == hi){
            return lo;
        }

        int mid = (lo + hi)/2;
        if(mid < hi &&  A[mid] > A[mid+1] ){
            return mid;
        }else if( mid > lo && A[mid] < A[mid-1]) {
            return mid-1;
        }else if(A[lo] >= A[mid] ){
            return findPivot(A, lo, mid -1);
        }else{
            return findPivot(A, mid+1, hi);
        }
    }

    /*
        There are two sorted arrays. First one is of size m+n containing only m elements.
        Another one is of size n and contains n elements. Merge these two arrays into the first array
        of size m+n such that the output is sorted.
     */

    static void mergeArray(int[] mPlusN, int[] N){
        moveAside(mPlusN);
        int i = 0;
        int j = N.length;
        for( int k = 0; k < mPlusN.length; k++){
            if( i == N.length){
                mPlusN[k] = mPlusN[j++];
            }else if( j == mPlusN.length){
                mPlusN[k] = N[i++];
            }else if( N[i] < mPlusN[j] ){
                mPlusN[k] = N[i++];
            }else{
                mPlusN[k] = mPlusN[j++];
            }
        }
    }

    static void moveAside(int[] mPlusN){
        int size = mPlusN.length;
        int j = size -1;
        for( int i = size -1; i >=0; i --){
            if(mPlusN[i] != NA){
                mPlusN[j--] = mPlusN[i];
            }
        }
    }

    /*
          Reverse an array
     */
    static void reverse(int[] A, int start, int end){
        while(start < end){
            int temp = A[start];
            A[start++] = A[end];
            A[end--] = temp;
        }
    }

    /*
     You are given an array of 0s and 1s in random order.
     Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
     */
    static int zeroAside(int [] A) {
        int i = 0;
        while(i < A.length && A[i] != 0 ){
            i++;
        }
        if(i < A.length){
            int k = i;
            while( i != A.length-1){
                if(A[i] != 0){
                    A[k++] = A[i];
                    A[i++] = 0;
                }else{
                    i++;
                }
            }
            return k;
        }else {
            return -1;
        }
    }

    /*
     An element is leader if it is greater than all the elements to its right side.
      And the rightmost element is always a leader.
      For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
     */

    static void arrayLeader(int[] A){
        if(A.length == 0)  return;
        int leader = A[A.length-1];
        System.out.print(leader + " ");

        for(int i = A.length-2; i >= 0; i--){
            if(A[i] > leader){
                leader = A[i];
                System.out.print(leader + " ");

            }
        }
    }

    /*
    An Array of integers is given, both +ve and -ve.
    You need to find the two elements such that their sum is closest to zero.
     */
    static void sumClosestZero(int [ ] A){
        Arrays.sort(A);
        int l =0;
        int r = A.length-1;
        int min_sum = A[l] + A[r];
        int min_l = A[l];
        int min_r = A[r];
        while(l < r){
            int sum = A[l] + A[r];
            if( Math.abs(sum) < Math.abs(min_sum)){
                min_sum = sum;
                min_l = A[l];
                min_r = A[r];
            }
            if( sum > 0 ){
                r--;
            }else{
                l++;
            }
        }
        System.out.println("Close to zero sum : " + min_sum);
        System.out.println("The numbers are : " + min_l  + ",  " + min_r);
    }

    /*
    Given an array find the maximum sum of a subsequence with the constraint that
     no 2 numbers in the sequence should be adjacent in the array.
     So 3 2 7 10 should return 13
     */
    public static int maxSumWithoutAdjacent(int[] a){

        int excl = 0;
        int incl = a[0];
        for(int i=1; i < a.length; i++){
            int prev_incl = incl;
            incl = excl + a[i];
            excl = Math.max(prev_incl, excl);
        }
        return Math.max(excl, incl);
    }

    /*
        Union of two arrays
     */

    public static int[] unionArray(int[] a, int[] b){

        int n1 = a.length;
        int n2 = b.length;
        if(n1 <= 0 && n2 <= 0) return null;
        if(n1 <= 0) return b;
        if(n2 <= 0) return a;

        int i =0; int j =0;
        List<Integer> union = new ArrayList<>();
        while(i < n1 || j < n2){
            if(i == n1){
                union.add(b[j++]);
            }else if(j == n2){
                union.add(a[i++]);
            }else if(a[i] > b[j]){
                union.add(b[j++]);
            }else if(a[i] < b[j]){
                union.add(a[i++]);
            }else{
                union.add(a[i++]); j++;
            }
        }
        int[] c = new int[union.size()];
        for(int k=0;k < union.size(); k++){
            c[k] = union.get(k);
        }
        return c;
    }

    /*
       Given an array arr[] of integers, find out the difference between any two elements such that
       larger element appears after the smaller number in arr[]
     */
    public static int maxSumLargestAtRight(int[] a){

        int n = a.length;
        if( n <=0)  return -1;
        int min_element = a[0];
        int max_diff = a[1] - a[0];
        for(int i =1; i< n; i++){
            if( a[i] < min_element){
                min_element = a[i];
            }
            if(( a[i] - min_element) > max_diff){
                max_diff = a[i] - min_element;
            }
        }
        return max_diff;
    }


    public static MaxMin getMaxMin(int[ ] A, int start, int end){

        if(start == end){
            return new MaxMin(A[start], A[start]);
        }else if( (end - start + 1) == 2){
            return MaxMin.compare(A[start], A[end]);
        }else{
            int mid = (start + end)/2;
            MaxMin left = getMaxMin(A, start, mid);
            MaxMin right = getMaxMin(A, mid+1, end);
            return MaxMin.compareObj(left, right);
        }
    }


    public static void shuffle(int[] a){
        Random rand = new Random();
        for(int i =0; i < a.length; i++){
            int j = rand.nextInt(i+1);
            swap(a, i, j);
        }
    }


    public static void qsort(int[] a){
        //   shuffle(a);
        qsort(a, 0, a.length-1);
    }

    private static void qsort(int[] a, int lo, int hi){
        if( lo >=hi) return;
        int k = partition(a, lo, hi);
        qsort(a, lo, k-1);
        qsort(a, k+1, hi);
    }

    private static int partition( int[]a, int lo, int hi){
        int i =lo;
        int j =hi+1;
        while(true){
            while( a[++i] < a[lo]){
                if( i == hi) break;
            }
            while( a[--j] > a[lo]){
                if( j == lo) break;
            }
            if( i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public static void swap(int[]a, int pos1, int pos2){
        int temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }

    public static int quickSelect(int[]a, int k){
        shuffle(a);
        int lo= 0;
        int hi = a.length -1;
        while( lo < hi){
            int j = partition(a, lo, hi);
            if(j < k) {
                lo = j+1;
            }else if( j > k ){
                hi = j-1;
            }else{
                return a[k];
            }
        }
        return a[k];
    }

    public static void heapSort(int[] a){

        int N = a.length-1;
        for(int i = N/2; i >=0; i--){
            sink( a, i, N);
        }

        while( N > 0){
            swap(a, 0, N);
            sink(a, 0, --N);
        }
    }

    private static void sink(int[] a, int k, int N){
        while( (2*k +1 <= N)){

            int j = 2*k+1;
            if( j < N && a[j]< a[j+1]){
                j++;
            }
            if(a[k] > a[j]){
                break;
            }
            swap(a, j, k);
            k = j;
        }
    }


    public static void main(String[] args) {
        int[] A = {1,2,6,80,100,300};
        //int[] B = {13,200,-51,10,17,43,26};
        //Arrays.sort(A);
        //Arrays.sort(B);
        //int[] C = unionArray(A, B);
        System.out.println(maxSumLargestAtRight(A));

       // System.out.println(maxSumWithoutAdjacent(A));
        //int[] A = {-1,2,3,34,6,-4,56,0};
       /* heapSort(A);
       // System.out.println(quickSelect(A, 5));
        System.out.println(Arrays.toString(A));
*/
      //  qsort(A);
        //MaxMin mx = MyArray.getMaxMin(A, 0, A.length-1);
        //System.out.println(mx);
        //Arrays.sort(A);
        //System.out.println(Arrays.toString(A));
        //arrayLeader(A);
        //System.out.println(Arrays.toString(A));


    }
}

class MaxMin {
    int max;
    int min;

    public MaxMin(int max, int min){
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return "MaxMin{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

    public static MaxMin compare(int x, int y){
        if(x > y){
            return new MaxMin(x,y);
        }else{
            return new MaxMin(y,x);
        }
    }

    public static MaxMin compareObj(MaxMin left, MaxMin right){

        if(left.max < right.max){
            left.max = right.max;
        }
        if(left.min > right.min){
            left.min = right.min;
        }
        return left;
    }


}