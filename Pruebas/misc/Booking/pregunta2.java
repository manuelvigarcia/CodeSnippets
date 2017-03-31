# Specification: function takes two strings as inputs, and returns whether the second string contains the correct characters (and enough of each character) to spell the first string
you can assume there's  afunction String.split which returns an array of characters in teh string, "surveillance".split() would return [ 's', 'u', 'r', ... ]
examples:
  myfunc("evil", "surveillance") = true
  myfunc("evil", "validity") = FALSE (validity does not contain an e)
myfunc("arroz","aroz") = true; # false
myfunc("aroz", "arroz") = true
int findCharInArray(char a[], char c); // returns first index of c in s or -1 if a[] does not contain c
boolean myfunc (String target, String source) {
    char targetArray [];
    char sourceArray [];
    targetArray = target.split();
    sourceArray = source.split();
    for (int i = 0; i < targetArray.lenght; i++)
        {
        if (-1 == findCharInArray(sourceArray, targetArray[i])
            {
            return false;
            }
        else
            {
            targetArray[i] = invalidCharConstant;
            }
        }
    return true;

    }