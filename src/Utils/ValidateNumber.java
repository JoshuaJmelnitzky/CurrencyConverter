package Utils;

import java.util.Scanner;

public class ValidateNumber {
    public int validate(int min, int num, int max) {
        while (num > max || num < min) {
            Scanner sc = new Scanner(System.in);
            System.out.println("El numero debe estar entre " + min + " y " + max + ": ");
            num = sc.nextInt();
        }
        return num;
    }
}
