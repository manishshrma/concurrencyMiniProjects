package org.tryout;

import java.util.Scanner;

public class Code {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        int n=scr.nextInt();
        codeprint(n);
    }
    private static void codeprint(int n) {
        int star = 1;
        int space = n-1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <space; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= star; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= star; j++) {
                if(i!=0)
                System.out.print(j);
            }
            System.out.println();
            star++; space--;
        }
    }
}
