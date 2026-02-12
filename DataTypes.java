/*
Author : [Muhammad Nafis Idris]
Class  : [1D]
NIM    : [251524115]
*/

import java.util.*;
import java.math.BigInteger;

public class DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            BigInteger n = sc.nextBigInteger();
            boolean fit = false;

            if (n.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 &&
                n.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
                if (!fit) {
                    System.out.println(n + " can be fitted in:");
                    fit = true;
                }
                System.out.println("* byte");
            }

            if (n.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 &&
                n.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
                if (!fit) {
                    System.out.println(n + " can be fitted in:");
                    fit = true;
                }
                System.out.println("* short");
            }

            if (n.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 &&
                n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
                if (!fit) {
                    System.out.println(n + " can be fitted in:");
                    fit = true;
                }
                System.out.println("* int");
            }

            if (n.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 &&
                n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                if (!fit) {
                    System.out.println(n + " can be fitted in:");
                    fit = true;
                }
                System.out.println("* long");
            }

            if (!fit) {
                System.out.println(n + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }
}
