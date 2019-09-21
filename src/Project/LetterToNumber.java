package Project;

import java.util.Scanner;

public class LetterToNumber {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您想转化的字母");
        String input=sc.nextLine();
        for (int i = 0; i <input.length() ; i++) {
            switch (input.charAt(i)){
                case 'a':;
                case 'A':;
                case 'b':;
                case 'B':;
                case 'c':;
                case 'C':System.out.print(2);
                break;
                case 'd':;
                case 'D':;
                case 'e':;
                case 'E':;
                case 'f':;
                case 'F':System.out.print(3);
                    break;
                case 'g':;
                case 'G':;
                case 'h':;
                case 'H':;
                case 'i':;
                case 'I':System.out.print(4);
                    break;
                case 'j':;
                case 'J':;
                case 'k':;
                case 'K':;
                case 'l':;
                case 'L':System.out.print(5);
                    break;
                case 'm':;
                case 'M':;
                case 'n':;
                case 'N':;
                case 'o':;
                case 'O':System.out.print(6);
                    break;
                case 'p':;
                case 'P':;
                case 'q':;
                case 'Q':;
                case 'r':;
                case 'R':;
                case 's':;
                case 'S':System.out.print(7);
                    break;
                case 't':;
                case 'T':;
                case 'u':;
                case 'U':;
                case 'v':;
                case 'V':System.out.print(8);
                    break;
                case 'w':;
                case 'W':;
                case 'x':;
                case 'X':;
                case 'y':;
                case 'Y':;
                case 'z':;
                case 'Z':System.out.print(9);

            }

        }

    }
}
