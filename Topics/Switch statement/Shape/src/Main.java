import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String str = "You have chosen a ";
         switch (i) {
             case 1: {str+="square"; break;}
             case 2: {str+="circle"; break;}
             case 3: {str+="triangle"; break;}
             case 4: {str+="rhombus"; break;}
             default:{str="There is no such shape!";break;}
         }
         System.out.print(str);

    }
}