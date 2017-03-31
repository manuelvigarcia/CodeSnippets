package es.training.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		int positivos = 0;
		int negativos = 0;
		for(int arr_i=0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
			if (arr[arr_i] > 0) {
				positivos++;
			} else {
				if (arr[arr_i] < 0){
					negativos++;
				}
			}
		}
		System.out.format("%f%n%f%n%f%n", positivos/(float)arr.length, negativos/(float)arr.length,
				(arr.length-positivos-negativos)/(float)arr.length);
	}
}
