package com.abhi.interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhishek
 * Unity Id : akagrawa
 * Created on 12/23/14.
 */
public class Strings {

    static void getMaxCharacter( String str){

        char[] arr = str.toCharArray();
        int max =0;
        char max_c = '0';
        int[] count = new int[256];
        for(int i =0; i < arr.length; i++){
            count[(int) arr[i] ]++;
            if(max < count[(int) arr[i]]){
                max = count[(int) arr[i]];
                max_c = arr[i];
            }
        }
        System.out.println("Maximum Occurring Character = " + max_c + " ,count = " + max );
    }

    static String removeDuplicates(String str){

        String res = "";
        char[] arr = str.toCharArray();
        int[] count = new int[256];
        for(int i =0; i < arr.length; i++){
            if( count[(int) arr[i]] == 0 ){
                count[(int) arr[i]]++;
                res += arr[i];
            }
        }
        return res;
    }

    static void printDuplicates(String str){
        char[] arr = str.toCharArray();
        int[] count = new int[256];
        for( int i =0; i < arr.length; i++){
            count[(int) arr[i]]++;
        }
        for(int i =0; i < count.length; i++){
            if(count[i] > 1){
                System.out.print( (char) i  + "  ");
            }
        }
    }

    static boolean isRotation(String str1, String str2){
        if( str1.length() != str2.length()){
            return false;
        }
        str1 = str1+str1;
        return str1.contains(str2);
    }

    static String removeFromSecond(String str1, String str2){
        String res = "";
        char[] arr = str1.toCharArray();
        int[] count = new int[256];
        for(int i =0; i< arr.length; i++){
            count[(int) arr[i]]++;
        }
        arr = str2.toCharArray();
        for(int i =0; i < arr.length; i++){
            if(count[(int)arr[i]] < 1){
                res +=arr[i];
            }
        }
        return res;
    }

    static void printReverse(String str, int len){
        if(len >= 0){
            System.out.print(str.charAt(len));
            printReverse(str, len - 1);
        }
    }

    static String reverse(String str){
        int len = str.length();
        char[] arr = str.toCharArray();
        for(int i =0; i < len/2 ; i++){
            char c = arr[i];
            arr[i] = arr[len-1-i];
            arr[len-1-i] = c;
        }
        return new String(arr);
    }

    static void doPerm(StringBuffer sb, int index){
        if(index <= 0){
            System.out.println(sb);
        }else{
            doPerm(sb, index-1);
            int currPos = sb.length()-index;
            for(int i = currPos+1; i < sb.length(); i++){
                swap(sb, currPos, i);
                doPerm(sb, index-1);
                swap(sb, i, currPos);
            }
        }
    }

    static void swap(StringBuffer sb, int pos1, int pos2){
        char c = sb.charAt(pos1);
        sb.setCharAt(pos1, sb.charAt(pos2));
        sb.setCharAt(pos2, c);
    }

    static void firstNonRepeatingChar( String str){

        char[] arr = str.toCharArray();
        Map<Character, Integer> charMap = new LinkedHashMap();
        for(int i =0; i < arr.length; i++){
            if(charMap.get(arr[i]) == null){
                charMap.put(arr[i], 1);
            }else{
                charMap.put(arr[i], charMap.get(arr[i])+1);
            }
        }
        for(Map.Entry<Character, Integer> entry : charMap.entrySet() ){
            if(entry.getValue() == 1){
                System.out.println("First non-repeating character = " + entry.getKey());
                break;
            }
        }
    }

    static void containsChars( String str, List<String> sequences){

        if(str.length() < 1 || sequences.size() < 1) return;
        Map<Character, Boolean> charMap = new HashMap();
        char[] arr = str.toCharArray();
        for(int i =0; i < arr.length; i++){
            charMap.put(arr[i], true);
        }
        for( String seq : sequences){
            arr = seq.toCharArray();
            int counter = 0;
            for( int i =0; i < arr.length; i++){
                if(charMap.containsKey(arr[i])){
                    counter++;
                }
            }
            if(counter == str.length()){
                System.out.println("The sequence [" + seq + "] contains the characters of : " +  str);
            }
        }
    }

    static String reverseWords(String str){

        str = reverse(str, 0, str.length()-1);
        String[] subs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String substr : subs){
            sb.append(reverse(substr, 0, substr.length()-1)).append(" ");
        }
        return sb.toString();
    }

    static String reverse(String str, int pos1, int pos2){

        char[] arr = str.toCharArray();
        int n = pos2 - pos1 +1;
        for(int i = pos1, k=0; i <n/2; i++, k++){
            char c = arr[i];
            arr[i] = arr[pos2-k];
            arr[pos2-k] = c;
        }
        return new String(arr);
    }

    static String runLengthEncode(String str){
        StringBuffer sb = new StringBuffer();
        char c = str.charAt(0);
        int count = 0;
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) == c){
                count++;
            }else{
                sb.append(c).append(count);
                c= str.charAt(i);
                count = 1;
            }
        }
        sb.append(c).append(count);
        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println(runLengthEncode("aabbrrrrrrrruuuuss"));
        //System.out.println(reverseWords("My name is Abhishek"));
        //List<String> sequences = Arrays.asList("Sunday", "Monday", "Tuesday","daily","father");
         //containsChars("day", sequences);
         //   firstNonRepeatingChar("a");
        //StringBuffer sb = new StringBuffer("abc");
        //doPerm(sb, sb.length());
   //     System.out.println(reverse("Abhishek"));
        //   printReverse("Abhishek", "Abhishek".length()-1);
        //System.out.println(removeFromSecond("abcdasasd", "bdaghfdhrtaswrghg"));
        // printDuplicates("aabbhhiissjjeeddek");
        //getMaxCharacter("MynAbhishek");
      //  System.out.println(removeDuplicates("Abhishek"));

    }
}
