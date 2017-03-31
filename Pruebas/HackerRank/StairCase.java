package es.training.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StairCase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] chanzo = new char[n];
		Arrays.fill(chanzo, ' ');
		for (int i = n - 1; i >= 0; i--) {
			chanzo[i] = '#';
			System.out.println(String.valueOf(chanzo));
		}
	}

}
