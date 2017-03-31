/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intelygenz;

/**
 *
 * @author ManuelVicente
 */
class Solution1 {
    public boolean findWordInMatrix (String [][]matrix, String word){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (word.compareTo(matrix[i][j]) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public long calculateDiagonalSum (int [][] matrix){
        if (matrix.length > 0){
            int col = 0;
            int fil = 0;
            long sum = 0;
            while (true){
                sum = sum + (long) matrix[fil++][col++];
                if ((fil == matrix.length) || (col == matrix[0].length)){
                    return sum;
                }
            }
            
        } else return -1; //no hay matriz
        
    }
    
    public String capitalize (String s){
        if (s != null) {
            int length = s.length();
            if (length > 0){
                StringBuilder result = new StringBuilder(s);
                char letra = result.charAt(0);
                if (letra != ' '){
                    result.setCharAt(0, s.substring(0,1).toUpperCase().charAt(0));
                }
                for (int i = 1; i < length-1; i++){
                    if ((result.charAt(i-1) == ' ') || (result.charAt(i+1) == ' ')){
                        result.setCharAt(i, s.substring(i,i+1).toUpperCase().charAt(0));
                    }
                }
                letra = result.charAt(length-1);
                if (letra != ' '){
                    result.setCharAt(length-1, s.substring(length-1,length).toUpperCase().charAt(0));
                }
                return result.toString();
                
            } else {
                throw new IllegalArgumentException();
            }
        } else {
                throw new IllegalArgumentException();
        }
     
    }
}

public class Intelygenz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Solution1 s = new Solution1();
        String [][] X = {
            {"bxc", "aee", "caa"}
           ,{"mtyu", "xny"}
           ,{"zee"}
        };
        if (!s.findWordInMatrix(X, "mtyu")) System.out.println("Fail!");
        
        int [][] Y = {
            { 1, 2, 3 }
           ,{ 4, 5, 6 }
           ,{ 7, 8, 9 }
        };
        if (s.calculateDiagonalSum(Y) != 15) System.out.println("Fail!2");
        if (s.capitalize("esta es una frase").compareTo("EstA ES UnA FrasE") != 0) System.out.println("Fail!3");
    }
    
}
