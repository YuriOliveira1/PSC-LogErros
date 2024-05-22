import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static int menuLoja(Scanner scam) {
        boolean isTrue = false;
        int option = 0;

        while (!isTrue) {
            System.out.println("1 - Rat with Flame Armor and Magical Bow and Arrow | 10BTC");
            System.out.println("2 - Raccoon With T Virus Wearing Leon's Outfit | 44BTC");
            System.out.println("3 - STEM from The Evil Whitin | 666BTC");
            System.out.println("4 - Exit");

            try {
                option = scam.nextInt();

                if (option >= 1 && option <= 4) {
                    isTrue = true;
                } else {
                    System.out.println("Enter a correct option, Dumb");
                }
            } catch (InputMismatchException e) {
                log(e);
                System.out.println("Enter a correct option, Dumb ");
                scam.nextLine();
            } catch (Exception e) {
                log(e);
                System.out.println("Error: ");
                scam.nextLine();
            }
        }
        return option;
    }

    public static void log(Exception e) {
        try (FileWriter write = new FileWriter("C:\\Users\\firey\\Documents\\logs.txt", true); // Abre o Arquivo e Habilita a Escrita no final do Arquivo
                PrintWriter pWriter = new PrintWriter(write)) { // Qualquer Texto Escrito Será Enviado Ao Arquivo de Log
            StringWriter wWriter = new StringWriter(); // Armazena os Dados em Buffer
            e.printStackTrace(new PrintWriter(wWriter)); // Mantém em um Buffer os caracteres, serve quando temos varias parte de uma String e serve como Saída
            pWriter.println(wWriter.toString()); // Escreve o Stack Trace no Arquivo
        } catch (IOException e1) {
            System.err.println("Error" + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scam = new Scanner(System.in);
        Price prices = new Price();

        int option = 1;

        System.out.println(
                "Welcome to the lonf Store, here you can buy unlimited products for BitCoin. We do not accept DogeCoin "
                        + "\n");

        while (option != 4) {
            option = menuLoja(scam);

            if (option == 1) {
                prices.buy(1);
            } else if (option == 2) {
                prices.buy(2);
            } else if (option == 3) {
                prices.buy(3);
            } else if (option == 4) {
                System.out.println("Exiting...");
            }
        }
        System.out.println("Final Price: " + prices.returnPrice() + "BTC");
    }
}
