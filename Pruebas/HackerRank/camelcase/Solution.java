package es.training.hackerrank.camelcase;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int i = 0;
		int palabras = 0;
        StringBuilder sb = new StringBuilder(s);
        while (i < s.length()){
        	if (s.charAt(i) < Character.valueOf('Z') + 1){
				palabras ++;
        	}
            i++;
        }
        palabras++;
        System.out.println(palabras);
     }
}
