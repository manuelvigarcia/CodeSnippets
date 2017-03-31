/**
 * N_in_Range.java 14/06/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package es.training.experimentos.ninrange;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 14/06/2016
 *
 */
public class N_in_Range {
    int[][] test_datainput = {
            {-11,      1}
            ,{-10,     2}
            ,{-9,      3}
            ,{-8,     -2}
            ,{-7,     -1}
            ,{-6,      0}
            ,{-5,      1}
            ,{-4,      2}
            ,{-3,      3}
            ,{-2,     -2}
            ,{-1,     -1}
            ,{ 0,      0}
            ,{ 1,      1}
            ,{ 2,      2}
            ,{ 3,     -2}
            ,{ 4,     -1}
            ,{ 5,      0}
            ,{ 6,      1}
            ,{ 7,      2}
            ,{ 8,     -2}
            ,{ 9,     -1}
            ,{10,      0}
    };
    int min = -2;
    int max = 3;

    int rangeIt(final int value){
        final int range = Math.abs(this.max - this.min)+1;
        final int start = Math.abs(value - this.min);
        int result = (start % range);
        System.out.print(value + "(starting at: " + start + "; modulus: " + result);
        result += this.min;
        System.out.print(", result: " + result +") ");
        return result;
    }

    int rangeIT2(final int value) {
        if (value >= this.min) {
            return ((value - this.min)%(this.max-this.min)) + this.min;
        }
        return (this.max - ((this.max - value) % (this.max - this.min))) +1;
    }

    /**
     *
     *
     * @param args
     */
    public static void main(final String[] args) {
        final N_in_Range test = new N_in_Range();
        System.out.println("Range: [" + test.min + ", " + test.max + "] : " + ((test.max-test.min)+1));
        for(final int[] i : test.test_datainput) {
            System.out.println(i[0] + " -> " + test.rangeIt(i[0]));
        }
        System.out.println();
        for(final int[] i : test.test_datainput) {
            System.out.println(i[0] + " -> " + test.rangeIT2(i[0]) + " = " + i[1]);
        }

    }

}
