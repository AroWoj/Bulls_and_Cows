import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
            int[] m = {a,b,c};
            int max =m[0];
            int idxMax = 0;
            for(int i = 0;i < m.length; i++ ){
                if (m[i] > max) { max=m[i]; idxMax = i; }
            }
        return idxMax+1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();


        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}