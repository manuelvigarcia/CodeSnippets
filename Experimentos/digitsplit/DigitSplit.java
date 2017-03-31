/**
 * DigitSplit.java 03/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package es.training.experimentos.digitsplit;

import java.util.Scanner;

/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 03/05/2016
 *
 */
public class DigitSplit {

    /**
     * 
     *
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("Please type a number: ");
        final Scanner number = new Scanner (System.in);

        if (number.hasNextInt())
        {
            final int num = number.nextInt();
            final String numString = String.valueOf(num);
            for (int i = 0; i < (numString.length() - 1); i++) {
                System.out.println(String.format("%s%-0"+(numString.length() - i-1)+"d",
                        String.valueOf(numString.charAt(i)),0));
                System.out.print(String.valueOf(numString.charAt(i)));

                final StringBuilder tail = new StringBuilder();
                for (int j = 0; j < (numString.length() - i-1); j++) {
                    tail.append('0');
                }
                System.out.println(tail);
            }
            System.out.println(numString.charAt(numString.length() - 1));
        }
    }
}
