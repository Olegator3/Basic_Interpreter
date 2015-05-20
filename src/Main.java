import java.util.Scanner;

/**
 * Created by ПК on 19.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Interpeter interpeter = new Interpeter();

        while (true){
            String line = sc.nextLine();
            interpeter.parse(line);
        }

    }
}
