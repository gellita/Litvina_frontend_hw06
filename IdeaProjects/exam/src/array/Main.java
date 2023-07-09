package array;

import java.util.Scanner;

// 5 1 2 33 144 123 - true,1
// 5 1 22 3 444 555 - false,1
public class Main {
    static int digitsInNumber(int x) {
        int c = 0;
        while (x > 0) {
            x /= 10;
            c++;
        }

        return c;
    }

    static boolean isSorted(int a[]) {
        boolean flag = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (digitsInNumber(a[i]) > digitsInNumber(a[i + 1])) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    static int bigElemnt(int a[]) {
        int c = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > a[i + 1] && a[i] > a[i - 1]) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(isSorted(arr));
        System.out.println(bigElemnt(arr));


    }
}