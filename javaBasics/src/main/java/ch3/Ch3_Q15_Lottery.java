package ch3;

import java.util.Scanner;

public class Ch3_Q15_Lottery {
    public static boolean matchAllDigits(int num, int randomNum) {
        int[] arr = new int[10];
        while (randomNum != 0) {
            int digit = randomNum % 10;
            arr[digit] += 1;
            randomNum /= 10;
        }
        while (num != 0) {
            int digit = num % 10;
            arr[digit] -= 1;
            num /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if(arr[i] != 0)
                return false;
        }
        return true;
    }

    public static boolean matchAnyDigit(int num, int randomNum){
        String strNum = String.valueOf(num);
        String strRandomNum = String.valueOf(randomNum);
        for (int i = 0; i < strNum.length(); i++) {
            if(strRandomNum.indexOf(strNum.charAt(i)) != -1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int randomNum = (int) (Math.random() * 1000);
        System.out.println(randomNum);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == randomNum) {
            System.out.println("You're awarded $10000");
        } else if (matchAllDigits(num, randomNum)){
            System.out.println("You're awarded $5000");
        } else if (matchAnyDigit(num, randomNum)){
            System.out.println("You're awarded $1000");
        } else {
            System.out.println("Thenga");
        }
    }
}
