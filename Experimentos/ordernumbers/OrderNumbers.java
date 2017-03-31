/**
 * OrderNumbers.java 02/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package es.training.experimentos.ordernumbers;

import java.util.Scanner;

/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 02/05/2016
 *
 */
public class OrderNumbers {

    /**
     * Execution of the main routine.
     *
     * @param args Not used
     */
    public static void main(final String[] args) {

        int num = 0;
        int num1 = 0;
        int num2 = 0;
        int big = 0;
        int small = 0;
        int medium = 0;

        System.out.println("Please insert 3 numbers: ");
        final Scanner number = new Scanner (System.in);

        if (number.hasNextInt())
        {
            num = number.nextInt();
            big=num;
        }

        if (number.hasNextInt())
        {
            num1 = number.nextInt();
            if(num1>num)
            {
                big=num1;
                small = num;
            } else {
                small = num1;
            }


        }

        if (number.hasNextInt())
        {
            num2 = number.nextInt();
            if (num2 > big) {
                medium = big;
                big = num2;
            } else {
                if (num2 < small) {
                    medium = small;
                    small = num2;
                } else {
                    medium = num2;
                }

            }

            System.out.println(big+ ">" +medium+ ">" +small);
        }
        else
        {
            System.out.println("Error: Invalid Value.");
        }
        number.close();
    }
}
