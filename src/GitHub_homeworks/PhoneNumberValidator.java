package GitHub_homeworks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneNumberValidator {
    private static String num;
    private static int sum;
    private static int sum2;
    private static int sum3;

    public static void main(String[] args) {
        enterNumber();
        validate();
    }
    private static void enterNumber(){
        Scanner number = new Scanner(System.in);
        System.out.println("Enter you phone number");
        num = number.nextLine();
    }
    private static void validate(){
        Pattern p = Pattern.compile("^\\+?(38)?\\(?0[9,6,5][9,8,7,6,3,0]\\)?[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{2}$");
        Matcher m = p.matcher(num);

        if (m.matches()){
            System.out.println("Number is correct");
            numberExtraction();
            sumCalculate();
            numberOutput();
        }
        else {
            System.out.println("Wrong number, enter the right one!");
            enterNumber();
            validate();
        }
    }
    private static void numberExtraction() {
        String newNum = num.replaceAll("\\D","");

        char[] chArray = newNum.toCharArray();
        System.out.println(chArray);
        for (char c : chArray){
            sum += Character.getNumericValue(c);
        }
        System.out.println("sum = "+sum);
    }
    private static void sumCalculate(){
        while(sum !=0){
            sum2 += (sum%10);
            sum /= 10;
        }
        System.out.println("sum2 = "+sum2);

        if (sum2<10){
            sum3=sum2;
        }
        if (sum2>9){
            sumNextCalculate();
        }
    }
    private static void sumNextCalculate(){
        while(sum2 !=0){
            sum3 += (sum2%10);
            sum2 /= 10;
        }
        System.out.println("sum3 = "+sum3);
    }
    private static void numberOutput(){
        switch (sum3){
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
        }
    }
}

