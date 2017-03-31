Write a function that receives an array of integers. Its job is to find the sequence of three subsequent integers with highest mean value and return it as an array.
 
Example:
 
IN:
  [1 2 3 3 4 5 2 3 4 6 4 2]
 
OUT:
  [3 4 5]
 
 
so here I am.
 
 
int[] findHighestMean( someArray){
    int highestMeanFirst = 0;
    double highestMean = 0;
    double mean;
    for (int i=0; i<someArray.length -2; i++){
        mean = (someArray[i]+someArray[i+1]+someArray[i+2])/3.0;
        if (mean > highestMean){
            highestMean = mean;
            highestMeanFirst = i;
            }
        }
    int result[3];
    for (int i = 0; i < 3; i++){
        resutl[i] = someArray[highestMeanFirst + i];
        }
    return result;
    }