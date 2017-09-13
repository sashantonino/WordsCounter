package com.gladunalexander.wordcounter.utils;

/**
 * Created by user on 08/09/2017.
 */
public class FilterUtils {

   private static final char[] specialChars = {'.', ',', '"', ']', '[', ':', '>', '<', '?', '!', '/',
                                               '-', '+', '*', '{', '}', '@', '#', '$', '%', '^', '&', ';'};

    private FilterUtils() {}

    public static String withoutSpecialChars(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (char element : specialChars){
           if (stringBuilder.toString().contains(String.valueOf(element))){
               stringBuilder.deleteCharAt(stringBuilder.indexOf(String.valueOf(element)));
           }
       }
       return stringBuilder.toString();
    }
}
