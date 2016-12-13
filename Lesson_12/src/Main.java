public class Main {

    static final String[] NUM_FROM_10_TO_19 = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static final String[] NUM_FOR_TENS = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static final String[] NUM_FOR_ONES = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


    public static void main(String[] args) {
	// write your code here


        System.out.println(convertToString(999999));



    }


    public static String convertToString (int n){
        String res = null;
        int x1 = 0, x2 = 0;
        if (n / 1000 > 0) {x1 = n%1000;
           res =  intNumToStringNum(n / 1000, 2) + intNumToStringNum(x1, 1);
        }




        return res;
    }


    public static String intNumToStringNum(int inputNum, int razr) {
        String razrStr;
        razrStr = " hundred ";
        if (razr == 2) razrStr = " thousand(s) ";
        if (razr == 3) razrStr = " hundred ";
        if (inputNum == 0) return "zero";
        else if (inputNum / 10 == 0) {
            return NUM_FOR_ONES[inputNum];
        } else if (inputNum / 100 == 0) {
            if (inputNum >= 10 && inputNum < 20) return NUM_FROM_10_TO_19[inputNum - 10];
            else return NUM_FOR_TENS[inputNum / 10] + " " + NUM_FOR_ONES[inputNum % 10];
        } else if (inputNum / 1000 == 0) {
            if (inputNum % 100 >= 10 && inputNum % 100 < 20)
                return NUM_FOR_ONES[inputNum / 100] + razrStr + NUM_FROM_10_TO_19[inputNum % 100 - 10];
            else
                return NUM_FOR_ONES[inputNum / 100] + razrStr + NUM_FOR_TENS[inputNum % 100 / 10] + " " + NUM_FOR_ONES[inputNum % 10];
        } else return "Число должно быть от 0 до 999";
}}
