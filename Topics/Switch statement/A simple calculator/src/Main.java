import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long val1 = scanner.nextLong();
        String operator = scanner.next();
        long val2 = scanner.nextLong();

        switch(operator) {
            case "+":{System.out.print(val1+val2);break;}
            case "-":{System.out.print(val1-val2);break;}
            case "/":{if (val2 == 0) {System.out.print("Division by 0!");} else System.out.print(val1/val2);break;}
            case "*":{System.out.print(val1*val2);break;}
            default: {System.out.print("Unknown operator");break;}
        }

    }
}