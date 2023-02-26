import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int val = scanner.nextInt();
        switch (val) {
            case 1: {System.out.print("Yes!");break;}
            case 2,3,4: {System.out.print("No!");break;}
            default: {System.out.print("Unknown number");break;}
        }
    }
}