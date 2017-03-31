package es.training.hackerrank.minimumdistance;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        int minDist = Integer.MAX_VALUE;
        for(int A_i=0; A_i < n; A_i++){
        	A[A_i] = in.nextInt();
        	for(int j = 0; (j < A_i) && (minDist > 1); j++){
        		if (A[j] == A[A_i]){
        			if (minDist > Math.abs(A_i-j)) {
        				minDist = Math.abs(A_i-j);
        			}            			
        		}
        	}
        }
        in.close();
        if (minDist == Integer.MAX_VALUE){
        	minDist = -1;
        }
        System.out.println(minDist);
    }
}
