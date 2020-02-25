import java.util.Scanner;

public class MyPr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[4];
        System.out.print("Введите количество купюр номиналом 1000:  ");
        int a = in.nextInt();
        System.out.print("Введите количество купюр номиналом 500:   ");
        int b = in.nextInt();
        System.out.print("Введите количество купюр номиналом 100:   ");
        int c = in.nextInt();
        System.out.print("Введите количество купюр номиналом 30:    ");
        int d = in.nextInt();
        System.out.println("----------------------------------------------------------");

        if (a != 0 || b != 0 || c != 0 || d != 0) {
            System.out.println("В наличие следующие купюры: ");
            System.out.print("     ");
            if (a != 0) {
                System.out.print("1000(x" + a + ")   ");
            }
            if (b != 0) {
                System.out.print("500(x" + b + ")    ");
            }
            if (c != 0) {
                System.out.print("100(x" + c + ")    ");
            }
            if (d != 0) {
                System.out.print("30(x" + d + ")     ");
            }
        }
        System.out.println("");
        System.out.print("Введите сумму, которую желаете получить:  ");
        int s = in.nextInt();
        while (s % 100 != 0 && s > 0 && d > 0) {
            s -= 30;
            d--;
            arr[3]++;
        }
        while (a > 0 && s >= 1000) {
            s -= 1000;
            a--;
            arr[0]++;
        }
        while (b > 0 && s >= 500) {
            s -= 500;
            b--;
            arr[1]++;
        }
        while (c > 0 && s >= 100) {
            s -= 100;
            c--;
            arr[2]++;
        }
        if (s == 0) {
            if (arr[0] != 0 || arr[1] != 0 || arr[2] != 0 || arr[3] != 0) {
                System.out.println("Вы получите следующие купюры в соответствующем количестве:   ");
                System.out.print("     ");
                if (arr[0] != 0) {
                    System.out.print("1000(x" + arr[0] + ")   ");
                }
                if (arr[1] != 0) {
                    System.out.print("500(x" + arr[1] + ")    ");
                }
                if (arr[2] != 0) {
                    System.out.print("100(x" + arr[2] + ")    ");
                }
                if (arr[3] != 0) {
                    System.out.print("30(x" + arr[3] + ")     ");
                }
            }
            System.out.println("");
            System.out.println("----------------------------------------------------------");
        } else {
            while (d > 0 && s >= 30) {
                s -= 30;
                d--;
                arr[3]++;
            }
            if (s == 0) {
                if (arr[0] != 0 || arr[1] != 0 || arr[2] != 0 || arr[3] != 0) {
                    System.out.println("Вы получите следующие купюры в соответствующем количестве:   ");
                    System.out.print("     ");
                    if (arr[0] != 0) {
                        System.out.print("1000(x" + arr[0] + ")   ");
                    }
                    if (arr[1] != 0) {
                        System.out.print("500(x" + arr[1] + ")    ");
                    }
                    if (arr[2] != 0) {
                        System.out.print("100(x" + arr[2] + ")    ");
                    }
                    if (arr[3] != 0) {
                        System.out.print("30(x" + arr[3] + ")     ");
                    }
                }
                System.out.println("");
                System.out.println("----------------------------------------------------------");
            } else
                System.out.print("Данную сумму невозможно выдать. Обратитесь в другой банкомат");
        }
    }
}